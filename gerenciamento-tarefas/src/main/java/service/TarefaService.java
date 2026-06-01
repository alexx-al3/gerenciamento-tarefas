package service;

import exception.CampoInvalidoException;
import exception.TarefaDuplicadaException;
import exception.TarefaNaoEncontradaException;
import model.StatusTarefa;
import model.Tarefa;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TarefaService {

    private final List<Tarefa> tarefas;

    public TarefaService() {
        tarefas = new ArrayList<>();
    }

    public void cadastrar(
            String titulo,
            String descricao) {

        validarCampos(
                titulo,
                descricao);

        validarDuplicidade(titulo);

        tarefas.add(
                new Tarefa(
                        titulo,
                        descricao));
    }

    public void alterarStatus(
            String titulo,
            StatusTarefa status) {

        Tarefa tarefa =
                buscarTarefa(titulo)
                        .orElseThrow(() ->
                                new TarefaNaoEncontradaException(
                                        "Tarefa não encontrada."));

        tarefa.setStatus(status);
    }

    public void excluir(
            String titulo) {

        boolean removido =
                tarefas.removeIf(
                        tarefa ->
                                tarefa.getTitulo()
                                        .equalsIgnoreCase(titulo));

        if (!removido) {

            throw new TarefaNaoEncontradaException(
                    "Tarefa não encontrada.");
        }
    }

    public void relatorio() {

        if (tarefas.isEmpty()) {

            System.out.println(
                    "Nenhuma tarefa cadastrada.");

            return;
        }

        System.out.println(
                "\n===== RELATÓRIO =====");

        tarefas.forEach(tarefa -> {

            System.out.println(
                    "Título: "
                            + tarefa.getTitulo());

            System.out.println(
                    "Descrição: "
                            + tarefa.getDescricao());

            System.out.println(
                    "Status: "
                            + tarefa.getStatus());

            System.out.println(
                    "---------------");
        });
    }

    public List<Tarefa>
    listarTarefas() {

        return tarefas;
    }

    private void validarCampos(
            String titulo,
            String descricao) {

        if (titulo == null
                || descricao == null
                || titulo.isBlank()
                || descricao.isBlank()) {

            throw new CampoInvalidoException(
                    "Título e descrição obrigatórios.");
        }
    }

    private void validarDuplicidade(
            String titulo) {

        if (buscarTarefa(titulo)
                .isPresent()) {

            throw new TarefaDuplicadaException(
                    "Tarefa já cadastrada.");
        }
    }

    private Optional<Tarefa>
    buscarTarefa(
            String titulo) {

        return tarefas.stream()
                .filter(tarefa ->
                        tarefa.getTitulo()
                                .equalsIgnoreCase(titulo))
                .findFirst();
    }
}