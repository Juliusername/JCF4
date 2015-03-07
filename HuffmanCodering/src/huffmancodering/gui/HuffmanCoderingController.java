package woordenapplicatie.gui;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import huffmancodering.gui.CharacterFreq;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author frankcoenen
 */
public class HuffmanCoderingController implements Initializable {
    
   private static final String DEFAULT_TEXT =   "Bananen";
    
    @FXML
    private Button btnCodeer;
    @FXML
    private TextArea taInput;
    @FXML
    private Button btnDecodeer;
    @FXML
    private TextArea taOutput;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        taInput.setText(DEFAULT_TEXT);
    }
    
    @FXML
    private void codeerAction(ActionEvent event) {
        
        //Stap 1
        List<CharacterFreq> frequentie = getFrequentie(taInput.getText());
        
        //Stap 2
        frequentie = sorteerFrequentie(frequentie);
        
        
        
        //PRINT
        String output = "";
        for (CharacterFreq cf : frequentie)
        {
            output += cf.getCharacter() + "\t" + "\t" + cf.getFrequence() + "\n";
        }
        taOutput.setText(output);
    }

    @FXML
    private void decodeerAction(ActionEvent event) {
         
          
    }

    private List<CharacterFreq> getFrequentie(String text)
    {
//        HashSet<CharacterFreq> uniqueChars = new HashSet();
//        for (char c : text.toCharArray())
//        {
//            uniqueChars.add(new CharacterFreq(c, 0));
//        }
//        
//        for (CharacterFreq cf : uniqueChars)
//        {
//            for (char c: text.toCharArray())
//            {
//                if (cf.getCharacter() == c)
//                {
//                    cf.incrementFrequence();
//                }
//            }
//        }
        
        HashMap<Character,Integer> uniqueChars = new HashMap<Character,Integer>();          
        for(int i = 0; i < text.length(); i++){
           char c = text.charAt(i);
           Integer val = uniqueChars.get(new Character(c));
           if(val != null){
             uniqueChars.put(c, new Integer(val + 1));
           }else{
             uniqueChars.put(c,1);
           }
        }
        
        List<CharacterFreq> characterFreqs = new ArrayList<CharacterFreq>();
        for (Map.Entry<Character, Integer> entry : uniqueChars.entrySet())
        {
            characterFreqs.add(new CharacterFreq(entry.getKey(), entry.getValue()));
        }
        return characterFreqs;
    }
    
    private List<CharacterFreq> sorteerFrequentie(List<CharacterFreq> frequentie)
    {
        Collections.sort(frequentie);
        return frequentie;
    }
}