package com.microservice.email.controller.rabbit.consumer;

import com.microservice.email.controller.converter.EmailConverter;
import com.microservice.email.controller.dto.request.EmailDtoRequest;
import com.microservice.email.controller.sender.EmailSender;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmailRabbitConsumer {

    @Autowired
    private EmailConverter emailConverter;

    @Autowired
    private EmailSender emailSender;

    @RabbitListener(queues = "${spring.rabbitmq.queue}")
    public void listen(@Payload EmailDtoRequest request) {
        var email = emailConverter.converterRequestToEntity(request);
        emailSender.sendEmail(email);

    }

}
