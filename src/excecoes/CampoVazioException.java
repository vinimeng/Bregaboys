package excecoes;

public class CampoVazioException extends Exception {
    @Override
    public String getMessage(){
        return "Os campos não podem estar vazios!";
    }
}
