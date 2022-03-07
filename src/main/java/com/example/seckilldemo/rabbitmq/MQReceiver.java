package com.example.seckilldemo.rabbitmq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 消息消费者
 *
 * @author: LC
 * @date 2022/3/7 7:44 下午
 * @ClassName: MQReceiver
 */
@Service
@Slf4j
public class MQReceiver {

    @RabbitListener(queues = "queue")
    public void receive(Object msg) {
        System.out.println("接收到的消息"+msg);
    }


    @RabbitListener(queues = "queue_fanout01")
    public void receive01(Object msg){
        log.info("QUEUE01接收消息"+msg);
    }

    @RabbitListener(queues = "queue_fanout02")
    public void receive02(Object msg){
        log.info("QUEUE02接收消息"+msg);
    }
}
