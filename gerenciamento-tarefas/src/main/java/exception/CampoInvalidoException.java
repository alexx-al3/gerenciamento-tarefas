package exception;

public class CampoInvalidoException
        extends RuntimeException {

    public CampoInvalidoException(
            String mensagem) {

        super(mensagem);
    }
}