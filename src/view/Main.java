
package view;

import controller.BaseController;
import javax.swing.JOptionPane;

/**
 *
 * @author Bruno Gressler vda Silveira
 * @since 10/02/2025
 * @version 1
 */
public class Main {
    
    public static void main(String args[]) {
        
        try {
            BaseController.init();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
