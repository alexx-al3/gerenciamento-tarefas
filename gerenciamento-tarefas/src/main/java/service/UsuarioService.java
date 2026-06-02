package service;

import exception.CampoInvalidoException;
import exception.UsuarioDuplicadoException;
import model.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsuarioService {

    private final List<Usuario> usuarios;

    public UsuarioService() {
        usuarios = new ArrayList<>();
    }

    public void cadastrar(
            String nome,
            String login,
            String senha) {

        validarCampos(
                nome,
                login,
                senha);

        validarSenha(senha);

        validarDuplicidade(login);

        usuarios.add(
                new Usuario(
                        nome,
                        login,
                        senha));
    }

    public boolean login(
            String login,
            String senha) {

        if (login == null
                || senha == null
                || login.isBlank()
                || senha.isBlank()) {

            return false;
        }

        return buscarUsuario(login)
                .map(usuario ->
                        usuario.getSenha()
                                .equals(senha))
                .orElse(false);
    }

    public List<Usuario>
    listarUsuarios() {

        return usuarios;
    }

    private void validarCampos(
            String nome,
            String login,
            String senha) {

        if (nome == null
                || login == null
                || senha == null
                || nome.isBlank()
                || login.isBlank()
                || senha.isBlank()) {

            throw new CampoInvalidoException(
                    "Todos os campos devem ser preenchidos.");
        }
    }

    private void validarSenha(
            String senha) {

        if (senha.length() < 4) {

            throw new CampoInvalidoException(
                    "Senha deve ter no mínimo 4 caracteres.");
        }
    }

    private void validarDuplicidade(
            String login) {

        if (buscarUsuario(login)
                .isPresent()) {

            throw new UsuarioDuplicadoException(
                    "Login já cadastrado.");
        }
    }

    private Optional<Usuario>
    buscarUsuario(
            String login) {

        return usuarios.stream()
                .filter(usuario ->
                        usuario.getLogin()
                                .equalsIgnoreCase(login))
                .findFirst();
    }
}