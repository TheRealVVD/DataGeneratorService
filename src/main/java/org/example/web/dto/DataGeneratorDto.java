package org.example.web.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.model.DataGenerator;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
public class DataGeneratorDto {


    private Double measurementValue;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime timestamp;

    private Boolean raining;
    private String sensorName;
    private DataGenerator.MeasurementType measurementType;

}
