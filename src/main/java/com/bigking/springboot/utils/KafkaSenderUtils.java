package com.bigking.springboot.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.FailureCallback;
import org.springframework.util.concurrent.SuccessCallback;

import javax.annotation.Resource;

@Slf4j
@Component
public class KafkaSenderUtils {

    @Resource(name = "kafkaTemplate")
    public KafkaTemplate kafkaTemplate;

    public static Gson gson;

    static {
        gson = new GsonBuilder().create();
    }

    public void sendMessageSync(String key, Object data, String topic){
        String dataStr = gson.toJson(data);
        try{
            kafkaTemplate.send(new ProducerRecord(topic, key, dataStr)).get();
        }catch (Exception ex){
            log.warn("data sent failed: " + ex.toString());
        }
    }


    public void sendMessageAsync(String key, Object data, String topic){
        String dataStr = gson.toJson(data);
        kafkaTemplate.send(topic, key, dataStr).addCallback(
                new SuccessCallback() {
                     @Override
                     public void onSuccess(Object result) {
                         log.info("data has been sent successfully! "+ result.toString());
                     }
                 },
                new FailureCallback() {
                    @Override
                    public void onFailure(Throwable ex) {
                        log.warn("data sent failed: " + ex.toString());
                    }
                }
        );
    }
}
