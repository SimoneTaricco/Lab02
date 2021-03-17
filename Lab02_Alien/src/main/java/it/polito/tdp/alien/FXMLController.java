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
    		
    		String result = model.translateWord(str.toLowerCase());
    		
    		if (result == null) {
    			txtResult.setText("Word '" + str.trim() + "' not in the dictionary.");
    			return;
    		}
    		
    		txtResult.setText(str.trim() + " = " + result);
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