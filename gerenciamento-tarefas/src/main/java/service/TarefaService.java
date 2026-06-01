package service;

import model.StatusTarefa;
import model.Tarefa;

import java.util.ArrayList;
import java.util.List;

public class TarefaService {

    private List<Tarefa> tarefas = new ArrayList<>();

    public void cadastrar(String titulo, String descricao) {

        if (titulo.isEmpty() || descricao.isEmpty()) {
            throw new IllegalArgumentException("Campos vazios");
        }

        for (Tarefa tarefa : tarefas) {
            if (tarefa.getTitulo().equalsIgnoreCase(titulo)) {
                throw new IllegalArgumentException("Tarefa já existe");
            }
        }

        tarefas.add(new Tarefa(titulo, descricao));
    }

    public void alterarStatus(
            String titulo,
            StatusTarefa novoStatus) {

        for (Tarefa tarefa : tarefas) {

            if (tarefa.getTitulo()
                    .equalsIgnoreCase(titulo)) {

                tarefa.setStatus(novoStatus);
                return;
            }
        }

        throw new IllegalArgumentException("Tarefa não encontrada");
    }

    public void excluir(String titulo) {

        boolean removido = tarefas.removeIf(
                tarefa -> tarefa.getTitulo()
                        .equalsIgnoreCase(titulo));

        if (!removido) {
            throw new IllegalArgumentException("Tarefa não encontrada");
        }
    }

    public void relatorio() {

        if (tarefas.isEmpty()) {
            System.out.println("Nenhuma tarefa cadastrada.");
            return;
        }

        System.out.println("\n===== RELATÓRIO =====");

        for (Tarefa tarefa : tarefas) {

            System.out.println("Título: "
                    + tarefa.getTitulo());

            System.out.println("Descrição: "
                    + tarefa.getDescricao());

            System.out.println("Status: "
                    + tarefa.getStatus());

            System.out.println("--------------------");
        }
    }

    public List<Tarefa> listarTarefas() {
        return tarefas;
    }
}