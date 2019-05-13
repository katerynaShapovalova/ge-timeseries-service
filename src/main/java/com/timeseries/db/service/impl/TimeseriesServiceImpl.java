package com.timeseries.db.service.impl;

import com.timeseries.db.TimeseriesRepository;
import com.timeseries.db.model.Timeseries;
import com.timeseries.db.service.TimeseriesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TimeseriesServiceImpl implements TimeseriesService {

    private final TimeseriesRepository timeseriesRepository;

    @Override
    public Timeseries save(Timeseries event) {
        return timeseriesRepository.save(event);
    }

    @Override
    public List<Timeseries> saveAll(List<Timeseries> timeseries){
        return timeseriesRepository.saveAll(timeseries);
    }

    @Override
    public List<Timeseries> findAll() {
        return timeseriesRepository.findAll();
    }
}
