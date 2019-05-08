/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problembase;

/**
 *
 * @author kaoTuLocalAccount
 */
public class Node<E>{
        public E element;
        public Node<E> left;
        public Node<E> right;

    public Node() {
    }

    public Node(E element) {
        this.element = element;
    }

    
    public E getElement() {
        return element;
    }

    public Node<E> getLeft() {
        return left;
    }

    public Node<E> getRight() {
        return right;
    }

   
        
}
