package com.timeseries.db.model;

import com.timeseries.dto.ItemType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;
import java.util.UUID;

@Data
@Table("timeseries")
public class Timeseries {

    @PrimaryKey
    private TimeseriesKey pk;

    @Column
    @Enumerated(EnumType.STRING)
    private ItemType type;

    @Column
    private String value;
}
