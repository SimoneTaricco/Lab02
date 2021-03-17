package it.polito.tdp.alien;

public class Word {
	
	private String alienWord;
	private String translation;	
		
	public Word(String alienWord, String translation) {
		this.alienWord = alienWord;
		this.translation = translation;
	}
	
	
	public String getAlienWord() {
		return this.alienWord;
	}

	public void setAlienWord(String alienWord) {
		this.alienWord = alienWord;
	}

	public String getTranslation() {
		return this.translation;
	}

	public void setTranslation(String translation) {
		this.translation = translation;
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
