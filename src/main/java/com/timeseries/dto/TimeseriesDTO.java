package com.timeseries.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class TimeseriesDTO {

    private String guid;

    private Long timestamp;

    private String type;

    private String value;

}
