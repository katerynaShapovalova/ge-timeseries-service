package com.timeseries.mapper;

import com.timeseries.db.model.Timeseries;
import com.timeseries.db.model.TimeseriesKey;
import com.timeseries.dto.ItemType;
import com.timeseries.dto.TimeseriesDTO;
import org.mapstruct.Mapper;

import java.math.BigDecimal;

@Mapper(componentModel = "spring")
public abstract class TimeseriesMapper implements EntityMapper<TimeseriesDTO, Timeseries> {

    @Override
    public Timeseries toEntity(TimeseriesDTO dto) {
        if (dto == null) {
            return null;
        }

        Timeseries timeseries = new Timeseries();

        BigDecimal timestamp = null;
        if (dto.getTimestamp() != null) {
            timestamp = BigDecimal.valueOf(dto.getTimestamp());
        }
        if (timestamp != null) {
            timeseries.setPk(new TimeseriesKey(dto.getGuid(), timestamp));
        }
        timeseries.setType(ItemType.fromString(dto.getType()));
        timeseries.setValue(dto.getValue());

        return timeseries;
    }

    @Override
    public TimeseriesDTO toDto(Timeseries entity) {
        if (entity == null) {
            return null;
        }

        TimeseriesDTO timeseriesDTO = new TimeseriesDTO();

        TimeseriesKey pk = entity.getPk();
        if (pk != null) {
            timeseriesDTO.setGuid(pk.getGuid());
            timeseriesDTO.setTimestamp(pk.getTimestamp().longValue());
        }
        timeseriesDTO.setType(entity.getType().getValue());
        timeseriesDTO.setValue(entity.getValue());

        return timeseriesDTO;
    }
}
