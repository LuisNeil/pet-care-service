package com.dailycodework.universalpetcare.factory;

import com.dailycodework.universalpetcare.model.User;
import com.dailycodework.universalpetcare.requests.RegistrationRequest;

public interface UserFactory {
    public User createUser(RegistrationRequest registrationRequest);
}
