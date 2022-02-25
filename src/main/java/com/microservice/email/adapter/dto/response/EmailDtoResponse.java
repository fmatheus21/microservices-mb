package com.microservice.email.adapter.dto.response;

import com.microservice.email.application.domain.enums.StatusEmailEnum;
import lombok.*;

import java.util.UUID;

@ToString
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmailDtoResponse {

    private UUID uuid;
    private String ownerRef;
    private String emailFrom;
    private String emailTo;
    private String subject;
    private String text;
    private StatusEmailEnum status;
}
