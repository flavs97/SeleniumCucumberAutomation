package exceptions;

/**
 * Author: Rafael Jordão
 */
public class NoSuchAttributeInEnvironmentException extends Exception {

    public NoSuchAttributeInEnvironmentException(String attrib) {
        super("Atributo requisitado : \""+attrib+"\" não encontrado no objeto!");
    }

}
