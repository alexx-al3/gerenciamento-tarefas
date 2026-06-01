package service;

import model.StatusTarefa;
import model.Tarefa;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TarefaService {

    private final List<Tarefa> tarefas;

    private static final String ERRO_CAMPOS =
            "Campos vazios";

    private static final String ERRO_DUPLICIDADE =
            "Tarefa já existe";

    private static final String ERRO_NAO_ENCONTRADA =
            "Tarefa não encontrada";

    public TarefaService() {
        this.tarefas = new ArrayList<>();
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
            StatusTarefa novoStatus) {

        Tarefa tarefa =
                buscarTarefa(titulo)
                        .orElseThrow(() ->
                                new IllegalArgumentException(
                                        ERRO_NAO_ENCONTRADA));

        tarefa.setStatus(novoStatus);
    }

    public void excluir(
            String titulo) {

        boolean removido =
                tarefas.removeIf(
                        tarefa ->
                                tarefa.getTitulo()
                                        .equalsIgnoreCase(titulo));

        if (!removido) {
            throw new IllegalArgumentException(
                    ERRO_NAO_ENCONTRADA);
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
                    "--------------------");
        });
    }

    public List<Tarefa>
    listarTarefas() {

        return tarefas;
    }

    private void validarCampos(
            String titulo,
            String descricao) {

        if (titulo.isBlank()
                || descricao.isBlank()) {

            throw new IllegalArgumentException(
                    ERRO_CAMPOS);
        }
    }

    private void validarDuplicidade(
            String titulo) {

        if (buscarTarefa(titulo)
                .isPresent()) {

            throw new IllegalArgumentException(
                    ERRO_DUPLICIDADE);
        }
    }

    private Optional<Tarefa>
    buscarTarefa(
            String titulo) {

        return tarefas.stream()
                .filter(tarefa ->
                        tarefa.getTitulo()
                                .equalsIgnoreCase(
                                        titulo))
                .findFirst();
    }
}