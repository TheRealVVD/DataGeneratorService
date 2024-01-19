package org.example.service;

import org.example.model.DataGenerator;

public interface KafkaDataService {

    void send(DataGenerator dataGenerator);

}
