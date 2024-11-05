package alexlus.maulasfc.service;

import alexlus.maulasfc.model.Persona;

import java.util.List;

public interface IPersonaService {
    public List<Persona> getAllPersons();
    public Persona findById(long id_persona);
    public Persona addPerson(Persona persona);
    Persona findByNombre(String nombre);
    public void deletePerson(long id_persona);
    public Persona updatePerson(Persona persona, long id_persona);
}
