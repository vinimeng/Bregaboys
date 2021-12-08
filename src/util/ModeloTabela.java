
package util;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Thiago
 */
public class ModeloTabela extends DefaultTableModel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1813610994277758701L;

	public ModeloTabela() {
    }
    
    public ModeloTabela(Object[][] os, Object[] os1) {
        super(os, os1);
    }
    
    @Override
    public boolean isCellEditable(int linha, int coluna){  
    return false;  
    }  

}
