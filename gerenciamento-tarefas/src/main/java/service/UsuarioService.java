package service;

import model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioService {

    private List<Usuario> usuarios = new ArrayList<>();

    public void cadastrar(String nome, String login, String senha) {

        if (nome.isEmpty() || login.isEmpty() || senha.isEmpty()) {
            throw new IllegalArgumentException("Campos não podem estar vazios");
        }

        if (senha.length() < 4) {
            throw new IllegalArgumentException("Senha muito curta");
        }

        for (Usuario usuario : usuarios) {
            if (usuario.getLogin().equals(login)) {
                throw new IllegalArgumentException("Login já cadastrado");
            }
        }

        usuarios.add(new Usuario(nome, login, senha));
    }

    public boolean login(String login, String senha) {

        if (login.isEmpty() || senha.isEmpty()) {
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