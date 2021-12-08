package excecoes;

public class NEscTrnasportadoraException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 2499785932959381921L;

	@Override
    public String getMessage(){
        return "Você deve escolher uma transportadora!";
    }
}