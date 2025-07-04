package com.fawryChallenge.model.product;

import java.time.LocalDate;
import java.util.Date;

public interface Expirable {
    boolean isExpired();
    LocalDate getExpireDate();

}
