package it.polito.tdp.alien;

import java.util.*;

public class AlienDictionary {
	
	private ArrayList <Word> dictionary = new ArrayList <Word>();
	
	public void addWord(String alienWord, String translation) {
		for (Word w:this.dictionary) {
			if (w.equals((Object)alienWord)) {
				w.setTranslation(translation);
				break;
			}
		}

		Word w = new Word(alienWord,translation);
		this.dictionary.add(w);
	}
	
	public String translateWord(String alienWord) {
		for (Word w:this.dictionary) {
			if (w.equals((Object)alienWord)) 
				return w.getTranslation();
		}
		return null;
	}

}
