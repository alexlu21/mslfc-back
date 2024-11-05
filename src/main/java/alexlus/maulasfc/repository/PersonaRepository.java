package alexlus.maulasfc.repository;

import alexlus.maulasfc.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, Long> {
    Persona findByNombre(String nombre);
}

