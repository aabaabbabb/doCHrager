package com.gaozhiyuan.doCharage.elong;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ElongApiClientTest {

    @Test
    void buildsHotelStaticInfoQueryWithPhpCompatibleSignature() {
        ElongApiProperties properties = new ElongApiProperties();
        properties.setUsername("api-user");
        properties.setAppKey("app-key");
        properties.setSecretKey("secret-key");

        ElongApiClient client = new ElongApiClient(properties);

        Map<String, String> query = client.buildHotelStaticInfoQuery("40101022", "1,3", 1700000000L);

        assertEquals("json", query.get("format"));
        assertEquals("hotel.static.info", query.get("method"));
        assertEquals("api-user", query.get("user"));
        assertEquals("1700000000", query.get("timestamp"));
        assertEquals("50710ef77ff51b95f7561d784d472c54", query.get("signature"));
        assertEquals(
            "{\"Version\":\"1.62\",\"Local\":\"zh_CN\",\"Request\":{\"HotelId\":\"40101022\",\"Options\":\"1,3\"}}",
            query.get("data")
        );
    }
}
