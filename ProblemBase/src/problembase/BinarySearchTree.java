package problembase;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package problembase;
//
//import java.awt.AWTEventMulticaster;
//import java.util.ArrayList;
//import java.util.Comparator;
//import java.util.Objects;
//import java.util.function.Predicate;

/**
 *
 * @author kaoTuLocalAccount
 */
//public class BinarySearchTree{
//        จาก BinarySearchTree class ซึ่งใช้ array เก็บข้อมูลอยู่เบื้องหลัง และใช้ Comparator ที่กำหนดให้ในการจัดลำดับข้อมูล 
//โดยข้อมูลตัวแรกที่ใส่เข้าไปใน BinarySearchTree นี้ จะใส่ที่ช่องแรกของ array ซึ่งเป็น root node ของ   นี้เสมอ 
//และ array ช่องที่มีค่าเป็น null คือ ช่องที่ไม่มี node ของ tree จงเขียน 
//1. method สร้าง ArrayList ที่ประกอบด้วยสมาชิกที่เกิดการจากท่องไปใน tree แบบ in-order
//2. method สร้าง ArrayList ที่ประกอบด้วยสมาชิกที่เกิดการจากท่องไปใน tree แบบ pre-order
//3. method สร้าง ArrayList ที่ประกอบด้วยสมาชิกที่เกิดการจากท่องไปใน tree แบบ post-order

//    public int size = 0;
//    public Node<E> root ;
//    ArrayList<E> arl = new ArrayList<>();
//    
//    public BinarySearchTree() {
//    }

//    public BinarySearchTree(E[] obj) {
//        for(int i =0; i<obj.length;i++){
//            add.
//        }
//    }
    
//    public boolean insert(Object<E> element) {
//        if(root == null){
//            root = createNode(element);
//        }else {
//            Node<E> parent = null;
//            Node<E> current = root;
//            while(current != null){
//                if(element.compareTo(current.element) < 0){
//                    parent = current;
//                    current = current.left;
//                }else if(element.compareTo(current.element) > 0){
//                    parent = current;
//                    current = current.right;
//                }else{
//                    return false;
//                }
//            }
//            if(element.compareTo(parent.element) < 0){
//                parent.left = createNode(element);
//            }else{
//                parent.right = createNode(element);
//            }
//        }
//        size++;
//        return true;
//    }
//
////    @Override
//    public Node createNode(Object element) {
//        return new Node<>(element);
//    }
//    
////    @Override
//    public int getSize() {
//        return size;
//    }
//
////    @Override
//    public Node<E> getRoot() {
//        return root;
//    }
//
////    @Override
//    public void inOrder() {
//        inOrder(root);
//    }
//    
//    public ArrayList<E> inOrder(Node<E> root) {
////        T(L),R,T(R)
//        if(root == null){
//            return arl;
//        }
//        inOrder(root.left);
//        System.out.println(root.element + " ");
//        inOrder(root.right);
//        return arl;
//    }
//
////    @Override
//    public void preOrder() {
//        preOrder(root);
//    }
//    public ArrayList<E> preOrder(Node<E> root) {
////        R,T(L),T(R)
//        if(root == null){
//            return arl;
//        }
//        System.out.println(root.element + " ");
//        preOrder(root.left);
//        preOrder(root.right);
//        return arl;
//    }
//
////    @Override
//    public void postOrder() {
//        postOrder(root);
//    }
//    
//    public ArrayList<E> postOrder(Node<E> root) {
////    T(L),T(R),R    
//        if(root == null){
//            return arl;
//        }
//        postOrder(root.left);
//        postOrder(root.right);
//        System.out.println(root.element + " ");
//        return arl;
//    }

//    @Override
//    public boolean insert(Object element) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;
import java.util.function.Predicate;

public class BinarySearchTree<T extends Comparable<? super T>> {
    T[] content;
    Comparator<T> comparator;
    
    public BinarySearchTree() { 
        this(Comparator.naturalOrder()); 
    }
    
    public BinarySearchTree(Comparator<T> comparator) { 
        this.comparator = Objects.requireNonNull(comparator);
        content = (T[]) new Comparable[8];
    }

    public void add(T t) {
        Objects.requireNonNull(t);
        add(0, t);
    }
    
    private void add(int i, T t) {
        if (i >= content.length) resize(i<<1);
        if (content[i] == null) {
            content[i] = t;
        } else if (comparator.compare(content[i], t)>0) {
            add((i<<1)+1, t);
        } else {
            add((i+1)<<1, t);
        }
    }
    
    private void resize(int size) {
        T[] newContent = (T[]) new Comparable[size];
        System.arraycopy(content, 0, newContent, 0, content.length);
        content = newContent;
    }

    public T search(T t) {
        if (content[0] == null || t == null) return null;
        return search(0, t);
    }

    private T search(int i, T t) {
        if (i >= content.length || content[i] == null) return null;
        int test = comparator.compare(content[i], t);
        if (test > 0) return search((i<<1)+1, t);
        if (test < 0) return search((i+1)<<1, t);
        return content[i];
    }

    public T search(Predicate<T> p) {
        for (T t : content) if (t != null && p.test(t)) return t;
        return null;
    }
    
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        toString(0, s, "");
        return s.toString();
    }
    
    private void toString(int i, StringBuilder s, String indent) {
        if (i>= content.length || content[i]==null) return;
        s.append(indent).append(content[i]).append("\n");
        toString((i<<1) + 1, s, indent + "-lt> ");
        toString((i+1) << 1, s, indent + "-rt> ");
    }
    
    ArrayList<T> arl = new ArrayList<>();

    public void inOrder() {
            inOrder(0);
    }
    
    public ArrayList<T> inOrder(int i) {
//        T(L),R,T(R)
        if(i >= content.length || content[i] == null){
            return arl;
        }
        inOrder((i<<1) + 1);
        System.out.print(content[i] + " ");
        inOrder((i+1) << 1);
        return arl;
    }    

    public void preOrder() {
        preOrder(0);
    }
    public ArrayList<T> preOrder(int i) {
//        R,T(L),T(R)
        if(i >= content.length || content[i] == null){
            return arl;
        }
        System.out.print(content[i] + " ");
        preOrder((i<<1) + 1);
        preOrder((i+1) << 1);
        return arl;
    }

    public void postOrder() {
        postOrder(0);
    }
    
    public ArrayList<T> postOrder(int i) {
//    T(L),T(R),R    
        if(i >= content.length || content[i] == null){
            return arl;
        }
        postOrder((i<<1) + 1);
        postOrder((i+1) << 1);
        System.out.print(content[i] + " ");
        return arl;
    }
}
