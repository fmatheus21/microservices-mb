package com.microservice.email.adapter.bound.inbound.resource;

import com.microservice.email.adapter.dto.request.EmailDtoRequest;
import com.microservice.email.adapter.bound.inbound.rule.EmailRule;
import com.microservice.email.application.domain.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/mail")
public class EmailResource {

    @Autowired
    private EmailRule emailRule;

    @GetMapping
    public ResponseEntity<Page<Email>> findAll(@PageableDefault(size = 5, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        return emailRule.findAll(pageable);
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<Object> findById(@PathVariable UUID uuid) {
        return this.emailRule.findById(uuid);
    }

    @PostMapping
    public ResponseEntity<Email> send(@RequestBody @Valid EmailDtoRequest request) {
        return this.emailRule.send(request);
    }


}
