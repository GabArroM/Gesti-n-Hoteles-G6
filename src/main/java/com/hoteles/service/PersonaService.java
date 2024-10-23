
package com.hoteles.service; // Declara el paquete donde se encuentra la interfaz

import com.hoteles.domain.Persona; // Importa la clase Persona que representa la entidad en la base de datos
import java.util.List; // Importa la clase List para manejar colecciones de objetos

// Interfaz que define los métodos para operar sobre la entidad Persona
public interface PersonaService {
    
    // Método que devuelve una lista de todas las personas
    public List<Persona> getPersonas();

    // Método que obtiene una persona específica basada en la instancia de Persona proporcionada
    public Persona getPersona(Persona persona);

    // Método que guarda o actualiza la información de una persona
    public void save(Persona persona);

    // Método que elimina una persona de la base de datos
    public void delete(Persona persona);
}

