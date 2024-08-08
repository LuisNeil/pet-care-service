package com.dailycodework.universalpetcare.service.user;

import com.dailycodework.universalpetcare.model.User;
import com.dailycodework.universalpetcare.requests.RegistrationRequest;
import org.springframework.stereotype.Component;

@Component
public class UserAttributesMapper {

    public void setCommonAttributes(RegistrationRequest source, User target){
        target.setFirstName(source.getFirstName());
        target.setLastName(source.getLastName());
        target.setGender(source.getGender());
        target.setPhoneNumber(source.getPhoneNumber());
        target.setEmail(source.getEmail());
        target.setPassword(source.getPassword());
        target.setUserType(source.getUserType());
        target.setEnabled(source.isEnabled());
    }
}
