package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DataGenerator {

    private Double measurementValue;
    private LocalDateTime timestamp;
    private Boolean raining;
    private String sensorName;
    private MeasurementType measurementType;

    public enum MeasurementType {
        VOLTAGE,
        POWER,
        TEMPERATURE
    }
}
