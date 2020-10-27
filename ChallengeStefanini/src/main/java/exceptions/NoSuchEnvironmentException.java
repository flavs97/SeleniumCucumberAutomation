package exceptions;

/**
 * Author: Rafael Jordão
 */
public class NoSuchEnvironmentException extends Exception {

    public NoSuchEnvironmentException(String env) {
        super("Ambiente requisitado : \""+env+"\" não encontrado!");
    }

}
