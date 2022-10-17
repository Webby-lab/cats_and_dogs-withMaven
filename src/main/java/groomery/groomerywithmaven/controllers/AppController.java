package groomery.groomerywithmaven.controllers;

import groomery.groomerywithmaven.models.Allergy;
import groomery.groomerywithmaven.models.Dog;
import groomery.groomerywithmaven.models.Owner;
import groomery.groomerywithmaven.models.Treatment;
import groomery.groomerywithmaven.services.DogService;
import groomery.groomerywithmaven.services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
public class AppController {
    private DogService dogService;
    private OwnerService ownerService;
    @Autowired
    public AppController(DogService dogService, OwnerService ownerService) {
        this.dogService = dogService;
        this.ownerService = ownerService;
    }

    @GetMapping("/")
    public String renderMainPage(Model model) {
        model.addAttribute("treatments", Treatment.values());
        return "main";
    }

    @GetMapping("/dogs")
    public String renderDogsPage(
            Model model,
            @RequestParam(value = "sort", required = false) String sortedBy,
            @RequestParam(required=false) Boolean asc,
            @RequestParam(required = false) Allergy allergy){
        List<Dog> dogs = dogService.sortedDogs(sortedBy, asc);
        List<Dog> filteredDogs = dogService.filterByAllargies(dogs, allergy );
        model.addAttribute("dogs", filteredDogs);
        return "dogs";
    }
    @PostMapping("/dogs")
    public String renderDogsSearchedPage(Model model, @RequestParam String search) {
        List<Dog> dogs = dogService.getByName(search);
        model.addAttribute("dogs", dogs);
        return "dogs";
    }
    @GetMapping("/dogs/{id}")
    public String renderProfilePage(Model model, @PathVariable(value = "id") Integer id) {
        model.addAttribute("dog", dogService.getById(id));
        Dog dog = dogService.getById(id);
        Owner owner = dog.getOwner();
        model.addAttribute("owner", owner);
        return "dogProfilePage";
    }
    @GetMapping("/registration")
    public String renderRegistrationPage(Model model) {
        List<Allergy> allergies = Arrays.asList(Allergy.values());
        model.addAttribute("allergies", allergies);
        model.addAttribute("owners", ownerService.getAll());
        return "registration";
    }

    @PostMapping("/registration")
    public String registerAnimal(@ModelAttribute Dog dog, @RequestParam String owner) {
        Owner toset = ownerService.getOwnerByName(owner);
        dogService.save(dog);
        dog.setOwner(toset);
        return "redirect:/dogs";
    }

    @PostMapping("/ownerRegistration")
    public String registerOwner(@ModelAttribute Owner owner) {
        ownerService.save(owner);
        return "redirect:/registration";
    }
}
