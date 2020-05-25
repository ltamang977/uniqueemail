package com.example.uniqueemail.response;

public class UniqueEmailResponse {

    private Integer numberOfUniqueEmails;

    public UniqueEmailResponse()
    {

    }

    public UniqueEmailResponse(Integer numberOfUniqueEmails)
    {
        this.numberOfUniqueEmails = numberOfUniqueEmails;
    }

    public Integer getNumberOfUniqueEmails() {
        return numberOfUniqueEmails;
    }

    public void setNumberOfUniqueEmails(Integer numberOfUniqueEmails) {
        this.numberOfUniqueEmails = numberOfUniqueEmails;
    }
}
