package com.timeseries.db;

import com.timeseries.db.model.Timeseries;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TimeseriesRepository extends CassandraRepository<Timeseries, UUID> {
}
