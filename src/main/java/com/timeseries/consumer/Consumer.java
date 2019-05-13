package com.timeseries.consumer;


import com.timeseries.TimeseriesProcessor;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@RequiredArgsConstructor
@Service
public class Consumer {

    private final Logger LOGGER = LoggerFactory.getLogger(Consumer.class);

    private final TimeseriesProcessor timeseriesProcessor;

    @KafkaListener(topics = "${data.topic}", groupId = "group_id")
    public void processMessageTimeseries(String jsonTimeseries) throws IOException {
        LOGGER.info(String.format("#### -> Consumed message -> %s", jsonTimeseries));

        timeseriesProcessor.processTimeseries(jsonTimeseries);
    }
}
