package com.example.uniqueemail.service;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class UniqueEmailCountServiceImpl implements UniqueEmailService{

    @Override
    public Integer countUniqueEmail(List<String> emails)
    {
        if(emails==null || emails.isEmpty())
        {
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
