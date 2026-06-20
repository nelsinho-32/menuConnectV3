package com.menuconnect.api.repository;

import com.menuconnect.api.model.Estabelecimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstabelecimentoRepository extends JpaRepository<Estabelecimento, Long> {
    // O JpaRepository já traz métodos prontos como save(), findAll(), findById(), deleteById()
}