package com.ypan.project.rocketmq;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

public class SyncProducer {

    public static void main(String[] args) throws Exception {

        DefaultMQProducer mqProducer = new DefaultMQProducer("pg");
        mqProducer.setNamesrvAddr("101.43.34.30:9876");
        mqProducer.setRetryTimesWhenSendFailed(3);
        mqProducer.setSendMsgTimeout(1000000);
        mqProducer.start();
        // 生产并发送100条消息
        for (int i = 0; i < 100; i++) {
            byte[] body = ("Hi," + i).getBytes();
            Message msg = new Message("someTopic", "someTag", body); // 为消息指定key
            msg.setKeys("key--" + i);
            // 发送消息
            SendResult sendResult = mqProducer.send(msg);
            System.out.println("-======" + sendResult);
        }
        // 关闭producer
        mqProducer.shutdown();
    }


}
