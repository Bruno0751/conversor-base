package dev.view;

import dev.controller.BaseController;
import javax.swing.JOptionPane;

/**
 *
 * @author Bruno Gressler vda Silveira
 * @since 10/02/2025
 * @version 1
 */
public class ConvertBases {
    
    public static void main(String args[]) {
        
        try {
            BaseController.init();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
