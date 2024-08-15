package com.dailycodework.universalpetcare.requests;

import com.dailycodework.universalpetcare.model.Appointment;
import com.dailycodework.universalpetcare.model.Pet;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookAppointmentRequest {
    private Appointment appointment;
    private List<Pet> pets;
}
