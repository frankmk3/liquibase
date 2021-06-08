package com.mongo.migration.liquibase.model;

import com.mongo.migration.liquibase.enums.ZoneDirection;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Document("metric")
public class Metric {

    private String metricId;
    private String zoneId;
    private ZoneDirection zoneDirection;
    private OffsetDateTime serviceTime;
    private OffsetDateTime openTime;
    private OffsetDateTime closeTime;
    private List<MetricsContainer> metricsContainers;
}

