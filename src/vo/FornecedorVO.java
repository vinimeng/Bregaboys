package vo;

public class FornecedorVO{
    private int codigoEndereco;
    private int codigoFornecedor;
    private String emailFornecedor;
    private String nomeFornecedor;
    private String telefoneFornecedor;
    
    public FornecedorVO(int codigoEndereco, int codigoFornecedor, String emailFornecedor, String nomeFornecedor, String telefoneFornecedor){
        this.codigoEndereco = codigoEndereco;
        this.codigoFornecedor = codigoFornecedor;
        this.emailFornecedor = emailFornecedor;
        this.nomeFornecedor = nomeFornecedor;
        this.telefoneFornecedor = telefoneFornecedor;
    }

    public int getCodigoEndereco() {
        return codigoEndereco;
    }

    public void setCodigoEndereco(int codigoEndereco) {
        this.codigoEndereco = codigoEndereco;
    }

    public int getCodigoFornecedor() {
        return codigoFornecedor;
    }

    public void setCodigoFornecedor(int codigoFornecedor) {
        this.codigoFornecedor = codigoFornecedor;
    }

    public String getEmailFornecedor() {
        return emailFornecedor;
    }

    public void setEmailFornecedor(String emailFornecedor) {
        this.emailFornecedor = emailFornecedor;
    }

    public String getNomeFornecedor() {
        return nomeFornecedor;
    }

    public void setNomeFornecedor(String nomeFornecedor) {
        this.nomeFornecedor = nomeFornecedor;
    }

    public String getTelefoneFornecedor() {
        return telefoneFornecedor;
    }

    public void setTelefoneFornecedor(String telefoneFornecedor) {
        this.telefoneFornecedor = telefoneFornecedor;
    }

    @Override
    public String toString() {
        String s = "codigoEndereco: " + this.codigoEndereco + "\n";
        s += "codigoFornecedor: " + this.codigoFornecedor + "\n";
        s += "emailFornecedor: " + this.emailFornecedor + "\n";
        s += "nomeFornecedor: " + this.nomeFornecedor + "\n";
        s += "telefoneFornecedor: " + this.telefoneFornecedor;
        return s;
    }
}