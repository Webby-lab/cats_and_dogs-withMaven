package groomery.groomerywithmaven.services;

import groomery.groomerywithmaven.models.Appointment;
import groomery.groomerywithmaven.repositories.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AppointmentServiceImpl implements AppointmentService {
    private AppointmentRepository appointmentRepository;
    @Autowired
    public AppointmentServiceImpl(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public List<Appointment> getAll() {
        return appointmentRepository.getAll();
    }

    @Override
    public void save(Appointment appointment) {
        appointmentRepository.create(appointment);
    }

    @Override
    public Appointment getById(Integer id) {
        return appointmentRepository.getById(id);
    }

    @Override
    public void modifyAppointment(Appointment appointment) {
        appointmentRepository.modify(appointment);
    }
    @Override
    public void saveOrModify(Appointment appointment) {
        if (appointmentRepository.getById(appointment.getId()) == null) {
            save(appointment);
        }else {
            appointmentRepository.modify(appointment);
        }
    }
}
