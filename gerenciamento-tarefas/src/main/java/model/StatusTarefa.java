package model;

public enum StatusTarefa {

    PENDENTE("Pendente"),
    EM_ANDAMENTO("Em andamento"),
    CONCLUIDA("Concluída");

    private final String descricao;

    StatusTarefa(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return descricao;
    }
}