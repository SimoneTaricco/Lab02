package it.polito.tdp.alien;

import java.util.*;

public class AlienDictionary {
	
	private ArrayList <Word> dictionary = new ArrayList <Word>();
	
	public void addWord(String alienWord, String translation) {
		for (Word w:this.dictionary) {
			if (w.equals((Object)alienWord)) {
				w.addTranslation(translation);
				break;
			}
		}

		Word w = new Word(alienWord,translation);
		this.dictionary.add(w);
		w.addTranslation(translation);
	}
	
	public String translateWord(String alienWord) {
		
		for (Word w:this.dictionary) {
			if (w.equals((Object)alienWord)) 
				return w.getTranslation();
		}
		
		if (alienWord.contains("?")) {
			int position = alienWord.indexOf('?');
			String alienWordWC = alienWord.substring(0,position) + alienWord.substring(position+1,alienWord.length());
			for (Word w:this.dictionary) {
				if (alienWordWC.equals(w.getAlienWord().substring(0,position) + w.getAlienWord().substring(position+1,w.getAlienWord().length())))
					return w.getTranslation();
			}
		}	
		return null;
	}

}
