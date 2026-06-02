import model.StatusTarefa;
import service.TarefaService;
import service.UsuarioService;
import util.BackupManager;

import java.util.Scanner;

public class Main {

    private static final Scanner sc =
            new Scanner(System.in);

    private static final
    UsuarioService usuarioService =
            new UsuarioService();

    private static final
    TarefaService tarefaService =
            new TarefaService();

    private static boolean
            usuarioLogado = false;

    public static void main(
            String[] args) {

        int opcao;

        do {

            mostrarMenu();

            opcao = lerOpcao();

            try {

                switch (opcao) {

                    case 1 ->
                            cadastrarUsuario();

                    case 2 ->
                            realizarLogin();

                    case 3 ->
                            cadastrarTarefa();

                    case 4 ->
                            alterarStatus();

                    case 5 ->
                            tarefaService.relatorio();

                    case 6 ->
                            excluirTarefa();

                    case 7 ->
                            realizarBackup();

                    case 0 ->
                            System.out.println(
                                    "Saindo...");

                    default ->
                            System.out.println(
                                    "Opção inválida.");
                }

            } catch (Exception e) {

                System.out.println(
                        "Erro: "
                                + e.getMessage());
            }

        } while (opcao != 0);

        sc.close();
    }

    private static void
    mostrarMenu() {

        System.out.println(
                "\n===== SISTEMA =====");

        System.out.println(
                "1 - Cadastrar usuário");

        System.out.println(
                "2 - Login");

        System.out.println(
                "3 - Cadastrar tarefa");

        System.out.println(
                "4 - Alterar status");

        System.out.println(
                "5 - Relatório");

        System.out.println(
                "6 - Excluir tarefa");

        System.out.println(
                "7 - Backup");

        System.out.println(
                "0 - Sair");

        System.out.print(
                "Escolha: ");
    }

    private static int
    lerOpcao() {

        try {

            return Integer.parseInt(
                    sc.nextLine());

        } catch (
                NumberFormatException e) {

            return -1;
        }
    }

    private static void
    cadastrarUsuario() {

        System.out.print("Nome: ");
        String nome = sc.nextLine();

        System.out.print("Login: ");
        String login = sc.nextLine();

        System.out.print("Senha: ");
        String senha = sc.nextLine();

        usuarioService.cadastrar(
                nome,
                login,
                senha);

        System.out.println(
                "Usuário cadastrado!");
    }

    private static void
    realizarLogin() {

        System.out.print("Login: ");
        String login =
                sc.nextLine();

        System.out.print("Senha: ");
        String senha =
                sc.nextLine();

        usuarioLogado =
                usuarioService.login(
                        login,
                        senha);

        System.out.println(
                usuarioLogado
                        ? "Login realizado!"
                        : "Login inválido!");
    }

    private static void
    cadastrarTarefa() {

        validarLogin();

        System.out.print(
                "Título: ");

        String titulo =
                sc.nextLine();

        System.out.print(
                "Descrição: ");

        String descricao =
                sc.nextLine();

        tarefaService.cadastrar(
                titulo,
                descricao);

        System.out.println(
                "Tarefa cadastrada!");
    }

    private static void
    alterarStatus() {

        validarLogin();

        System.out.print(
                "Título da tarefa: ");

        String titulo =
                sc.nextLine();

        StatusTarefa status =
                obterStatus();

        if (status == null) {
            return;
        }

        tarefaService.alterarStatus(
                titulo,
                status);

        System.out.println(
                "Status alterado!");
    }

    private static void
    excluirTarefa() {

        validarLogin();

        System.out.print(
                "Título: ");

        String titulo =
                sc.nextLine();

        tarefaService.excluir(
                titulo);

        System.out.println(
                "Tarefa excluída!");
    }

    private static void
    realizarBackup() {

        BackupManager
                .realizarBackup(
                        tarefaService
                                .listarTarefas());
    }

    private static void
    validarLogin() {

        if (!usuarioLogado) {

            throw new IllegalStateException(
                    "Faça login primeiro.");
        }
    }

    private static
    StatusTarefa obterStatus() {

        System.out.println(
                "1 - PENDENTE");

        System.out.println(
                "2 - EM_ANDAMENTO");

        System.out.println(
                "3 - CONCLUIDA");

        try {

            int opcao =
                    Integer.parseInt(
                            sc.nextLine());

            return switch (opcao) {

                case 1 ->
                        StatusTarefa.PENDENTE;

                case 2 ->
                        StatusTarefa.EM_ANDAMENTO;

                case 3 ->
                        StatusTarefa.CONCLUIDA;

                default -> null;
            };

        } catch (
                NumberFormatException e) {

            return null;
        }
    }
}