package com.microservice.email.controller.dto.request;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class EmailDtoRequest {

    @NotNull
    @NotBlank
    private String ownerRef;

    @NotNull
    @NotBlank
    @Email
    private String emailFrom;

    @NotNull
    @NotBlank
    @Email
    private String emailTo;

    @NotNull
    @NotBlank
    private String subject;

    @NotNull
    @NotBlank
    private String text;

}
