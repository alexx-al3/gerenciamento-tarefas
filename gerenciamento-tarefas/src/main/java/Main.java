import model.StatusTarefa;
import service.TarefaService;
import service.UsuarioService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        UsuarioService usuarioService = new UsuarioService();
        TarefaService tarefaService = new TarefaService();

        int opcao;

        do {

            System.out.println("\n===== SISTEMA DE TAREFAS =====");
            System.out.println("1 - Cadastrar usuário");
            System.out.println("2 - Login");
            System.out.println("3 - Cadastrar tarefa");
            System.out.println("4 - Alterar status");
            System.out.println("5 - Relatório");
            System.out.println("6 - Backup");
            System.out.println("0 - Sair");

            System.out.print("Escolha: ");
            opcao = sc.nextInt();
            sc.nextLine();

            try {

                switch (opcao) {

                    case 1:

                        System.out.print("Nome: ");
                        String nome = sc.nextLine();

                        System.out.print("Login: ");
                        String login = sc.nextLine();

                        System.out.print("Senha: ");
                        String senha = sc.nextLine();

                        usuarioService.cadastrar(nome, login, senha);

                        System.out.println("Usuário cadastrado!");
                        break;

                    case 2:

                        System.out.print("Login: ");
                        String loginUsuario = sc.nextLine();

                        System.out.print("Senha: ");
                        String senhaUsuario = sc.nextLine();

                        boolean logado = usuarioService.login(loginUsuario, senhaUsuario);

                        if (logado) {
                            System.out.println("Login realizado!");
                        } else {
                            System.out.println("Login inválido!");
                        }

                        break;

                    case 3:

                        System.out.print("Título: ");
                        String titulo = sc.nextLine();

                        System.out.print("Descrição: ");
                        String descricao = sc.nextLine();

                        tarefaService.cadastrar(titulo, descricao);

                        System.out.println("Tarefa cadastrada!");
                        break;

                    case 4:

                        System.out.print("Título da tarefa: ");
                        String tituloTarefa = sc.nextLine();

                        System.out.println("1 - PENDENTE");
                        System.out.println("2 - EM_ANDAMENTO");
                        System.out.println("3 - CONCLUIDA");

                        int status = sc.nextInt();
                        sc.nextLine();

                        StatusTarefa novoStatus;

                        switch (status) {
                            case 1:
                                novoStatus = StatusTarefa.PENDENTE;
                                break;
                            case 2:
                                novoStatus = StatusTarefa.EM_ANDAMENTO;
                                break;
                            case 3:
                                novoStatus = StatusTarefa.CONCLUIDA;
                                break;
                            default:
                                throw new IllegalArgumentException("Status inválido");
                        }

                        tarefaService.alterarStatus(
                                tituloTarefa,
                                novoStatus);

                        System.out.println("Status alterado!");
                        break;

                    case 5:
                        tarefaService.relatorio();
                        break;

                    case 0:
                        System.out.println("Saindo...");
                        break;

                    default:
                        System.out.println("Opção inválida!");
                }

            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }

        } while (opcao != 0);

        sc.close();
    }
}