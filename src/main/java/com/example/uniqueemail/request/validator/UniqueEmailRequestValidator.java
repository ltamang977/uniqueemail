package com.example.uniqueemail.request.validator;

import com.example.uniqueemail.exception.InvalidEmailException;
import com.example.uniqueemail.request.UniqueEmailRequest;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

@Component
public class UniqueEmailRequestValidator {

    public void validate(@NotNull UniqueEmailRequest request) throws InvalidEmailException
    {
        for(String email :request.getEmails())
        {
            if(!email.contains("@"))
            {
                throw new InvalidEmailException("Email not valid");
            }
        }
    }
}
