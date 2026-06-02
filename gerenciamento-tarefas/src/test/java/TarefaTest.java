import exception.TarefaDuplicadaException;
import org.junit.jupiter.api.Test;
import service.TarefaService;

import static org.junit.jupiter.api.Assertions.*;

public class TarefaTest {

    @Test
    void testeCadastrarTarefa() {

        TarefaService service =
                new TarefaService();

        service.cadastrar(
                "Estudar Java",
                "Revisar POO");

        assertEquals(
                1,
                service.listarTarefas()
                        .size());
    }

    @Test
    void testeDuplicidadeTarefa() {

        TarefaService service =
                new TarefaService();

        service.cadastrar(
                "Estudar",
                "Java");

        assertThrows(
                TarefaDuplicadaException.class,
                () -> service.cadastrar(
                        "Estudar",
                        "Outra descrição"));
    }
}