package vo;

public class FuncionarioVO{
    private int codigoCategoriaSalario;
    private int codigoEndereco;
    private int codigoFuncionario;
    private int codigoGerente;
    private int codigoSecao;
    private String senhaFuncionario;
    private String emailFuncionario;
    private String nomeFuncionario;
    private String telefoneFuncionario;

    public FuncionarioVO() {
    }
    
    public FuncionarioVO(int codigoCategoriaSalario, int codigoEndereco, int codigoFuncionario, int codigoGerente, int codigoSecao, String senhaFuncionario, String emailFuncionario, String nomeFuncionario, String telefoneFuncionario) {
        this.codigoCategoriaSalario = codigoCategoriaSalario;
        this.codigoEndereco = codigoEndereco;
        this.codigoFuncionario = codigoFuncionario;
        this.codigoGerente = codigoGerente;
        this.codigoSecao = codigoSecao;
        this.senhaFuncionario = senhaFuncionario;
        this.emailFuncionario = emailFuncionario;
        this.nomeFuncionario = nomeFuncionario;
        this.telefoneFuncionario = telefoneFuncionario;
    }

    public int getCodigoCategoriaSalario() {
        return codigoCategoriaSalario;
    }

    public void setCodigoCategoriaSalario(int codigoCategoriaSalario) {
        this.codigoCategoriaSalario = codigoCategoriaSalario;
    }

    public int getCodigoEndereco() {
        return codigoEndereco;
    }

    public void setCodigoEndereco(int codigoEndereco) {
        this.codigoEndereco = codigoEndereco;
    }

    public int getCodigoFuncionario() {
        return codigoFuncionario;
    }

    public void setCodigoFuncionario(int codigoFuncionario) {
        this.codigoFuncionario = codigoFuncionario;
    }

    public int getCodigoGerente() {
        return codigoGerente;
    }

    public void setCodigoGerente(int codigoGerente) {
        this.codigoGerente = codigoGerente;
    }

    public int getCodigoSecao() {
        return codigoSecao;
    }

    public void setCodigoSecao(int codigoSecao) {
        this.codigoSecao = codigoSecao;
    }
    
    public String getSenhaFuncionario() {
        return senhaFuncionario;
    }

    public void setSenhaFuncionario(String senhaFuncionario) {
        this.senhaFuncionario = senhaFuncionario;
    }
    
    public String getEmailFuncionario() {
        return emailFuncionario;
    }

    public void setEmailFuncionario(String emailFuncionario) {
        this.emailFuncionario = emailFuncionario;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    public String getTelefoneFuncionario() {
        return telefoneFuncionario;
    }

    public void setTelefoneFuncionario(String telefoneFuncionario) {
        this.telefoneFuncionario = telefoneFuncionario;
    }

    @Override
    public String toString() {
        String s = "codigoCategoria: " + this.codigoCategoriaSalario + "\n";
        s += "codigoEndereco: " + this.codigoEndereco + "\n";
        s += "codigoFuncionario: " + this.codigoFuncionario + "\n";
        s += "codigoGerente: " + this.codigoGerente + "\n";
        s += "codigoSecao: " + this.codigoSecao + "\n";
        s += "emailFuncionario: " + this.emailFuncionario + "\n";
        s += "nomeFuncionario: " + this.nomeFuncionario + "\n";
        s += "telefoneFuncionario: " + this.telefoneFuncionario;
        return s;
    }
}
