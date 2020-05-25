package com.example.uniqueemail.request.validator;

import com.example.uniqueemail.exception.InvalidEmailException;
import com.example.uniqueemail.request.UniqueEmailRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

@Component
public class UniqueEmailRequestValidator {

    private static final Logger log = LoggerFactory.getLogger(UniqueEmailRequestValidator.class);

    public void validate(@NotNull UniqueEmailRequest request) throws InvalidEmailException
    {
        for(String email :request.getEmails())
        {
            if(!email.contains("@"))
            {
                log.error("Email not valid : %s", email);
                throw new InvalidEmailException("Email not valid");
            }
        }
    }
}
