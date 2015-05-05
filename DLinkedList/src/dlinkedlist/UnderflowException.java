/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dlinkedlist;

import javax.swing.JOptionPane;

/**
 *
 * @author gschroeder
 */
class UnderflowException extends Exception {
    public void showMessage(){
        JOptionPane.showMessageDialog(null, "There is no elements, sorry");
    }
}
