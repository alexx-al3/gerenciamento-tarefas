package util;

import model.Tarefa;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class BackupManager {

    private static final String
            ARQUIVO_BACKUP =
            "backup_tarefas.txt";

    public static void realizarBackup(
            List<Tarefa> tarefas) {

        try (BufferedWriter writer =
                     new BufferedWriter(
                             new FileWriter(
                                     ARQUIVO_BACKUP))) {

            for (Tarefa tarefa : tarefas) {

                writer.write(
                        tarefa.getTitulo()
                                + ";"
                                + tarefa.getDescricao()
                                + ";"
                                + tarefa.getStatus());

                writer.newLine();
            }

            System.out.println(
                    "Backup realizado com sucesso!");

        } catch (IOException e) {

            System.out.println(
                    "Erro ao realizar backup: "
                            + e.getMessage());
        }
    }
}