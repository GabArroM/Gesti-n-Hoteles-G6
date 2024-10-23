package com.hoteles.domain; // Declara el paquete donde se encuentra la clase

// Importaciones necesarias de Jakarta Persistence para la gestión de JPA
import jakarta.persistence.Column; // Importa la anotación para mapear columnas en la base de datos
import jakarta.persistence.Entity; // Importa la anotación que indica que esta clase es una entidad JPA
import jakarta.persistence.GeneratedValue; // Importa la anotación para indicar que un campo se genera automáticamente
import jakarta.persistence.GenerationType; // Importa las estrategias de generación de valores
import jakarta.persistence.Id; // Importa la anotación que indica el identificador de la entidad
import jakarta.persistence.Table; // Importa la anotación para definir la tabla en la base de datos
import java.io.Serializable; // Importa la interfaz Serializable

// Anotación que indica que esta clase es una entidad JPA
@Entity
// Anotación que define el nombre de la tabla en la base de datos
@Table(name = "Persona")
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L; // Valor estático para la serialización de la clase

    // Anotación que indica que este campo es la clave primaria de la entidad
    @Id
    // Anotación que indica que el valor de este campo se generará automáticamente
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Anotación que especifica el nombre de la columna en la tabla
    @Column(name = "id_persona")
    private Long idPersona; // Identificador único de la persona
    
    private String nombre; // Nombre de la persona

    // Constructor sin argumentos (requerido por JPA)
    public Persona() {
    }

    // Constructor que permite crear una instancia de Persona con un nombre
    public Persona(String nombre) {
        this.nombre = nombre; 
    }

    // Getters y Setters para los campos de la clase
    public Long getIdPersona() {
        return idPersona; // Devuelve el ID de la persona
    }

    public void setIdPersona(Long idPersona) {
        this.idPersona = idPersona; // Establece el ID de la persona
    }

    public String getNombre() {
        return nombre; // Devuelve el nombre de la persona
    }

    public void setNombre(String nombre) {
        this.nombre = nombre; // Establece el nombre de la persona
    }
}
