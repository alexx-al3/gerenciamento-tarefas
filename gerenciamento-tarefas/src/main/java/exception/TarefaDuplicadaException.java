
package exception;

public class TarefaDuplicadaException
        extends RuntimeException {

    public TarefaDuplicadaException(
            String mensagem) {

        super(mensagem);
    }
}