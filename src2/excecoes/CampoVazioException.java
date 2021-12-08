package excecoes;

public class CampoVazioException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = -1602089561670364662L;

	@Override
    public String getMessage(){
        return "Os campos não podem estar vazios!";
    }
}
