package it.polito.tdp.alien;

import java.util.*;

public class Word {
	
	private String alienWord;
	private String translation;	
	
	private List<String> translations;
		
	public Word(String alienWord, String translation) {
		this.alienWord = alienWord;
		this.translation = translation;
		this.translations = new ArrayList<String>();
	}
	
	
	public String getAlienWord() {
		return this.alienWord;
	}

	public void setAlienWord(String alienWord) {
		this.alienWord = alienWord;
	}

	public String getTranslation() {
		return this.translationsString();
	}

	/*public void setTranslation(String translation) {
		this.translation = translation;
	}*/
	
	public String translationsString() {
		
		String result = "";
		
		for (String s:this.translations)
			result += s + "\n\t";
		
		return result.trim();
	}
	
	public void addTranslation(String translation) {
		
		if (this.translations.contains(translation) == false)
			this.translations.add(translation);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alienWord == null) ? 0 : alienWord.hashCode());
		result = prime * result + ((translation == null) ? 0 : translation.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {

		if (obj == null)
			return false;
		
		String other = (String) obj;
				
		if (this.alienWord.toLowerCase().equals(other))
			return true;
		
		return false;
	}
	
	

}
