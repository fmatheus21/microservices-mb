package com.microservice.email.adapter.config;


import com.microservice.email.EmailApplication;
import com.microservice.email.application.port.EmailRepositoryPort;
import com.microservice.email.application.port.EmailSendServicePort;
import com.microservice.email.application.service.EmailServicePortImpl;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = EmailApplication.class)
public class BeanConfiguration {

    @Bean
    EmailServicePortImpl emailSendServicePort(EmailRepositoryPort emailRepositoryPort, EmailSendServicePort emailSendServicePort) {
        return new EmailServicePortImpl(emailRepositoryPort, emailSendServicePort);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
