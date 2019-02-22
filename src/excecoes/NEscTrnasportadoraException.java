package excecoes;

public class NEscTrnasportadoraException extends Exception {
    @Override
    public String getMessage(){
        return "Você deve escolher uma transportadora!";
    }
}