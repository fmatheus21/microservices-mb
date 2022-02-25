package com.microservice.email.adapter.outbound.persistence.entity;

import com.microservice.email.application.domain.enums.StatusEmailEnum;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@ToString
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "email", catalog = "ms_email")
public class EmailEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "owner_ref", nullable = false, length = 50)
    private String ownerRef;

    @Column(name = "email_from", nullable = false, length = 100)
    private String emailFrom;

    @Column(name = "email_to", nullable = false, length = 100)
    private String emailTo;

    @Column(name = "subject", nullable = false, length = 50)
    private String subject;

    @Lob
    @Column(name = "text", columnDefinition = "TEXT", nullable = false)
    private String text;

    @Builder.Default
    @Column(name = "send_date", nullable = false)
    private LocalDateTime sendDate = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 20)
    private StatusEmailEnum status;

}
