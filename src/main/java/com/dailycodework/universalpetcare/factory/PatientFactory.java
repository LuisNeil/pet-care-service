package com.dailycodework.universalpetcare.factory;

import com.dailycodework.universalpetcare.model.Patient;
import com.dailycodework.universalpetcare.model.User;
import com.dailycodework.universalpetcare.repository.PatientRepository;
import com.dailycodework.universalpetcare.requests.RegistrationRequest;
import com.dailycodework.universalpetcare.service.user.UserAttributesMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientFactory {

    private final PatientRepository patientRepository;
    private final UserAttributesMapper userAttributesMapper;
    public User createPatient(RegistrationRequest request) {
        Patient patient = new Patient();
        userAttributesMapper.setCommonAttributes(request, patient);
        return patientRepository.save(patient);
    }
}
