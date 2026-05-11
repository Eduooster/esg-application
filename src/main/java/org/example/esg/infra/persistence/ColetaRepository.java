package org.example.esg.infra.persistence;

import org.example.esg.domain.entities.Coleta;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ColetaRepository extends JpaRepository<Coleta, Long> {

    Page<Coleta> findByUsuarioId(Long idUsuario, Pageable pageable);
}