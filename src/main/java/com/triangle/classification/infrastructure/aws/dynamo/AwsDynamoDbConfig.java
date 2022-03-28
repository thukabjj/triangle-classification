package com.triangle.classification.infrastructure.aws.dynamo;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableDynamoDBRepositories(basePackages = "com.triangle.classification.application.database.dynamo.triangle")
public class AwsDynamoDbConfig {

    @Value("${config.aws.region}")               private String region;
    @Value("${config.aws.dynamodb.url}")         private String dynamoDbEndpointUrl;
    @Value("${config.aws.dynamodb.access-key}")  private String accessKey;
    @Value("${config.aws.dynamodb.secret-key}")  private String secretKey;

    @Bean(name = "amazonDynamoDB")
    public AmazonDynamoDB amazonDynamoDB() {
        return AmazonDynamoDBClientBuilder.standard()
                .withCredentials(getCredentialsProvider())
                .withEndpointConfiguration(getEndpointConfiguration(dynamoDbEndpointUrl))
                .build();
    }

    private AwsClientBuilder.EndpointConfiguration getEndpointConfiguration(String url) {
        return new AwsClientBuilder.EndpointConfiguration(url, region);
    }

    private AWSStaticCredentialsProvider getCredentialsProvider() {
        return new AWSStaticCredentialsProvider(getBasicAWSCredentials());
    }

    private BasicAWSCredentials getBasicAWSCredentials() {
        return new BasicAWSCredentials(accessKey, secretKey);
    }
}