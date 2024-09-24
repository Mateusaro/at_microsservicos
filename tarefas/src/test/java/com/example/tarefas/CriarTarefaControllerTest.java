package com.example.tarefas;

import com.example.tarefas.DTO.TarefaDTO;
import com.example.tarefas.controller.TarefaController;
import com.example.tarefas.models.Tarefa;
import com.example.tarefas.models.Prioridade;
import com.example.tarefas.service.TarefaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class CriarTarefaControllerTest {

    @Mock
    private TarefaService tarefaService;

    @InjectMocks
    private TarefaController tarefaController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void criarTarefa() {
        TarefaDTO tarefaDTO = new TarefaDTO();
        tarefaDTO.setTitulo("Teste Titulo");
        tarefaDTO.setDescricao("Teste Descricao");
        tarefaDTO.setPrazo(LocalDate.now().plusDays(7));
        tarefaDTO.setPrioridade(Prioridade.ALTA);

        Tarefa tarefa = new Tarefa(1L, "Teste Titulo", "Teste Descricac", LocalDate.now().plusDays(7), Prioridade.ALTA);
        when(tarefaService.salvarTarefa(tarefaDTO)).thenReturn(tarefa);

        ResponseEntity<Tarefa> response = tarefaController.criarTarefa(tarefaDTO);

        // Verificações
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(tarefa, response.getBody());
    }
}
