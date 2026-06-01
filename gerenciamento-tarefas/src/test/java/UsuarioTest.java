import org.junit.jupiter.api.Test;
import service.UsuarioService;

import static org.junit.jupiter.api.Assertions.*;

public class UsuarioTest {

    @Test
    void testeLoginValido() {

        UsuarioService service = new UsuarioService();

        service.cadastrar(
                "Alex",
                "alex",
                "1234");

        assertTrue(
                service.login("alex", "1234"));
    }

    @Test
    void testeLoginInvalido() {

        UsuarioService service = new UsuarioService();

        service.cadastrar(
                "Alex",
                "alex",
                "1234");

        assertFalse(
                service.login("alex", "9999"));
    }

    @Test
    void testeLoginVazio() {

        UsuarioService service = new UsuarioService();

        assertFalse(
                service.login("", ""));
    }
}