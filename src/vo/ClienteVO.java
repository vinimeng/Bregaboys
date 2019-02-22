package vo;

public class ClienteVO{
    private int codigoCliente;
    private int codigoEndereco;
    private String senhaCliente;
    private String emailCliente;
    private String nomeCliente;
    private String telefoneCliente;

    public ClienteVO() {
    }
    
    public ClienteVO(int codigoCliente, int codigoEndereco, String senhaCliente, String emailCliente, String nomeCliente, String telefoneCliente){
        this.codigoCliente = codigoCliente;
        this.codigoEndereco = codigoEndereco;
        this.senhaCliente = senhaCliente;
        this.emailCliente = emailCliente;
        this.nomeCliente = nomeCliente;
        this.telefoneCliente = telefoneCliente;
    }
    
    public int getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(int codigoCliente) {
        this.codigoCliente = codigoCliente;
    }
    
    public int getCodigoEndereco() {
        return codigoEndereco;
    }

    public void setCodigoEndereco(int codigoEndereco) {
        this.codigoEndereco = codigoEndereco;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getTelefoneCliente() {
        return telefoneCliente;
    }

    public void setTelefoneCliente(String telefoneCliente) {
        this.telefoneCliente = telefoneCliente;
    }
    
    public String getSenhaCliente() {
        return senhaCliente;
    }

    public void setSenhaCliente(String senhaCliente) {
        this.senhaCliente = senhaCliente;
    }
    
    @Override
    public String toString(){
        String s = "codigoCliente: " + this.codigoCliente + "\n";
        s += "codigoEndereco: " + this.codigoEndereco + "\n";
        s += "emailCliente: " + this.emailCliente + "\n";
        s += "nomeCliente: " + this.nomeCliente + "\n";
        s += "telefoneCliente: " + this.telefoneCliente;
        return s;
    }
}


