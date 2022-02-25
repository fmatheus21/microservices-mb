package com.microservice.email.adapter.bound.inbound.consumer;

import com.microservice.email.adapter.bound.inbound.converter.EmailInboundConverter;
import com.microservice.email.adapter.dto.request.EmailDtoRequest;
import com.microservice.email.application.port.EmailServicePort;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {

    @Autowired
    private EmailInboundConverter converter;

    @Autowired
    EmailServicePort emailServicePort;

    @RabbitListener(queues = "${spring.rabbitmq.queue}")
    public void listen(@Payload EmailDtoRequest request) {
        var email = converter.converterRequest(request);
        emailServicePort.sendEmail(email);

    }

}
