package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.model.DataGenerator;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.kafka.sender.KafkaSender;
import reactor.kafka.sender.SenderRecord;

@Service
@RequiredArgsConstructor
public class KafkaDataServiceImpl implements KafkaDataService {

    private final KafkaSender<String, Object> sender;

    @Override
    public void send(DataGenerator dataGenerator) {
        String topic = switch (dataGenerator.getMeasurementType()) {
            case POWER -> "power-topic";
            case TEMPERATURE -> "temperature-topic";
            case VOLTAGE -> "voltage-topic";
        };

        sender.send(
                        Mono.just(
                                SenderRecord.create(
                                        topic,
                                        0,
                                        System.currentTimeMillis(),
                                        String.valueOf(dataGenerator.hashCode()),
                                        dataGenerator,
                                        null
                                )
                        )
                )
                .subscribe();
    }

}
