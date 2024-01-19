package org.example.web.controller;

import lombok.RequiredArgsConstructor;
import org.example.model.DataGenerator;
import org.example.model.test.DataTestOptions;
import org.example.service.KafkaDataService;
import org.example.service.TestDataService;
import org.example.web.dto.DataGeneratorDto;
import org.example.web.dto.DataTestOptionsDto;
import org.example.web.mapper.DataMapper;
import org.example.web.mapper.DataTestOptionsMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/data")
@RequiredArgsConstructor
public class DataController {

    private final DataMapper dataMapper;
    private final KafkaDataService kafkaDataService;
    private final DataTestOptionsMapper dataTestOptionsMapper;
    private final TestDataService testDataService;

    @PostMapping("/send")
    public void send(@RequestBody DataGeneratorDto dataGeneratorDto) {
        DataGenerator dataGenerator = dataMapper.toEntity(dataGeneratorDto);
        kafkaDataService.send(dataGenerator);
    }

    @PostMapping("/test/send")
    public void testSend(@RequestBody DataTestOptionsDto testOptionsDto) {
        DataTestOptions dataTestOptions = dataTestOptionsMapper.toEntity(testOptionsDto);
        testDataService.sendMessages(dataTestOptions);
    }

}
