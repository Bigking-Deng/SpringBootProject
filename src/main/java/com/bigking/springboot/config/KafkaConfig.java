package com.bigking.springboot.config;

import com.bigking.springboot.config.beans.ProducerConfigsBean;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.*;
import org.springframework.kafka.listener.AbstractMessageListenerContainer;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.listener.ContainerProperties;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConfig {

    @Autowired
    private ProducerConfigsBean producerConfigsBean;


    private Map<String, Object> producerConfigs(){
        Map<String, Object> prop = new HashMap<>();
        prop.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, producerConfigsBean.getBootstrap_servers());
        prop.put(ProducerConfig.ACKS_CONFIG, producerConfigsBean.getAck());
        prop.put(ProducerConfig.BATCH_SIZE_CONFIG, producerConfigsBean.getBatch_size());
        prop.put(ProducerConfig.BUFFER_MEMORY_CONFIG, producerConfigsBean.getBuffer_memory());
        prop.put(ProducerConfig.LINGER_MS_CONFIG, producerConfigsBean.getLinger_ms());
        prop.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        prop.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        prop.put(ProducerConfig.COMPRESSION_TYPE_CONFIG, "none");
        return prop;

    }


    public ProducerFactory<String, String> producerFactory(){
        return new DefaultKafkaProducerFactory<>(producerConfigs());
    }

    @Bean(name = "kafkaTemplate")
    public KafkaTemplate<String, String> kafkaTemplate(){
        return new KafkaTemplate<>(producerFactory());
    }


    private Map<String, Object> consumerConfigs(){
        Map<String, Object> prop = new HashMap<>();
        prop.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, producerConfigsBean.getBootstrap_servers());
        prop.put(ConsumerConfig.GROUP_ID_CONFIG, "defaultGroup");
        prop.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);
        prop.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, 200);
        prop.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        prop.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, 20);
        prop.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        prop.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        return prop;
    }

    public ConsumerFactory<String, String> consumerFactory(){
        return new DefaultKafkaConsumerFactory<>(consumerConfigs());
    }

    @Bean(name = "kafkaConsumerFactory1")
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, String>> kafkaListenerContainerFactory(){
        ConcurrentKafkaListenerContainerFactory<String, String>
                factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConcurrency(3);
        factory.setConsumerFactory(consumerFactory());
        factory.getContainerProperties().setPollTimeout(3000);
        factory.getContainerProperties().setAckMode(ContainerProperties.AckMode.MANUAL);
        return factory;
    }
}
