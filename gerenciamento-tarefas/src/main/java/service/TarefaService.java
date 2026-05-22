package service;

import model.StatusTarefa;
import model.Tarefa;

import java.util.ArrayList;
import java.util.List;

public class TarefaService {

    private List<Tarefa> tarefas = new ArrayList<>();

    public void cadastrar(String titulo, String descricao) {

        if (titulo.isBlank() || descricao.isBlank()) {
            throw new IllegalArgumentException("Campos obrigatórios");
        }

        for (Tarefa tarefa : tarefas) {
            if (tarefa.getTitulo().equalsIgnoreCase(titulo)) {
                throw new IllegalArgumentException("Tarefa já existe");
            }
        }

        tarefas.add(new Tarefa(titulo, descricao));
    }

    public void excluir(String titulo) {
        tarefas.removeIf(tarefa -> tarefa.getTitulo().equalsIgnoreCase(titulo));
    }

    public void alterarStatus(String titulo, StatusTarefa novoStatus) {

        for (Tarefa tarefa : tarefas) {
            if (tarefa.getTitulo().equalsIgnoreCase(titulo)) {
                tarefa.alterarStatus(novoStatus);
                return;
            }
        }

        throw new IllegalArgumentException("Tarefa não encontrada");
    }

    public List<Tarefa> listar() {
        return tarefas;
    }

    public void relatorio() {

        System.out.println("\n===== RELATÓRIO =====");

        for (Tarefa tarefa : tarefas) {
            System.out.println(tarefa);
        }

        System.out.println("Total de tarefas: " + tarefas.size());
    }
}