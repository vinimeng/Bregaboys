package excecoes;

public class SenhaIncorretaException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = -69890926166703756L;

	@Override
    public String getMessage(){
        return "A senha inserida está incorreta!";
    }
}
