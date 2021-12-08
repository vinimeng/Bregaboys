package vo;

public class CompraVO{
    private int codigoCliente;
    private int codigoCompra;
    private int codigoTransportadora;
    
    public CompraVO() {
    }
    
    public CompraVO(int codigoCliente, int codigoCompra, int codigoTransportadora){
        this.codigoCliente = codigoCliente;
        this.codigoCompra = codigoCompra;
        this.codigoTransportadora = codigoTransportadora;
    }

    public int getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(int codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public int getCodigoCompra() {
        return codigoCompra;
    }

    public void setCodigoCompra(int codigoCompra) {
        this.codigoCompra = codigoCompra;
    }

    public int getCodigoTransportadora() {
        return codigoTransportadora;
    }

    public void setCodigoTransportadora(int codigoTransportadora) {
        this.codigoTransportadora = codigoTransportadora;
    }
    
    @Override
    public String toString(){
        String s = "codigoCliente: " + this.codigoCliente + "\n";
        s += "codigoCompra: " + this.codigoCompra + "\n";
        s += "codigoTransportadora: " + this.codigoTransportadora;
        return s;
    }
}
