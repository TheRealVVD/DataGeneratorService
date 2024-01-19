package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.model.DataGenerator;
import org.example.model.test.DataTestOptions;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class TestDataServiceImpl implements TestDataService {

    private final ScheduledExecutorService executorService
            = Executors.newSingleThreadScheduledExecutor();
    private final KafkaDataService kafkaDataService;

    @Override
    public void sendMessages(DataTestOptions testOptions) {
        if (testOptions.getMeasurementTypes().length > 0) {
            executorService.scheduleAtFixedRate(
                    () -> {
                        DataGenerator dataGenerator = new DataGenerator();
                        dataGenerator.setRaining(
                                new Random().nextBoolean()
                        );
                        dataGenerator.setMeasurementValue(
                                getRandomMeasurement(-50, 40)
                        );
                        dataGenerator.setTimestamp(
                                LocalDateTime.now()
                        );
                        dataGenerator.setMeasurementType(
                                getRandomMeasurementType(
                                        testOptions.getMeasurementTypes()
                                )
                        );
                        dataGenerator.setSensorName(
                                getRandomSensorName()
                        );
                        kafkaDataService.send(dataGenerator);
                    },
                    0,
                    testOptions.getDelayInSeconds(),
                    TimeUnit.SECONDS
            );
        }
    }

    private String getRandomSensorName() {
        String[] cities = {"Irk", "Nsk", "SPb", "Msk"};
        int randomCityId = (int) (Math.random() * cities.length);

        return cities[randomCityId];
    }

    private DataGenerator.MeasurementType getRandomMeasurementType(
            DataGenerator.MeasurementType[] measurementTypes
    ) {
        int randomTypeId = (int) (Math.random() * measurementTypes.length);
        return measurementTypes[randomTypeId];
    }

    private Double getRandomMeasurement(int min, int max) {
        Double res;

        double tempSide = Math.random();
        if (tempSide < 0.5) {
            res = (Math.random() * (min - max)) + max;
        } else {
            res = (Math.random() * (max - min)) - max;
        }

        return res;
    }

}
