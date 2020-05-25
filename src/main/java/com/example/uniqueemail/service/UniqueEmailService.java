package com.example.uniqueemail.service;

import javax.validation.constraints.NotNull;
import java.util.List;

public interface UniqueEmailService {

    Integer countUniqueEmail(@NotNull List<String> emails );
}
