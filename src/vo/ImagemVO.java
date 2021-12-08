/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vo;

/**
 *
 * @author 05200121
 */
public class ImagemVO {
     private int codigoImagem;
   private String nomeImagem;

    public ImagemVO(int codigoImagem, String nomeImagem) {
        this.codigoImagem = codigoImagem;
        this.nomeImagem = nomeImagem;
    }

    public int getCodigoImagem() {
        return codigoImagem;
    }

    public void setCodigoImagem(int codigoImagem) {
        this.codigoImagem = codigoImagem;
    }

    public String getNomeImagem() {
        return nomeImagem;
    }

    public void setNomeImagem(String nomeImagem) {
        this.nomeImagem = nomeImagem;
    }

    @Override
    public String toString() {
        String s = "codigoImagem: " + this.codigoImagem + "\n";
        s += "nomeImagem: " + this.nomeImagem;
        return s;
    }
}
