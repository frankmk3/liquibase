package com.mongo.migration.liquibase.repository;

import com.mongo.migration.liquibase.model.Metric;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MetricRepository extends MongoRepository<Metric, String> {

    Optional<Metric> findByMetricIdAndZoneId(String metricId, String zoneId);
}
