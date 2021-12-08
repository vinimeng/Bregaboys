package vo;

public class TransportadoraVO{
    private int codigoEndereco;
    private int codigoTransportadora;
    private String emailTransportadora;
    private String nomeTransportadora;
    private String telefoneTransportadora;

    public TransportadoraVO(int codigoEndereco, int codigoTransportadora, String emailTransportadora, String nomeTransportadora, String telefoneTransportadora) {
        this.codigoEndereco = codigoEndereco;
        this.codigoTransportadora = codigoTransportadora;
        this.emailTransportadora = emailTransportadora;
        this.nomeTransportadora = nomeTransportadora;
        this.telefoneTransportadora = telefoneTransportadora;
    }

    public int getCodigoEndereco() {
        return codigoEndereco;
    }

    public void setCodigoEndereco(int codigoEndereco) {
        this.codigoEndereco = codigoEndereco;
    }

    public int getCodigoTransportadora() {
        return codigoTransportadora;
    }

    public void setCodigoTransportadora(int codigoTransportadora) {
        this.codigoTransportadora = codigoTransportadora;
    }

    public String getEmailTransportadora() {
        return emailTransportadora;
    }

    public void setEmailTransportadora(String emailTransportadora) {
        this.emailTransportadora = emailTransportadora;
    }

    public String getNomeTransportadora() {
        return nomeTransportadora;
    }

    public void setNomeTransportadora(String nomeTransportadora) {
        this.nomeTransportadora = nomeTransportadora;
    }

    public String getTelefoneTransportadora() {
        return telefoneTransportadora;
    }

    public void setTelefoneTransportadora(String telefoneTransportadora) {
        this.telefoneTransportadora = telefoneTransportadora;
    }
    
    @Override
    public String toString(){
       String s = "codigoEndereco: " + this.codigoEndereco + "\n";
       s += "codigoTransportadora: " + this.codigoTransportadora + "\n";
       s += "emailTransportadora: " + this.emailTransportadora + "\n";
       s += "nomeTransportadora: " + this.nomeTransportadora + "\n";
       s += "telefoneTransportadora: " + this.telefoneTransportadora;
       return s;
    }
}