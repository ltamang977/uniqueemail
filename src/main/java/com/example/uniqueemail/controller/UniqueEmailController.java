package com.example.uniqueemail.controller;

import com.example.uniqueemail.request.UniqueEmailRequest;
import com.example.uniqueemail.request.validator.UniqueEmailRequestValidator;
import com.example.uniqueemail.response.UniqueEmailResponse;
import com.example.uniqueemail.service.UniqueEmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController()
public class UniqueEmailController {

    private static final Logger log = LoggerFactory.getLogger(UniqueEmailController.class);

    @Autowired
    UniqueEmailRequestValidator uniqueEmailRequestValidator;

    @Autowired
    UniqueEmailService uniqueEmailService;

    @PostMapping(value="/", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public UniqueEmailResponse countUniqueEmail(@RequestBody @Valid UniqueEmailRequest request) {

        uniqueEmailRequestValidator.validate(request);
        Integer count = uniqueEmailService.countUniqueEmail(request.getEmails());
        return new UniqueEmailResponse(count);
    }

}
