package com.menuconnect.api.service;

import com.menuconnect.api.model.ContaFiado;
import com.menuconnect.api.model.LancamentoFiado;
import com.menuconnect.api.repository.ContaFiadoRepository;
import com.menuconnect.api.repository.LancamentoFiadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class ContaFiadoService {

    @Autowired
    private ContaFiadoRepository contaRepository;

    @Autowired
    private LancamentoFiadoRepository lancamentoRepository;

    @Transactional
    public LancamentoFiado registrarCompraFiado(Long contaId, BigDecimal valorCompra) {
        ContaFiado conta = contaRepository.findById(contaId)
                .orElseThrow(() -> new RuntimeException("Conta não encontrada!"));

        if (conta.getBloqueada()) {
            throw new RuntimeException("Esta conta está bloqueada para novas compras.");
        }

        BigDecimal novoSaldoDevedor = conta.getSaldoDevedorAtual().add(valorCompra);

        if (novoSaldoDevedor.compareTo(conta.getLimiteCredito()) > 0) {
            throw new RuntimeException("A compra ultrapassa o limite de crédito do cliente.");
        }

        // Atualiza a dívida do cliente
        conta.setSaldoDevedorAtual(novoSaldoDevedor);
        contaRepository.save(conta);

        // Registra o extrato da movimentação
        LancamentoFiado lancamento = new LancamentoFiado();
        lancamento.setContaFiado(conta);
        lancamento.setTipoLancamento("COMPRA");
        lancamento.setValor(valorCompra);
        lancamento.setDataHoraLancamento(LocalDateTime.now());

        return lancamentoRepository.save(lancamento);
    }

    @Transactional
    public LancamentoFiado abaterDivida(Long contaId, BigDecimal valorPago) {
        ContaFiado conta = contaRepository.findById(contaId)
                .orElseThrow(() -> new RuntimeException("Conta não encontrada!"));

        // Reduz o saldo devedor
        BigDecimal novoSaldo = conta.getSaldoDevedorAtual().subtract(valorPago);
        
        // Evita que o saldo devedor fique negativo (o cliente pagou a mais do que devia)
        if (novoSaldo.compareTo(BigDecimal.ZERO) < 0) {
            novoSaldo = BigDecimal.ZERO; 
        }

        conta.setSaldoDevedorAtual(novoSaldo);
        contaRepository.save(conta);

        LancamentoFiado lancamento = new LancamentoFiado();
        lancamento.setContaFiado(conta);
        lancamento.setTipoLancamento("PAGAMENTO");
        lancamento.setValor(valorPago);
        lancamento.setDataHoraLancamento(LocalDateTime.now());

        return lancamentoRepository.save(lancamento);
    }
}