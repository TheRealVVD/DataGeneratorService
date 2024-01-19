package org.example.model.test;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.model.DataGenerator;

@NoArgsConstructor
@Getter
@Setter
public class DataTestOptions {

    private int delayInSeconds;
    private DataGenerator.MeasurementType[] measurementTypes;

}
