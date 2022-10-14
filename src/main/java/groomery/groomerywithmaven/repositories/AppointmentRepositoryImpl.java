package groomery.groomerywithmaven.repositories;

import groomery.groomerywithmaven.models.Appointment;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class AppointmentRepositoryImpl implements AppointmentRepository {

    private static List<Appointment> appointments = new ArrayList<>();

    @Override
    public List<Appointment> getAll() {
        return appointments;
    }

    @Override
    public Appointment getById(Integer id) {
        return appointments.stream()
                .filter(appointment -> Objects.equals(appointment.getId(), id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void create(Appointment appointment) {
        appointments.add(appointment);
    }

    @Override
    public void modify(Appointment modified) {
        Appointment appointment = getById(modified.getId());
        if (appointment == null) {
            return;
        }
        appointment.setDogId(modified.getDogId());
        appointment.setTime(modified.getTime());
        appointment.setTreatment(modified.getTreatment());
        appointment.setStay(modified.getStay());
    }
}
