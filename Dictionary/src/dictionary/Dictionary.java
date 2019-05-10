/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author PROG076
 */
public class Dictionary{
    
    private HashMap<String,Word> dictionary = new HashMap<String,Word>();
    
    public Dictionary() {
        this.dictionary = new HashMap<String, Word>();
    }
    
    public void add(Word newWord){
        dictionary.put(newWord.getWord(), newWord);
    }
    
    public Word search(String searchWord) throws NullPointerException{
            return dictionary.get(searchWord);
    }
    
}
