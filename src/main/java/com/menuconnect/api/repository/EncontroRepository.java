package com.menuconnect.api.repository;

import com.menuconnect.api.model.Encontro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EncontroRepository extends JpaRepository<Encontro, Long> {
    List<Encontro> findByCriadorId(Long criadorId);
}