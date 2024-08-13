package com.dailycodework.universalpetcare.service.appointment;

import com.dailycodework.universalpetcare.model.Appointment;
import com.dailycodework.universalpetcare.requests.AppointmentUpdateRequest;

import java.util.List;

public interface IAppointmentService {
    Appointment createAppointment(Appointment appointment, Long sender, Long recipient);
    List<Appointment> getAllAppointments();
    Appointment updateAppointment(Long id, AppointmentUpdateRequest request);
    void deleteAppointment(Long id);
    Appointment getAppointmentById(Long id);
    Appointment getAppointmentByNumber(String appointmentNo);
}
