package com.hy.demo.demo.java8.base64;

import com.fasterxml.jackson.databind.ser.Serializers;

import java.util.Base64;
import java.util.UUID;

/**
 * 在Java8中，Base64编码已经成为Java类库的标准。
 * Java 8 内置了 Base64 编码的编码器和解码器。
 * Base64工具类提供了一套静态方法获取下面三种BASE64编解码器：
 * ·        基本：输出被映射到一组字符A-Za-z0-9+/，编码不添加任何行标，输出的解码仅支持A-Za-z0-9+/。
 * ·        URL：输出映射到一组字符A-Za-z0-9+_，输出是URL和文件。
 * ·        MIME：输出隐射到MIME友好格式。输出每行不超过76字符，并且使用'\r'并跟随'\n'作为分割。编码输出最后没有行分割。
 *
 * static class Base64.Decoder
 * 该类实现一个解码器用于，使用 Base64 编码来解码字节数据。
 *
 * static class Base64.Encoder
 * 该类实现一个编码器，使用 Base64 编码来编码字节数据。
 *
 * 方法
 *static Base64.Decoder getDecoder()
 * 返回一个 Base64.Decoder ，解码使用基本型 base64 编码方案。
 *
 * static Base64.Encoder getEncoder()
 * 返回一个 Base64.Encoder ，编码使用基本型 base64 编码方案。
 *
 * static Base64.Decoder getMimeDecoder()
 * 返回一个 Base64.Decoder ，解码使用 MIME 型 base64 编码方案。
 *
 * static Base64.Encoder getMimeEncoder()
 * 返回一个 Base64.Encoder ，编码使用 MIME 型 base64 编码方案。
 *
 * static Base64.Encoder getMimeEncoder(int lineLength, byte[] lineSeparator)
 * 返回一个 Base64.Encoder ，编码使用 MIME 型 base64 编码方案，可以通过参数指定每行的长度及行的分隔符。
 *
 *static Base64.Decoder getUrlDecoder()
 * 返回一个 Base64.Decoder ，解码使用 URL 和文件名安全型 base64 编码方案。
 *
 * static Base64.Encoder getUrlEncoder()
 * 返回一个 Base64.Encoder ，编码使用 URL 和文件名安全型 base64 编码方案。
 *
 *
 */
public class TestBase64 {

    public static void main(String[] args) throws  Exception{
        String encodeStr = Base64.getEncoder().encodeToString("base64?java8".getBytes("utf-8"));
        System.out.println("Base64 编码字符串 (基本) :" + encodeStr);

        byte[] decodeStr = Base64.getDecoder().decode(encodeStr);
        System.out.println("原字符串："+new String(decodeStr,"utf-8"));

        String encodeUrlStr = Base64.getUrlEncoder().encodeToString("qererdfadfa?java8".getBytes("utf-8"));
        System.out.println("Base64 编码字符串 (URL) :" + encodeUrlStr);

        StringBuffer sb = new StringBuffer();
        for(int i = 0;i<5;i++){
            sb.append(UUID.randomUUID().toString());
        }
        byte[] bytes = sb.toString().getBytes("utf-8");
        String encodeMineStr = Base64.getMimeEncoder().encodeToString(bytes);
        System.out.println("Base64 编码字符串 (MIME) :" + encodeMineStr);

    }
}
