package vo;

public class CategoriaSalarioVO{
    private int codigoCategoriaSalario;
    private float valorCategoriaSalario;

    public CategoriaSalarioVO() {
    }

    public CategoriaSalarioVO(int codigoCategoriaSalario, float valorCategoriaSalario) {
        this.codigoCategoriaSalario = codigoCategoriaSalario;
        this.valorCategoriaSalario = valorCategoriaSalario;
    }
    public int getCodigoCategoriaSalario() {
        return codigoCategoriaSalario;
    }

    public void setCodigoCategoriaSalario(int codigoCategoriaSalario) {
        this.codigoCategoriaSalario = codigoCategoriaSalario;
    }

    public float getValorCategoriaSalario() {
        return valorCategoriaSalario;
    }

    public void setValorCategoriaSalario(float valorCategoriaSalario) {
        this.valorCategoriaSalario = valorCategoriaSalario;
    }

    @Override
    public String toString() {
        String s = "codigoCategoriaSalario: " + this.codigoCategoriaSalario + "\n";
        s += "valorCategoriaSalario: " + this.valorCategoriaSalario;
        return s;
    }
}
