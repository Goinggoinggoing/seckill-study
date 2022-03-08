package com.example.seckilldemo.rabbitmq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 消息发送者
 *
 * @author: LC
 * @date 2022/3/7 7:42 下午
 * @ClassName: MQSender
 */
@Service
@Slf4j
public class MQSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;


    /**
     * 发送秒杀信息
     * @author LiChao
     * @operation add
     * @date 6:44 下午 2022/3/8
     * @param message
     * @return void
     **/
    public void sendSeckillMessage(String message) {
        log.info("发送消息" + message);
        rabbitTemplate.convertAndSend("seckillExchange", "seckill.message", message);
    }


//    public void send(Object msg) {
//        log.info("发送消息：" + msg);
////        rabbitTemplate.convertAndSend("queue", msg);
//        rabbitTemplate.convertAndSend("fanoutExchange", "", msg);
//    }
//
//
//    public void send01(Object msg) {
//        log.info("发送red" + msg);
//        rabbitTemplate.convertAndSend("directExchange", "queue.red", msg);
//    }
//
//    public void send02(Object msg) {
//        log.info("发送red" + msg);
//        rabbitTemplate.convertAndSend("directExchange", "queue.green", msg);
//    }
//
//
//    public void send03(Object msg) {
//        log.info("发送消息(QUEUE01接收)：" + msg);
//        rabbitTemplate.convertAndSend("topicExchange", "queue.red.message", msg);
//    }
//
//
//    public void send04(Object msg) {
//        log.info("发送消息(QUEUE02接收)：" + msg);
//        rabbitTemplate.convertAndSend("topicExchange", "green.queue.green.message", msg);
//    }
//
//
//    public void send05(String msg) {
//        log.info("发送消息(QUEUE01和QUEUE02接收)：" + msg);
//        MessageProperties properties = new MessageProperties();
//        properties.setHeader("color", "red");
//        properties.setHeader("speed", "fast");
//        Message message = new Message(msg.getBytes(), properties);
//        rabbitTemplate.convertAndSend("headersExchange", "", message);
//    }
//
//    public void send06(String msg) {
//        log.info("发送消息(QUEUE01接收)：" + msg);
//        MessageProperties properties = new MessageProperties();
//        properties.setHeader("color", "red");
//        properties.setHeader("speed", "normal");
//        Message message = new Message(msg.getBytes(), properties);
//        rabbitTemplate.convertAndSend("headersExchange", "", message);
//    }


}
