package excecoes;

public class SenhaIncorretaException extends Exception {
    @Override
    public String getMessage(){
        return "A senha inserida está incorreta!";
    }
}
