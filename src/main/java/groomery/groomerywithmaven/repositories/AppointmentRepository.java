package groomery.groomerywithmaven.repositories;

import groomery.groomerywithmaven.models.Appointment;

import java.util.List;

public interface AppointmentRepository {
    List<Appointment> getAll();
    Appointment getById(Integer id);
    void create (Appointment appointment);
    void modify(Appointment modified);
}
