
package com.hoteles.controller; // Declara el paquete donde se encuentra la clase

// Importaciones necesarias
import com.hoteles.domain.Persona; // Importa la clase Persona, que representa la entidad
import com.hoteles.service.PersonaService; // Importa el servicio para gestionar las operaciones relacionadas con Persona
import org.springframework.beans.factory.annotation.Autowired; // Importa la anotación para la inyección de dependencias
import org.springframework.stereotype.Controller; // Importa la anotación que indica que esta clase es un controlador de Spring
import org.springframework.ui.Model; // Importa la clase Model para pasar datos a las vistas
import org.springframework.web.bind.annotation.GetMapping; // Importa la anotación para manejar solicitudes GET
import org.springframework.web.bind.annotation.PostMapping; // Importa la anotación para manejar solicitudes POST
import org.springframework.web.bind.annotation.RequestMapping; // Importa la anotación para definir la ruta base del controlador

import java.util.List; // Importa la clase List para manejar colecciones de objetos

// Anotación que define la ruta base para este controlador
@RequestMapping("/persona")
// Anotación que indica que esta clase es un controlador de Spring
@Controller
public class PersonaController {

    // Inyección automática del servicio de Persona
    @Autowired
    private PersonaService personaService;

    // Maneja las solicitudes GET para ver todas las personas
    @GetMapping("/verpersonas")
    public String inicio(Model model) {
        // Obtiene la lista de personas desde el servicio
        List<Persona> personas = personaService.getPersonas();
        // Añade la lista de personas y el total al modelo para pasarlo a la vista
        model.addAttribute("personas", personas);
        model.addAttribute("totalPersonas", personas.size());
        // Retorna el nombre de la vista a la que se redirige
        return "/lista-persona";
    }
    
    // Maneja las solicitudes GET para agregar una nueva persona
    @GetMapping("/agregar")
    public String personaNuevo(Persona persona) {
        // Retorna el nombre de la vista para agregar una nueva persona
        return "/agregar-persona";
    }

    // Maneja las solicitudes POST para guardar una nueva persona
    @PostMapping("/guardar")
    public String guardarPersona(Persona persona) {
        // Llama al servicio para guardar la persona
        personaService.save(persona);
        // Redirige a la lista de personas después de guardar
        return "redirect:/persona/verpersonas";
    }

    // Maneja las solicitudes GET para eliminar una persona
    @GetMapping("/eliminar/{idPersona}")
    public String personaEliminar(Persona persona) {
        // Llama al servicio para eliminar la persona
        personaService.delete(persona);
        // Redirige a la lista de personas después de eliminar
        return "redirect:/persona/verpersonas";
    }

    // Maneja las solicitudes GET para modificar una persona existente
    @GetMapping("/modificar/{idPersona}")
    public String personaModificar(Persona persona, Model model) { 
        // Obtiene la persona a modificar desde el servicio
        persona = personaService.getPersona(persona);
        // Añade la persona al modelo para pasarlo a la vista
        model.addAttribute("persona", persona);
        // Retorna el nombre de la vista para modificar la persona
        return "/modifca-persona";
    }
}

