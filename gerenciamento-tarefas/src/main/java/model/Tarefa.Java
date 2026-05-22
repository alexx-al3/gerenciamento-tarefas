package model;

public class Tarefa {

    private String titulo;
    private String descricao;
    private StatusTarefa status;

    public Tarefa(String titulo, String descricao) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.status = StatusTarefa.PENDENTE;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public StatusTarefa getStatus() {
        return status;
    }

    public void alterarStatus(StatusTarefa novoStatus) {
        this.status = novoStatus;
    }

    @Override
    public String toString() {
        return "Título: " + titulo +
                " | Descrição: " + descricao +
                " | Status: " + status;
    }
}