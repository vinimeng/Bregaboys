package vo;

public class CompraProdutoVO{
    private int codigoCompra;
    private int codigoProduto;
    private int quantidadeProduto;
  
    public CompraProdutoVO() {
    }
    
    public CompraProdutoVO(int codigoCompra, int codigoProduto, int quantidadeProduto){
        this.codigoCompra = codigoCompra;
        this.codigoProduto = codigoProduto;
        this.quantidadeProduto = quantidadeProduto;
    }

    public int getCodigoCompra() {
        return codigoCompra;
    }

    public void setCodigoCompra(int codigoCompra) {
        this.codigoCompra = codigoCompra;
    }

    public int getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(int codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public int getQuantidadeProduto() {
        return quantidadeProduto;
    }

    public void setQuantidadeProduto(int quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
    }

    @Override
    public String toString() {
        String s = "codigoCompra: " + this.codigoCompra + "\n";
        s += "codigoProduto: " + this.codigoProduto + "\n";
        s += "quantidadeProduto: " + this.quantidadeProduto;
        return s;
    }
}
