package alexlus.maulasfc.controller;

import alexlus.maulasfc.model.Persona;
import alexlus.maulasfc.service.IPersonaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("https://mls-fc-production.up.railway.app")
@RestController
@RequestMapping("/persona")
@RequiredArgsConstructor
public class    PersonaController {
    private final IPersonaService iPersonaService;

    @GetMapping
    public ResponseEntity<List<Persona>> getAllPersons() {
        List<Persona> personas = iPersonaService.getAllPersons();
        System.out.println("Personas encontradas: " + personas.size());
        return new ResponseEntity<>(personas, HttpStatus.OK);
    }

    @PostMapping("/add")
    public Persona addPerson(@RequestBody Persona persona){
        return iPersonaService.addPerson(persona);
    }

    @GetMapping("/{id_persona}")
    public Persona getPersonById(@PathVariable long id_persona){
        return iPersonaService.findById(id_persona);
    }

    @DeleteMapping("/delete/{id_persona}")
    public void deletePerson(Long id_persona){
        iPersonaService.deletePerson(id_persona);
    }

    @PutMapping("/update/{id_persona}")
    public  Persona updatePerson(@RequestBody Persona persona, @PathVariable long id_persona){
        return iPersonaService.updatePerson(persona, id_persona);
    }
}
