package excecoes;

/**
 *
 * @author Vinicius Meng
 */
public class NSelecionouClienteException extends Exception{
    @Override
    public String getMessage(){
        return "Você deve selecionar um cliente primeiro!";
    }
}
