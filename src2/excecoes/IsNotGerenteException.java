/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excecoes;

/**
 *
 * @author Vinicius Meng
 */
public class IsNotGerenteException extends Exception{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 4590932636695243730L;

	@Override
    public String getMessage(){
       return "Você não é um gerente!"; 
    }     
    
}
