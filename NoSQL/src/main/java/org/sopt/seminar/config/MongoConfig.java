package org.sopt.seminar.config;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

import java.util.Arrays;

/**
 * Created by ds on 2018-11-27.
 */

@Configuration
public class MongoConfig extends AbstractMongoConfiguration {

    @Value("${spring.data.mongodb.username}")
    private String userName;

    @Value("${spring.data.mongodb.password}")
    private String password;

    @Value("${spring.data.mongodb.database}")
    private String database;

    @Override
    public MongoClient mongoClient() {
        MongoCredential credential = MongoCredential.createCredential(userName, database, password.toCharArray());
        return new MongoClient(new ServerAddress("localhost", 27017), Arrays.asList(credential));
    }

    @Override
    protected String getDatabaseName() {
        return null;
    }
}
