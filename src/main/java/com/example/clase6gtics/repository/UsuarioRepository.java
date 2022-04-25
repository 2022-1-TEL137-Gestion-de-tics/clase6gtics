package com.example.clase6gtics.repository;

import com.example.clase6gtics.entity.UsuarioSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioSession, Integer> {

    public UsuarioSession findByEmail(String email);
}
