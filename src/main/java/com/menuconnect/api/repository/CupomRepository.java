package com.menuconnect.api.repository;

import com.menuconnect.api.model.Cupom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface CupomRepository extends JpaRepository<Cupom, Long> {
    // Usado quando o cliente digita o código do cupom no app
    Optional<Cupom> findByCodigoAndEstabelecimentoId(String codigo, Long estabelecimentoId);
}