package com.bigking.springboot.config.beans;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "spring.kafka-cluster")
@Component
@Data
public class ProducerConfigsBean {
    private String bootstrap_servers;
    private String retry;
    private String batch_size;
    private String ack;
    private String buffer_memory;
    private String linger_ms;
}
