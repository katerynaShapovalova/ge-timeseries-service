package com.timeseries;

import com.timeseries.db.service.TimeseriesService;
import com.timeseries.dto.TimeseriesDTO;
import com.timeseries.mapper.TimeseriesMapper;
import lombok.RequiredArgsConstructor;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.type.CollectionType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@Service
public class TimeseriesProcessor {
    private static final Logger LOGGER = LoggerFactory.getLogger(TimeseriesProcessor.class);

    private final TimeseriesService timeseriesService;
    private final TimeseriesMapper timeseriesMapper;

    public void processTimeseries(String jsonTimeseries) {
        List<TimeseriesDTO> timeseriesMessage = null;

        ObjectMapper mapper = new ObjectMapper();
        CollectionType mapType = mapper.getTypeFactory().constructCollectionType(List.class, TimeseriesDTO.class);

        try {
            timeseriesMessage = mapper.readValue(jsonTimeseries, mapType);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (timeseriesMessage == null) {
            LOGGER.info("processed timeseriesMessage is null");
        } else {
            timeseriesService.saveAll(timeseriesMapper.toEntity(timeseriesMessage));
        }
    }

}
