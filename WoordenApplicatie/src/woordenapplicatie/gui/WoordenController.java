package woordenapplicatie.gui;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.TreeMap;
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
public class WoordenController implements Initializable {
    
   private static final String DEFAULT_TEXT =   "Een, twee, drie, vier\n" +
                                                "Hoedje van, hoedje van\n" +
                                                "Een, twee, drie, vier\n" +
                                                "Hoedje van papier\n" +
                                                "\n" +
                                                "Heb je dan geen hoedje meer\n" +
                                                "Maak er één van bordpapier\n" +
                                                "Eén, twee, drie, vier\n" +
                                                "Hoedje van papier\n" +
                                                "\n" +
                                                "Een, twee, drie, vier\n" +
                                                "Hoedje van, hoedje van\n" +
                                                "Een, twee, drie, vier\n" +
                                                "Hoedje van papier\n" +
                                                "\n" +
                                                "En als het hoedje dan niet past\n" +
                                                "Zetten we 't in de glazenkas\n" +
                                                "Een, twee, drie, vier\n" +
                                                "Hoedje van papier";
    
    @FXML
    private Button btAantal;
    @FXML
    private TextArea taInput;
    @FXML
    private Button btSorteer;
    @FXML
    private Button btFrequentie;
    @FXML
    private Button btConcordantie;
    @FXML
    private TextArea taOutput;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        taInput.setText(DEFAULT_TEXT);
    }
    
    @FXML
    private void aantalAction(ActionEvent event) {
        
        List<String> AllWords = getAllWords(taInput.getText());  
        
        Set<String> UniqueWords = getUniqueWords(AllWords);
        
        taOutput.setText("Totaal aantal woorden: " + AllWords.size() + "\n" + "Aantal verschillende woorden: " + UniqueWords.size());
    }

    @FXML
    private void sorteerAction(ActionEvent event) {
         
         Set<String> UniqueWords = getUniqueWords(getAllWords(taInput.getText()));
         List<String> UniqueWordsList = new ArrayList(UniqueWords);
         
         Collections.sort(UniqueWordsList);
         Collections.reverse(UniqueWordsList);
         
         String output = "";
         
         for (String s : UniqueWordsList)
         {
             output += s + "\n";
         }
         
         taOutput.setText(output); 
    }

    @FXML
    private void frequentieAction(ActionEvent event) {
         
        List<String> AllWords = getAllWords(taInput.getText());
        
        String output = "";
        
        int count = 0;
        boolean done = false;
        
        while (!AllWords.isEmpty())
        {
            String word = AllWords.get(0);
            count = 1;
            AllWords.remove(0);
            
            for (int i = 0; i < AllWords.size(); i++)
            {
                done = false;
                while (!done)
                {
                    if (i < AllWords.size())
                    {
                        if (AllWords.get(i).equals(word))
                        {
                            count++;
                            AllWords.remove(i);
                        }
                        else
                        {
                            done = true;
                        }
                    }
                    else
                    {
                        done = true;
                    }
                }
            }
            
            output += word + "\t" + "\t" + count + "\n";
        }
        
        taOutput.setText(output);
    }

    @FXML
    private void concordatieAction(ActionEvent event) {
         
        String output = "";
        
        Set<String> UniqueWords = getUniqueWords(getAllWords(taInput.getText()));
        
        //Map<String, Set<Integer>> concordance = new HashMap<>();
        
        List<String> lines = Arrays.asList(taInput.getText().split("\n"));
        
        for (String word : UniqueWords)
        {
            output += word + "\t" + "\t" + "[";
            
            //Set<Integer> wordSet = new HashSet();
            
            for (int i = 0; i < lines.size(); i++)
            {
                if (lines.get(i).contains(word))
                {
                    //wordSet.add(i + 1);
                    output += (i + 1) + ", ";
                }
            }
            
            output = output.substring(0, output.length() - 2) + "]" + "\n";
            //concordance.put(word, wordSet);
        }
        
        taOutput.setText(output);
    }
   
    /**
     * Gets all the words from a String and puts them in a List<String>
     * @param text
     * @return 
     */
    private List<String> getAllWords(String text)
    {
        List<String> list = Arrays.asList(text.split("\n"));
        
        List<String> list2 = new ArrayList();
        
        for (String value : list)
        {
            for (String s : value.split(" "))
            {
                if (!s.isEmpty())
                {
                    if (s.contains(","))
                    {
                        list2.add(s.substring(0, s.length() - 1));
                    }
                    else
                    {
                        list2.add(s);
                    }
                }
            }
        }
        
        return list2;
    }
    
    /**
     * Gets all the unique words from a List<String> and puts them in a HashSet
     * @param list
     * @return 
     */
    private HashSet getUniqueWords(List<String> list)
    {
        return new HashSet(list);
    }
}
