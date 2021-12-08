package excecoes;

/**
 *
 * @author Vinicius Meng
 */
public class NSelecionouClienteException extends Exception{
    /**
	 * 
	 */
	private static final long serialVersionUID = -830826765911072855L;

	@Override
    public String getMessage(){
        return "Você deve selecionar um cliente primeiro!";
    }
}
