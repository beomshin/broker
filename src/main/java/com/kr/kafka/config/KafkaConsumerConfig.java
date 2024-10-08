package com.kr.kafka.config;

import com.kr.kafka.AlarmEvent;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ContainerProperties;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
public class KafkaConsumerConfig {


    @Value("${kafka.bootstrapAddress}")
    private String bootstrapServers;

    @Value("${kafka.consumer.autoOffsetResetConfig}")
    private String autoOffsetResetConfig;

    @Value("${kafka.consumer.alarm.rdb-group-id}")
    private String rdbGroupId;

    @Value("${kafka.consumer.alarm.redis-group-id}")
    private String redisGroupId;

//    @Bean
////    @Qualifier("alarmEventRDBConsumerFactory")
//    public ConsumerFactory<String, AlarmEvent> alarmEventRDBConsumerFactory() {
//        Map<String, Object> props = new HashMap<>();
//        props.put(ConsumerConfig.GROUP_ID_CONFIG, rdbGroupId);
//        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
//        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, autoOffsetResetConfig);
//        return new DefaultKafkaConsumerFactory<>(props,
//                new StringDeserializer(),
//                new JsonDeserializer<>(AlarmEvent.class));
//    }
//
//    @Bean
//    public ConsumerFactory<String, AlarmEvent> alarmEventRedisConsumerFactory() {
//        Map<String, Object> props = new HashMap<>();
//        props.put(ConsumerConfig.GROUP_ID_CONFIG, redisGroupId);
//        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
//        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, autoOffsetResetConfig);
//        return new DefaultKafkaConsumerFactory<>(props,
//                new StringDeserializer(),
//                new JsonDeserializer<>(AlarmEvent.class));
//    }

//    @Bean
//    public ConcurrentKafkaListenerContainerFactory<String, AlarmEvent> kafkaListenerContainerFactoryRDB() {
//        ConcurrentKafkaListenerContainerFactory<String, AlarmEvent> factory =
//                new ConcurrentKafkaListenerContainerFactory<>();
//        factory.setConsumerFactory(alarmEventRDBConsumerFactory());
//        factory.getContainerProperties().setAckMode(ContainerProperties.AckMode.MANUAL);
//        return factory;
//    }
//
//    @Bean
//    public ConcurrentKafkaListenerContainerFactory<String, AlarmEvent> kafkaListenerContainerFactoryRedis() {
//        ConcurrentKafkaListenerContainerFactory<String, AlarmEvent> factory =
//                new ConcurrentKafkaListenerContainerFactory<>();
//        factory.setConsumerFactory(alarmEventRedisConsumerFactory());
//        factory.getContainerProperties().setAckMode(ContainerProperties.AckMode.MANUAL);
//        return factory;
//    }
}
