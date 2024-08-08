package com.dailycodework.universalpetcare.factory;

import com.dailycodework.universalpetcare.model.Admin;
import com.dailycodework.universalpetcare.model.User;
import com.dailycodework.universalpetcare.repository.AdminRepository;
import com.dailycodework.universalpetcare.requests.RegistrationRequest;
import com.dailycodework.universalpetcare.service.user.UserAttributesMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminFactory {
    private final AdminRepository adminRepository;
    private final UserAttributesMapper userAttributesMapper;

    public User createAdmin(RegistrationRequest request) {
        Admin admin = new Admin();
        userAttributesMapper.setCommonAttributes(request, admin);
        return  adminRepository.save(admin);
    }
}
