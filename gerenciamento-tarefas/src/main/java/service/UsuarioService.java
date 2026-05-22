package service;

import model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioService {

    private List<Usuario> usuarios = new ArrayList<>();

    public void cadastrar(String nome, String login, String senha) {

        if (nome.isBlank() || login.isBlank() || senha.isBlank()) {
            throw new IllegalArgumentException("Campos obrigatórios");
        }

        if (senha.length() < 6) {
            throw new IllegalArgumentException("Senha deve ter no mínimo 6 caracteres");
        }

        for (Usuario usuario : usuarios) {
            if (usuario.getLogin().equals(login)) {
                throw new IllegalArgumentException("Login já existe");
            }
        }

        usuarios.add(new Usuario(nome, login, senha));
    }

    public boolean login(String login, String senha) {

        if (login.isBlank() || senha.isBlank()) {
            return false;
        }

        for (Usuario usuario : usuarios) {
            if (usuario.getLogin().equals(login)
                    && usuario.getSenha().equals(senha)) {
                return true;
            }
        }

        return false;
    }

    public List<Usuario> listarUsuarios() {
        return usuarios;
    }
}