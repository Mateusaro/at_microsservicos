package com.example.atribuicao.repository;

import com.example.atribuicao.models.Atribuicao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtribuicaoRepository extends JpaRepository<Atribuicao, Long> {
}
