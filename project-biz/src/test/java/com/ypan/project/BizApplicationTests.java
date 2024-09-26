package com.ypan.project;

import com.alibaba.fastjson.JSON;
import com.ypan.project.entity.User;
import com.ypan.project.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

//@SpringBootTest
@Slf4j
class BizApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    void contextLoads() {

        String a = "123456";
        byte[] bytes = a.getBytes(StandardCharsets.UTF_8);
        for (byte aByte : bytes) {
            System.out.println(aByte);
        }
        log.info("bytes:{}", JSON.toJSONString(bytes));
    }

    @Test
    public void testOneOpt() {

        Optional<User> one = userService.lambdaQuery().eq(User::getName, "张三11").last("limit 1").oneOpt();
        if (one.isPresent()) {
            System.out.println(one);
        }else {
            System.out.println("----" + one);
        }
    }

    @Test
    public void testChar() throws UnsupportedEncodingException {
        String message = "12345Y2";
        byte[] bytes = message.getBytes(StandardCharsets.ISO_8859_1.name());
        byte five = bytes[5];
        log.info("five-byte:{}, five-char:{}", five, (char)five);
        byte four = bytes[4];
        log.info("four-byte:{}, four-char:{}", four, (char)four);

    }

    @Test
    void testBytes() throws IOException {
        User user = new User();
        user.setName("郝月攀");
        user.setId(1L);
        user.setPinyin("hyp");

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(user.getName());
        stringBuffer.append(user.getId());
        stringBuffer.append(user.getPinyin());
        byte[] bytes = stringBuffer.toString().getBytes(StandardCharsets.UTF_8);
        log.info("郝月攀:{}, length:{}", bytes, bytes.length);

        byte[] finalBytes = new byte[30];
        byte[] nameBytes = user.getName().getBytes(StandardCharsets.UTF_8);
        System.arraycopy(nameBytes, 0, finalBytes, 0, nameBytes.length);


        Long id = user.getId();
        byte idValue = id.byteValue();
        ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(arrayOutputStream);
        dataOutputStream.writeLong(id);
        byte[] bytes1 = arrayOutputStream.toByteArray();

        System.arraycopy(bytes1, 0, finalBytes, 9, bytes1.length);
        log.info("finalBytes:{}", finalBytes);
        // sdjsidfn
    }

    @Test
    public void testUserByException() {
        String a = "123";
        byte[] bytes = a.getBytes(StandardCharsets.UTF_8);
        for (int i = 0; i < bytes.length; i++) {
            System.out.println(bytes[i]);
        }
        System.out.println(JSON.toJSONString(bytes));
        a.equals("321");



    }


    @Test
    public void test33() {
        String s = "I";
        byte[] bytes = s.getBytes(StandardCharsets.UTF_8);
        System.out.println(JSON.toJSONString(bytes));
    }

    @Test
    public void testDealIo() throws IOException {
        int a = 12;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        dataOutputStream.writeInt(a);
        dataOutputStream.close();
        byte[] bytes = byteArrayOutputStream.toByteArray();
        System.out.println(JSON.toJSONString(bytes));


        ByteArrayOutputStream byteArrayOutputStream1 = new ByteArrayOutputStream();
        byteArrayOutputStream1.write(12);
        byte[] bytes1 = byteArrayOutputStream1.toByteArray();
        System.out.println(JSON.toJSONString(bytes1));
    }

    @Test
    public void test666() throws IOException {

        int a = 1169;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        dataOutputStream.writeInt(a);
        dataOutputStream.close();
        byte[] bytes = byteArrayOutputStream.toByteArray();
        System.out.println(JSON.toJSONString(bytes));


    }

    @Test
    public void  test88() {

        byte [] b = {(byte)0xE2, (byte)0x5c, (byte)0x4B, (byte)0x89};
        System.out.println(JSON.toJSONString(b));


    }
    public int test999(byte[] a) {

        int value = 0;
        for (int i = 0; i< 4;i++) {
            int shift = (3-i) * 8;
            value += (a[i] & 0xFF) << shift;
        }
        return value;

    }

    @Test
    public void testLong() {

        Long a = 11L;
        ++a;
        System.out.println(a);

    }

    @Test
    public void wei() {
        int e = 12345;
         e = e << 1;
        System.out.println(e);


    }


    @Test
    public void wei1() {
        int e = 12345;
        e = e << 33;
        System.out.println(e);


    }
}
