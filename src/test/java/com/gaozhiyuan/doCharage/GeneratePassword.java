package com.gaozhiyuan.doCharage;

import com.gaozhiyuan.doCharage.mapper.primary.XdAdminMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

@SpringBootTest
@Slf4j
public class GeneratePassword {

    @Autowired
    private XdAdminMapper xdAdminMapper;
    @Test
    public void doGeneratePassword(){
        String  verify = createNonceStr(6);
        String passWord = getAdminPassword("123456",verify);
        xdAdminMapper.updatePasswordById(passWord,1);
    }

    // 生成指定长度的随机字符串
    public String createNonceStr(int length) {
        // 定义可选字符集，包含大小写字母和数字
        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        // 使用 StringBuilder 来存储生成的随机字符串
        StringBuilder str = new StringBuilder();
        Random random = new Random();
        // 循环生成随机字符串，直到达到指定长度
        for (int i = 0; i < length; i++) {
            // 从字符集中随机选择一个字符并添加到字符串中
            int index = random.nextInt(chars.length());
            str.append(chars.charAt(index));
        }
        // 返回生成的随机字符串
        return str.toString();
    }

    // 使用 Java 8 的流和更简洁的代码实现
    public String getAdminPassword(String password, String verify) {
        try {
            // 使用 MD5 摘要算法
            MessageDigest md5 = MessageDigest.getInstance("MD5");

            // 计算 verify 的 MD5 值
            String verifyMd5 = bytesToHex(md5.digest(verify.getBytes()));

            // 计算 password + verifyMd5 的 MD5 值
            return bytesToHex(md5.digest((password + verifyMd5).getBytes()));

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    // 辅助方法：将字节数组转换为十六进制字符串
    private String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            String hex = String.format("%02x", b);  // 格式化输出为2位十六进制
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
