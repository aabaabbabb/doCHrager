package com.gaozhiyuan.doCharage.elong;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class ElongApiClient {
    private static final String HOTEL_STATIC_INFO_METHOD = "hotel.static.info";
    private static final Type MAP_TYPE = new TypeToken<Map<String, Object>>() {
    }.getType();

    private final ElongApiProperties properties;
    private final OkHttpClient httpClient;
    private final Gson gson;

    public ElongApiClient(ElongApiProperties properties) {
        this.properties = properties;
        this.gson = new GsonBuilder().disableHtmlEscaping().create();
        this.httpClient = new OkHttpClient.Builder()
            .connectTimeout(properties.getConnectTimeoutSeconds(), TimeUnit.SECONDS)
            .readTimeout(properties.getTimeoutSeconds(), TimeUnit.SECONDS)
            .writeTimeout(properties.getTimeoutSeconds(), TimeUnit.SECONDS)
            .build();
    }

    public Map<String, Object> getHotelStaticInfoWithOptions(String hotelId, String options) {
        Map<String, String> query = buildHotelStaticInfoQuery(hotelId, options, currentUnixTimestamp());
        return sendRequest(query);
    }

    public Map<String, String> buildHotelStaticInfoQuery(String hotelId, String options, long timestamp) {
        Map<String, Object> baseParams = buildHotelStaticInfoPayload(hotelId, options);
        String data = encodeData(baseParams);
        String signature = generateSignature(data, timestamp);

        Map<String, String> query = new LinkedHashMap<>();
        query.put("format", properties.getFormat());
        query.put("method", HOTEL_STATIC_INFO_METHOD);
        query.put("user", properties.getUsername());
        query.put("timestamp", String.valueOf(timestamp));
        query.put("signature", signature);
        query.put("data", data);
        return query;
    }

    private Map<String, Object> buildHotelStaticInfoPayload(String hotelId, String options) {
        Map<String, Object> request = new LinkedHashMap<>();
        request.put("HotelId", hotelId);
        request.put("Options", options);

        Map<String, Object> baseParams = new LinkedHashMap<>();
        baseParams.put("Version", properties.getVersion());
        baseParams.put("Local", properties.getLocal());
        baseParams.put("Request", request);
        return baseParams;
    }

    private Map<String, Object> sendRequest(Map<String, String> query) {
        HttpUrl baseUrl = HttpUrl.parse(properties.getProdUrl());
        if (baseUrl == null) {
            throw new IllegalStateException("Invalid Elong API URL: " + properties.getProdUrl());
        }

        HttpUrl.Builder urlBuilder = baseUrl.newBuilder();
        for (Map.Entry<String, String> entry : query.entrySet()) {
            urlBuilder.addQueryParameter(entry.getKey(), entry.getValue());
        }

        Request request = new Request.Builder()
            .url(urlBuilder.build())
            .header("Accept", "application/json")
            .get()
            .build();

        try (Response response = httpClient.newCall(request).execute()) {
            ResponseBody body = response.body();
            String responseBody = body == null ? "" : body.string();
            if (!response.isSuccessful()) {
                throw new IllegalStateException("Elong API HTTP error: " + response.code() + ", body: " + responseBody);
            }
            return gson.fromJson(responseBody, MAP_TYPE);
        } catch (IOException e) {
            throw new IllegalStateException("Elong API request failed: " + e.getMessage(), e);
        }
    }

    private String encodeData(Map<String, Object> data) {
        return gson.toJson(data);
    }

    private String generateSignature(String data, long timestamp) {
        String hash = md5(data + properties.getAppKey());
        return md5(timestamp + hash + properties.getSecretKey());
    }

    private long currentUnixTimestamp() {
        return System.currentTimeMillis() / 1000;
    }

    private static String md5(String value) {
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            byte[] bytes = digest.digest(value.getBytes(StandardCharsets.UTF_8));
            StringBuilder builder = new StringBuilder(bytes.length * 2);
            for (byte b : bytes) {
                builder.append(String.format("%02x", b & 0xff));
            }
            return builder.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("MD5 algorithm is not available", e);
        }
    }
}
