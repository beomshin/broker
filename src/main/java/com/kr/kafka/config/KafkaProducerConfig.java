package com.kr.kafka.config;

import com.fasterxml.jackson.databind.JsonSerializer;
import com.kr.kafka.AlarmEvent;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaProducerConfig {


    @Value("${kafka.bootstrapAddress}")
    private String bootstrapServers;

    /**
     * ack: all
     * In-Sync-Replica에 모두 event가 저장되었음이 확인 되어야 ack 신호를 보냄 가장 성능은 떨어지지만
     * event produce를 보장할 수 있음.
     */
    @Value("${kafka.producer.acksConfig}")
    private String acksConfig;

    @Value("${kafka.producer.retry}")
    private Integer retry;

    @Value("${kafka.producer.enable-idempotence}")
    private Boolean enableIdempotence;
    @Value("${kafka.producer.max-in-flight-requests-per-connection}")
    private Integer maxInFlightRequestsPerConnection;

    /**
     * enable.idempotence true를 위해서는 retry가 0이상,
     * max.in.flight.requests.per.connection 은 5이하여야한다.
     * @return
     */
//    @Bean
//    public ProducerFactory<String, AlarmEvent> producerFactory() {
//        Map<String, Object> configProps = new HashMap<>();
//        configProps.put(ProducerConfig.ACKS_CONFIG, acksConfig);
//        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
//        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
//        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
//        configProps.put(ProducerConfig.RETRIES_CONFIG, retry);
//        configProps.put(ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG, enableIdempotence);
//        configProps.put(ProducerConfig.MAX_IN_FLIGHT_REQUESTS_PER_CONNECTION, maxInFlightRequestsPerConnection);
//
//        return new DefaultKafkaProducerFactory<>(configProps);
//    }
//
//    @Bean
//    public KafkaTemplate<String, AlarmEvent> kafkaTemplate() {
//        return new KafkaTemplate<String, AlarmEvent>(producerFactory());
//    }

}
