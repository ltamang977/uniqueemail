package com.example.uniqueemail.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class UniqueEmailCountServiceImpl implements UniqueEmailService{

    private static final Logger log = LoggerFactory.getLogger(UniqueEmailCountServiceImpl.class);

    @Override
    public Integer countUniqueEmail(List<String> emails)
    {
        if(emails==null || emails.isEmpty())
        {
           log.error("Email list not valid");
           return 0;
        }

        Set<String> uniqueEmails = emails.stream()
                .map(email->cleanEmail(email))
                .collect(Collectors.toSet());

        return uniqueEmails.size();
    }

    public String cleanEmail(String email)
    {
        if(email==null || email.isEmpty())
        {
            log.error("Email should not be null or empty");
            throw new IllegalArgumentException("Email should not be null or empty");
        }

        int indexOfDomain = email.indexOf("@");
        String local = email.substring(0,indexOfDomain);
        String domain = email.substring(indexOfDomain+1);

        if(local.contains("+"))
        {
            local = local.substring(0, local.indexOf("+"));
        }

        local=local.replaceAll("\\.", "");

        return local+"@"+domain;
    }
}
