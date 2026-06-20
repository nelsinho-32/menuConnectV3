package com.menuconnect.api.service;

import com.menuconnect.api.model.Funcionario;
import com.menuconnect.api.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository repository;

    public Funcionario contratarFuncionario(Funcionario funcionario) {
        // Inicializa as métricas de RH zeradas para um novo funcionário
        funcionario.setTotalPedidosAtendidos(0);
        return repository.save(funcionario);
    }

    public List<Funcionario> listarEquipe(Long estabelecimentoId, String cargo) {
        return repository.findByEstabelecimentoIdAndCargo(estabelecimentoId, cargo);
    }
}