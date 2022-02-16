package com.project.kafkaexample.config;

import java.util.HashMap;
import java.util.Map;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

public class KafkaProducerConfig {

    @Autowired
    private KafkaProperties kafkaProperties;

    @Value("${kafka.topic-name}")
    private String topicName;

    /*@Bean(value = "produConfigs")
    public Map<String, Object> producerConfigs() {
        Map<String, Object> props =
              new HashMap<>(kafkaProperties.buildProducerProperties());
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
              StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
              JsonSerializer.class);
        props.put(ProducerConfig.CLIENT_ID_CONFIG, "kafka-example");
        props.put(ProducerConfig.ACKS_CONFIG, "all");
        props.put(ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG, Boolean.TRUE);
        return props;
    }

    @Bean(value ="producerFactory")
    public ProducerFactory<String, Object> producerFactory(@Qualifier("produConfigs") Map producerConfigs) {
        return new DefaultKafkaProducerFactory<>(producerConfigs);
    }

    @Bean
    public KafkaTemplate<String, Object> kafkaTemplate(@Qualifier("producerFactory") ProducerFactory producerFactory) {
        return new KafkaTemplate<>(producerFactory);
    }*/

}
