package com.menuconnect.api.repository;

import com.menuconnect.api.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    // Lista todos os funcionários de um local específico (ex: ver todos os garçons)
    List<Funcionario> findByEstabelecimentoIdAndCargo(Long estabelecimentoId, String cargo);
}