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
public class Test {

    public static void main(String args[]) throws UnderflowException, Exception {
        DLinkedList<Integer> list = new DLinkedList<Integer>();
        while (true) {
            int option = Integer.parseInt(JOptionPane.showInputDialog(null, "1 - Insere"
                    + "2 - Imprime   3 - remove de uma posicao aleatorio e imprime"
                    + "  4 - numero de Elements   5  - inverte"));
            if (option == 1) {
                int ques = Integer.parseInt(JOptionPane.showInputDialog(null, "numeros a adicionar"));
                for (int i = 0; i < ques; i++) {
                    int num = Integer.parseInt(JOptionPane.showInputDialog(null, "numero"));
                    list.insertLast(num);
                }
            } else if (option == 2) {
                DNode<Integer> aux = list.getFirst();
                String auxS = "Elementos: \n";
                while (aux != null) {
                    auxS += aux.getElement() + ", ";
                    aux = aux.getNext();
                }
                System.out.println(auxS);
            } else if (option == 3) {
                int a = (int) (Math.random() * list.numElements) - 1;
                int aux = list.removeAnyPos(a);
                System.out.println(aux);
            } else if (option == 4) {
                JOptionPane.showMessageDialog(null, "Numero de Elementos: " + list.numElements());
            } else if (option == 5) {
                list.revert();
            }
        }
    }
}
