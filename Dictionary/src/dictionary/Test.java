/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author PROG076
 */
public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Dictionary dictionary = new Dictionary();
        dictionary.add(new Word("study", "a detailed investigation and analysis of a subject or situation."));
        dictionary.add(new Word("eat", "put (food) into the mouth and chew and swallow it."));
        dictionary.add(new Word("try", "make an attempt or effort to do somrthing."));
        while (true) {
                System.out.print("SearchWord : ");
                String word = sc.next();
                Word result = dictionary.search(word.toLowerCase());
                if (result == null) {
                    System.out.println("Word not found");
                } else {
                    System.out.println("Defination: " + result.getDefinition());
                }
        }
    }
}
