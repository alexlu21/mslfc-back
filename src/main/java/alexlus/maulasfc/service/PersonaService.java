package alexlus.maulasfc.service;

import alexlus.maulasfc.model.Persona;
import alexlus.maulasfc.repository.PersonaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonaService implements IPersonaService{

    @Autowired
    private final PersonaRepository personaRepository;

    @Override
    public List<Persona> getAllPersons(){
        return personaRepository.findAll();
    }

    @Override
    public Persona findById(long id_persona){
        return personaRepository.findById(id_persona).orElse(null);
    }

    @Override
    public Persona addPerson(Persona persona){
        return personaRepository.save(persona);
    }

    @Override
    public Persona findByNombre(String nombre){
        return personaRepository.findByNombre(nombre);
    }

    public void deletePerson(long id_persona){
        personaRepository.deleteById(id_persona);
    }

    public Persona updatePerson(Persona persona, long id_persona){
        return personaRepository.findById(id_persona).map(p ->{
            p.setNombre(persona.getNombre());
            p.setApellido(persona.getApellido());
            p.setFecha_nacimiento(persona.getFecha_nacimiento());
            p.setNacionalidad(persona.getNacionalidad());
            p.setActivo(persona.getActivo());
            return personaRepository.save(p);
        }).orElseThrow(() -> new RuntimeException("No se ha podido modificar el producto"));
    }
}
