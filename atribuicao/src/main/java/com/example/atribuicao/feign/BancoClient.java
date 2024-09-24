package com.example.atribuicao.feign;

import com.example.atribuicao.models.Atribuicao;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "banco", url = "http://banco:8080") // Altere a URL para o serviço de banco de dados
public interface BancoClient {

    @PostMapping("/atribuicoes")
    Atribuicao criarAtribuicao(@RequestBody Atribuicao atribuicao);

    @GetMapping("/atribuicoes")
    List<Atribuicao> listarAtribuicoes();
}
