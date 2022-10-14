package groomery.groomerywithmaven.controllers;

import groomery.groomerywithmaven.models.Appointment;
import groomery.groomerywithmaven.models.Treatment;
import groomery.groomerywithmaven.services.AppointmentService;
import groomery.groomerywithmaven.services.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AppointmentController {
    private DogService dogService;
    private AppointmentService appointmentService;
    @Autowired
    public AppointmentController(DogService dogService, AppointmentService appointmentService) {
        this.dogService = dogService;
        this.appointmentService = appointmentService;
    }

    @GetMapping("/appointment")
    public String renderNewAppointmentPage(Model model) {
        model.addAttribute("dogs", dogService.getAll());
        model.addAttribute("treatments", Treatment.values());
        model.addAttribute("appointments", appointmentService.getAll());
        return "newAppointment";
    }

    @PostMapping("/appointment")
    public String saveNewAppointment(@ModelAttribute Appointment appointment) {
        appointmentService.saveOrModify(appointment);
        return "redirect:/appointment";
    }

    @GetMapping("/appointment/{id}")
    public String renderModifyAppointmentPage(@PathVariable Integer id, Model model) {
        model.addAttribute("appointment", appointmentService.getById(id) );
        model.addAttribute("dogs", dogService.getAll());
        model.addAttribute("treatments", Treatment.values());
        model.addAttribute("appointments", appointmentService.getAll());
        return "newAppointment";
    }
}
