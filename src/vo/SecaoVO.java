package vo;

public class SecaoVO{
   private int codigoSecao;
   private String nomeSecao;

    public SecaoVO(int codigoSecao, String nomeSecao) {
        this.codigoSecao = codigoSecao;
        this.nomeSecao = nomeSecao;
    }

    public int getCodigoSecao() {
        return codigoSecao;
    }

    public void setCodigoSecao(int codigoSecao) {
        this.codigoSecao = codigoSecao;
    }

    public String getNomeSecao() {
        return nomeSecao;
    }

    public void setNomeSecao(String nomeSecao) {
        this.nomeSecao = nomeSecao;
    }

    @Override
    public String toString() {
        String s = "ccodigoSecao: " + this.codigoSecao + "\n";
        s += "nomeSecao: " + this.nomeSecao;
        return s;
    }
}
