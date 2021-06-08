package com.mongo.migration.liquibase.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class MetricsContainer {

    private long position;
    private String contType;
    private Double totalVolume;
}
