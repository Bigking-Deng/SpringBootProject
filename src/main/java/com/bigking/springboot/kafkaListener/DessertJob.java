package com.bigking.springboot.kafkaListener;

import com.bigking.springboot.bean.Dessert;
import com.bigking.springboot.bean.eunmBean.Status;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@Component

public class DessertJob {

    static Gson gson = new GsonBuilder().create();

    @KafkaListener(topics = "dessert", groupId = "kafka.dessert.processTopic1", containerFactory = "kafkaConsumerFactory1")
    public void processDessert(String dessertStr, ConsumerRecord<String, String> consumerRecord, Acknowledgment ack){
        try{
            Optional<?> optional1 = Optional.ofNullable(dessertStr);
            Optional<?> optional2 = Optional.ofNullable(consumerRecord.value());
            if(optional1.isPresent()){
                Dessert dessert1 = gson.fromJson(dessertStr, Dessert.class);
                dessert1.setStatus(Status.ON_SALE);
                dessert1.setPrice(dessert1.getPrice()+3);
                log.info("Grocery A receives dessert info successfully: " + dessert1.getId().substring(0, 6) + " dessert( "+dessert1.getCreateTime()+" ) is on sale with $"+ dessert1.getPrice());
            }
            if(optional2.isPresent()){
                Dessert dessert2 = gson.fromJson(consumerRecord.value(), Dessert.class);
                dessert2.setStatus(Status.ON_SALE);
                dessert2.setPrice(dessert2.getPrice()+3);
                log.info("Header: " + consumerRecord.headers() + "partition: " + consumerRecord.partition());
                log.info("Grocery B receives dessert info successfully: " + dessert2.getId().substring(0, 6) + " dessert( "+dessert2.getCreateTime()+" ) is on sale with $"+ dessert2.getPrice());
            }
        }catch (Exception e){
            log.error("receive failed: " + e.getMessage());
        }


    }
}
