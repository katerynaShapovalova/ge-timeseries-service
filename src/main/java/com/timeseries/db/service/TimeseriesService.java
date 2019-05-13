package com.timeseries.db.service;

import com.timeseries.db.model.Timeseries;

import java.util.List;

public interface TimeseriesService {

    Timeseries save(Timeseries timeseries);

    List<Timeseries> saveAll(List<Timeseries> timeseries);

    List<Timeseries> findAll();
}
