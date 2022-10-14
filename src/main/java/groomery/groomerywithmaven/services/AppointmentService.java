package groomery.groomerywithmaven.services;

import groomery.groomerywithmaven.models.Appointment;

import java.util.List;

public interface AppointmentService {
    List<Appointment> getAll();
    void save(Appointment appointment);
    Appointment getById(Integer id);
    void modifyAppointment(Appointment appointment);
    void saveOrModify(Appointment appointment);
}
