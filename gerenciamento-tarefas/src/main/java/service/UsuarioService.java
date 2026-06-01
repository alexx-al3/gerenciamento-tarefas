package service;

import model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioService {

    private final List<Usuario> usuarios;

    private static final String ERRO_CAMPOS =
            "Campos não podem estar vazios";

    private static final String ERRO_SENHA =
            "Senha muito curta";

    private static final String ERRO_LOGIN =
            "Login já cadastrado";

    public UsuarioService() {
        this.usuarios = new ArrayList<>();
    }

    public void cadastrar(
            String nome,
            String login,
            String senha) {

        validarCampos(nome, login, senha);
        validarSenha(senha);
        validarDuplicidade(login);

        usuarios.add(
                new Usuario(nome, login, senha));
    }

    public boolean login(
            String login,
            String senha) {

        if (login.isBlank()
                || senha.isBlank()) {
            return false;
        }

        return buscarUsuario(login)
                .map(usuario ->
                        usuario.getSenha()
                                .equals(senha))
                .orElse(false);
    }

    public List<Usuario> listarUsuarios() {
        return usuarios;
    }

    private void validarCampos(
            String nome,
            String login,
            String senha) {

        if (nome.isBlank()
                || login.isBlank()
                || senha.isBlank()) {

            throw new IllegalArgumentException(
                    ERRO_CAMPOS);
        }
    }

    private void validarSenha(
            String senha) {

        if (senha.length() < 4) {
            throw new IllegalArgumentException(
                    ERRO_SENHA);
        }
    }

    private void validarDuplicidade(
            String login) {

        if (buscarUsuario(login).isPresent()) {

            throw new IllegalArgumentException(
                    ERRO_LOGIN);
        }
    }

    private java.util.Optional<Usuario>
    buscarUsuario(String login) {

        return usuarios.stream()
                .filter(usuario ->
                        usuario.getLogin()
                                .equalsIgnoreCase(login))
                .findFirst();
    }
}