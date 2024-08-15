package com.dailycodework.universalpetcare.service.appointment;

import com.dailycodework.universalpetcare.model.Appointment;
import com.dailycodework.universalpetcare.requests.AppointmentUpdateRequest;
import com.dailycodework.universalpetcare.requests.BookAppointmentRequest;

import java.util.List;

public interface IAppointmentService {
    Appointment createAppointment(BookAppointmentRequest request, Long sender, Long recipient);
    List<Appointment> getAllAppointments();
    Appointment updateAppointment(Long id, AppointmentUpdateRequest request);
    void deleteAppointment(Long id);
    Appointment getAppointmentById(Long id);
    Appointment getAppointmentByNumber(String appointmentNo);
}
