package groomery.groomerywithmaven.controllers;

import groomery.groomerywithmaven.models.Allergy;
import groomery.groomerywithmaven.models.Dog;
import groomery.groomerywithmaven.models.Owner;
import groomery.groomerywithmaven.services.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AppController {
    private DogService dogService;
    @Autowired
    public AppController(DogService dogService) {
        this.dogService = dogService;
    }

    @GetMapping("/")
    public String renderMainPage() {
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
        return "dogsProfilePage";
    }
}
