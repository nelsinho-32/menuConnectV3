package com.menuconnect.api.controller;

import com.menuconnect.api.model.Pedido;
import com.menuconnect.api.service.PedidoService;
import com.menuconnect.api.service.EstoqueOrquestradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate; // NOVA IMPORTAÇÃO
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService service;

    @Autowired
    private EstoqueOrquestradorService estoqueService;

    // A injeção mágica do WebSocket
    @Autowired
    private SimpMessagingTemplate messagingTemplate; 

    @PostMapping
    public ResponseEntity<Pedido> criarPedido(@RequestBody Pedido pedido) {
        Pedido novoPedido = service.criarPedido(pedido);
        
        // Magia do Tempo Real: Avisa todos que estão ouvindo na "Rádio da Cozinha"
        // Enviando o objeto pedido inteiro como JSON
        messagingTemplate.convertAndSend("/topic/cozinha/" + novoPedido.getComanda().getEstabelecimento().getId(), novoPedido);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(novoPedido);
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Pedido> atualizarStatus(@PathVariable Long id, @RequestParam String status) {
        Pedido pedidoAtualizado = service.atualizarStatusCozinha(id, status);
        
        if ("PRONTO".equalsIgnoreCase(status) || "ENTREGUE".equalsIgnoreCase(status)) {
            estoqueService.debitarEstoqueDoPedido(id);
        }
        
        // Avisa a tela do KDS que este pedido mudou de status (ex: "EM_PREPARO" para "PRONTO")
        messagingTemplate.convertAndSend("/topic/cozinha/" + pedidoAtualizado.getComanda().getEstabelecimento().getId(), pedidoAtualizado);

        return ResponseEntity.ok(pedidoAtualizado);
    }

    @GetMapping("/pendentes/{estabelecimentoId}")
    public ResponseEntity<List<Pedido>> listarFilaCozinha(@PathVariable Long estabelecimentoId) {
        return ResponseEntity.ok(service.listarPedidosPendentes(estabelecimentoId));
    }
}