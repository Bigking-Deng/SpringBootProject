package com.bigking.springboot.utils;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class KafkaConsumer {

    @KafkaListener(topics = "TestTopic", groupId = "group3", containerFactory = "kafkaConsumerFactory1")
    public void listenKafka(String message, Acknowledgment ack){
        log.info("Receive message: " + message);
        //ack.acknowledge();
    }
}
