package com.mongo.migration.liquibase.configuration;

import liquibase.Liquibase;
import liquibase.ext.mongodb.database.MongoLiquibaseDatabase;
import liquibase.integration.spring.SpringResourceAccessor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.ResourceLoader;


public class MongoLiquibaseRunner implements CommandLineRunner, ResourceLoaderAware {

    @Value("${liquibase.change-log}")
    private String changeLogFile;

    public final MongoLiquibaseDatabase database;

    protected ResourceLoader resourceLoader;

    public void setResourceLoader(final ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    public MongoLiquibaseRunner(MongoLiquibaseDatabase database) {
        this.database = database;
    }

    public MongoLiquibaseRunner(MongoLiquibaseDatabase database, String changeLogFile) {
        this.database = database;
        this.changeLogFile = changeLogFile;
    }

    public void run(final String... args) throws Exception {
        try (
            Liquibase liquiBase = new Liquibase(
                changeLogFile,
                new SpringResourceAccessor(resourceLoader),
                database
            )
        ) {
            liquiBase.update("");
        }
    }

}
