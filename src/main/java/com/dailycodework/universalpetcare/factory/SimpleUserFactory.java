package com.dailycodework.universalpetcare.factory;

import com.dailycodework.universalpetcare.exception.UserAlreadyExistsException;
import com.dailycodework.universalpetcare.model.User;
import com.dailycodework.universalpetcare.repository.UserRepository;
import com.dailycodework.universalpetcare.requests.RegistrationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class SimpleUserFactory implements UserFactory {

    private final UserRepository userRepository;
    private final VeterinarianFactory veterinarianFactory;
    private final PatientFactory patientFactory;
    private final AdminFactory adminFactory;

    @Override
    public User createUser(RegistrationRequest registrationRequest) {
        if (userRepository.existsByEmail(registrationRequest.getEmail())) {
            throw new UserAlreadyExistsException("Oops! " + registrationRequest.getEmail() + " already exists");
        }
        switch (registrationRequest.getUserType()) {
            case "VET" -> {
                return veterinarianFactory.createVeterinarian(registrationRequest);
            }
            case "PATIENT" -> {
                return patientFactory.createPatient(registrationRequest);
            }
            case "ADMIN" -> {
                return adminFactory.createAdmin(registrationRequest);
            }
            default -> {
                return null;
            }
        }

    }
}
