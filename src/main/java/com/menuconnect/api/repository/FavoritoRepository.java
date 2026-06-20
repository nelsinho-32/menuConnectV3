package com.menuconnect.api.repository;

import com.menuconnect.api.model.Favorito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface FavoritoRepository extends JpaRepository<Favorito, Long> {
    // Busca todos os locais e pratos que um cliente favoritou
    List<Favorito> findByClienteId(Long clienteId);
}