
package com.hoteles.service.impl;

// Importaciones necesarias
import com.hoteles.dao.PersonaDao; // Importa el DAO para interactuar con la base de datos
import com.hoteles.domain.Persona; // Importa la entidad Persona
import com.hoteles.service.PersonaService; // Importa la interfaz PersonaService

import java.util.List; // Importa la clase List para manejar colecciones de objetos

import org.springframework.beans.factory.annotation.Autowired; // Importa la anotación para la inyección de dependencias
import org.springframework.stereotype.Service; // Importa la anotación para definir un servicio
import org.springframework.transaction.annotation.Transactional; // Importa la anotación para manejar transacciones

// Anotación que indica que esta clase es un servicio de Spring
@Service
public class PersonaServiceImpl implements PersonaService {

    // Inyección automática del DAO de Persona
    @Autowired
    private PersonaDao personaDao;

    // Método que obtiene todas las personas de la base de datos
    @Override
    @Transactional(readOnly = true) // Indica que este método es solo de lectura
    public List<Persona> getPersonas() {
        // Llama al método findAll del personaDao para obtener la lista de personas
        var lista = personaDao.findAll();
        // Retorna la lista obtenida
        return lista;
    }

    // Método que obtiene una persona específica por su ID
    @Override
    @Transactional(readOnly = true) // Indica que este método es solo de lectura
    public Persona getPersona(Persona persona) {
        // Busca la persona por su ID usando el personaDao; devuelve null si no se encuentra
        return personaDao.findById(persona.getIdPersona()).orElse(null);
    }

    // Método que guarda o actualiza una persona en la base de datos
    @Override
    @Transactional // Indica que este método es transaccional
    public void save(Persona persona) {
        // Llama al método save del personaDao para guardar la persona
        personaDao.save(persona);
    }

    // Método que elimina una persona de la base de datos
    @Override
    @Transactional // Indica que este método es transaccional
    public void delete(Persona persona) {
        // Llama al método delete del personaDao para eliminar la persona
        personaDao.delete(persona);
    }
}
