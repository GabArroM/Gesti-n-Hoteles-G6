
package com.hoteles.dao; // Declara el paquete donde se encuentra la interfaz

import com.hoteles.domain.Persona; // Importa la clase Persona que representa la entidad en la base de datos

import org.springframework.data.jpa.repository.JpaRepository; // Importa la interfaz JpaRepository de Spring Data JPA

// Interfaz que extiende JpaRepository para proporcionar acceso a la entidad Persona
public interface PersonaDao extends JpaRepository<Persona, Long> {
    // Al extender JpaRepository, esta interfaz hereda varios métodos para realizar operaciones CRUD en la entidad Persona
}