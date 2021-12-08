package vo;

public class ProdutoVO{
    private int codigoFornecedor;
    private int codigoProduto;
    private int codigoSecao;
    private String nomeProduto;
    private float valorUnitario;
    private int codigoImagem;
    
    public ProdutoVO(int codigoFornecedor, int codigoProduto, int codigoSecao, int codigoImagem, String nomeProduto, float valorUnitario){
        this.codigoFornecedor = codigoFornecedor;
        this.codigoProduto = codigoProduto;
        this.codigoSecao = codigoSecao;
        this.nomeProduto = nomeProduto;
        this.valorUnitario = valorUnitario;
        this.codigoImagem = codigoImagem;
    }

    public int getCodigoFornecedor() {
        return codigoFornecedor;
    }

    public void setCodigoFornecedor(int codigoFornecedor) {
        this.codigoFornecedor = codigoFornecedor;
    }

    public int getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(int codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public int getCodigoSecao() {
        return codigoSecao;
    }

    public void setCodigoSecao(int codigoSecao) {
        this.codigoSecao = codigoSecao;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public float getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(float valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public int getCodigoImagem() {
        return codigoImagem;
    }

    public void setCodigoImagem(int codigoImagem) {
        this.codigoImagem = codigoImagem;
    }
    
    @Override
    public String toString() {
        String s = "codigoFornecedor: " + this.codigoFornecedor + "\n";
        s += "codigoProduto: " + this.codigoProduto + "\n";
        s += "codigoSecao: " + this.codigoSecao + "\n";
        s += "nomeProduto: " + this.nomeProduto + "\n";
        s += "valorUnitario: " + this.valorUnitario;
        return s;
    }

    
}