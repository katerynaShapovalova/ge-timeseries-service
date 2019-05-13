package com.timeseries.db.model;


import lombok.Data;
import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@PrimaryKeyClass
public class TimeseriesKey implements Serializable{

    public TimeseriesKey(String guid, BigDecimal timestamp) {
        this.guid = guid;
        this.timestamp = timestamp;
    }

    @PrimaryKeyColumn(name = "guid", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private String guid;

    @PrimaryKeyColumn(name = "timestamp", ordinal = 1, type = PrimaryKeyType.CLUSTERED, ordering = Ordering.DESCENDING)
    private BigDecimal timestamp;


}
