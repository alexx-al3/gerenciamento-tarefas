package util;

import model.Tarefa;
import model.Usuario;

import java.io.*;
import java.util.List;

public class BackupManager {

    private static final String USUARIOS_FILE = "usuarios.txt";
    private static final String TAREFAS_FILE = "tarefas.txt";

    public static void salvarUsuarios(List<Usuario> usuarios) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(USUARIOS_FILE))) {

            for (Usuario usuario : usuarios) {

                writer.write(
                        usuario.getNome() + ";" +
                                usuario.getLogin() + ";" +
                                usuario.getSenha());

                writer.newLine();
            }

            System.out.println("Backup de usuários realizado!");

        } catch (IOException e) {
            System.out.println("Erro ao salvar usuários: " + e.getMessage());
        }
    }

    public static void salvarTarefas(List<Tarefa> tarefas) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(TAREFAS_FILE))) {

            for (Tarefa tarefa : tarefas) {

                writer.write(
                        tarefa.getTitulo() + ";" +
                                tarefa.getDescricao() + ";" +
                                tarefa.getStatus());

                writer.newLine();
            }

            System.out.println("Backup de tarefas realizado!");

        } catch (IOException e) {
            System.out.println("Erro ao salvar tarefas: " + e.getMessage());
        }
    }
}