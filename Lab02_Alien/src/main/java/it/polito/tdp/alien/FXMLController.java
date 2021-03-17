package it.polito.tdp.alien;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;




public class FXMLController {
	
	private AlienDictionary model;
	
	public void setModel(AlienDictionary model) {
		this.model = model;
	}

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private Button btnTranslate;
    
    @FXML
    private Button btnReset;
    
    @FXML
    private TextField txtInput;

    @FXML
    private TextArea txtResult;

    @FXML
    void doTranslate(ActionEvent event) {
    	
    	String str = txtInput.getText();
    	
    	if (str.matches(".*\\d.*")){
    		txtResult.setText("Wrong input format! Words cannot contain numbers.");
			return;
    	}
    	
    	if (str.contains(" ")){
    		String traduzione[] = str.split(" ");
 		
    		if (traduzione.length != 2) {
    			txtResult.setText("Wrong input format!");
    			return;
    		}
    		
    		model.addWord(traduzione[0], traduzione[1]);
    		txtResult.setText("Word added succesfully!");
    	}
    	
    	else if (str.trim().contains(" ") == false) {
    		
    		int questionMarksCounter = 0;
    		
    		for (int i=0;i<str.length();i++) {
    			if (str.charAt(i) == '?')
    				questionMarksCounter++;
    		}
    		
    		if (questionMarksCounter>1) {
    			txtResult.setText("Wrong format - you cannot insert more than one '?'");
    			return;
    		}
    		
    		String result = model.translateWord(str.toLowerCase());
    	
    		if (result == null) {
    			txtResult.setText("Word '" + str.trim() + "' not in the dictionary.");
    			return;
    		}
    		
    		txtResult.setText("Traduzioni della parola cercata");
    		if (questionMarksCounter == 1)
    			txtResult.appendText(" (ricerca con wildcard)");
    		txtResult.appendText(": \n" + result);
    		return;
    	}
    	  	
    }
    
    
    @FXML
    void doReset(ActionEvent event) {
    	txtInput.clear();
    }
    
    
    @FXML
    void initialize() {

    }
}