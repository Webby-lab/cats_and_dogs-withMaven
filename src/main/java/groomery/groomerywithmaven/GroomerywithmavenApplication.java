package groomery.groomerywithmaven;

import groomery.groomerywithmaven.models.Appointment;
import groomery.groomerywithmaven.models.Treatment;
import groomery.groomerywithmaven.repositories.AppointmentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

@SpringBootApplication
public class GroomerywithmavenApplication implements CommandLineRunner {
	AppointmentRepository appointmentRepository;

	public GroomerywithmavenApplication(AppointmentRepository appointmentRepository) {
		this.appointmentRepository = appointmentRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(GroomerywithmavenApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	Appointment appointment1 = new Appointment(2, LocalDateTime.now(), Treatment.FOGKŐLESZEDÉS, true);
	appointmentRepository.create(appointment1);
	}
}
