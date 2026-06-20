package com.menuconnect.api.service;

import com.menuconnect.api.model.Comanda;
import com.menuconnect.api.model.Pagamento;
import com.menuconnect.api.repository.ComandaRepository;
import com.menuconnect.api.repository.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Autowired
    private ComandaRepository comandaRepository; // Agora o aviso vai sumir!

    @Transactional
    public Pagamento processarPagamento(Pagamento pagamento) {
        pagamento.setDataHoraPagamento(LocalDateTime.now());
        pagamento.setStatus("APROVADO"); 
        
        Pagamento pagamentoSalvo = pagamentoRepository.save(pagamento);

        verificarEFecharComanda(pagamento.getComanda().getId());

        return pagamentoSalvo;
    }

    public List<Pagamento> listarPagamentosDaComanda(Long comandaId) {
        return pagamentoRepository.findByComandaId(comandaId);
    }

    private void verificarEFecharComanda(Long comandaId) {
        // Agora estamos de fato utilizando o comandaRepository para buscar o dado real
        Comanda comanda = comandaRepository.findById(comandaId)
                .orElseThrow(() -> new RuntimeException("Comanda não encontrada!"));
                System.err.println(comanda);

        // Futuramente, implementaremos a lógica de somar a lista de pagamentos.
        // Se a soma cobrir o valor total consumido, faremos isso:
        // comanda.setStatus("PAGA");
        // comandaRepository.save(comanda);
    }
}