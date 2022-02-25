package com.microservice.email.adapter.constant;

public class AppConstant {

    private AppConstant() {
        throw new IllegalStateException("Utility class");
    }

    public static final String RABBIT_QUEUE = "${spring.rabbitmq.queue}";
    public static final String RABBIT_ADDRESSES = "${rabbitmq.addresses}";
    public static final String DATASOURCE_URL = "${datasource.config.url}";
    public static final String DATASOURCE_USERNAME = "${datasource.config.username}";
    public static final String DATASOURCE_PASSWORD = "${datasource.config.password}";

}
