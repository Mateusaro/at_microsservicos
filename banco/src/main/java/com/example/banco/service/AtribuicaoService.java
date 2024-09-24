package com.example.banco.service;

import com.example.banco.models.Atribuicao;
import com.example.banco.repository.AtribuicaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AtribuicaoService {

    @Autowired
    private AtribuicaoRepository atribuicaoRepository;

    public Atribuicao salvarAtribuicao(Atribuicao atribuicao) {
        return atribuicaoRepository.save(atribuicao);
    }

    public List<Atribuicao> listarAtribuicoes() {
        return atribuicaoRepository.findAll();
    }
}
