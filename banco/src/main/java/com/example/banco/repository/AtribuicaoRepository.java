package com.example.banco.repository;

import com.example.banco.models.Atribuicao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtribuicaoRepository extends JpaRepository<Atribuicao, Long> {
}
