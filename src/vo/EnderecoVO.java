package vo;

public class EnderecoVO {
    private String bairro;
    private String cidade;
    private int codigoEndereco;
    private String estado;
    private int numeroCasa;
    private String pais;
    private String rua;

    public EnderecoVO(String bairro, String cidade, int codigoEndereco, String estado, int numeroCasa, String pais, String rua) {
        this.bairro = bairro;
        this.cidade = cidade;
        this.codigoEndereco = codigoEndereco;
        this.estado = estado;
        this.numeroCasa = numeroCasa;
        this.pais = pais;
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public int getCodigoEndereco() {
        return codigoEndereco;
    }

    public void setCodigoEndereco(int codigoEndereco) {
        this.codigoEndereco = codigoEndereco;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getNumeroCasa() {
        return numeroCasa;
    }

    public void setNumeroCasa(int numeroCasa) {
        this.numeroCasa = numeroCasa;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }
    
    @Override
    public String toString(){
        String s = "bairro: " + this.bairro + "\n";
        s += "cidade: " + this.cidade + "\n";
        s += "codigoEndereco: " + this.codigoEndereco + "\n";
        s += "estado: " + this.estado + "\n";
        s += "numeroCasa: " + this.numeroCasa + "\n";
        s += "pais: " + this.pais + "\n";
        s += "rua: " + this.rua;
        return s;
    }
}
