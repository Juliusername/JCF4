/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package huffmancodering.gui;

/**
 *
 * @author Julius
 */
public class CharacterFreq implements Comparable<CharacterFreq> {
    
    private char character;
    private int frequence;
            
    public CharacterFreq(char character, int frequence)
    {
        this.character = character;
        this.frequence = frequence;
    }
    
    public char getCharacter()
    {
        return character;
    }
    
    public int getFrequence()
    {
        return frequence;
    }
    
    public void incrementFrequence()
    {
        this.frequence++;
    }
    
    @Override
    public int hashCode() {
        return ((Character)character).hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CharacterFreq other = (CharacterFreq) obj;
        if (character != other.getCharacter())
            return false;
        return true;
    }

    @Override
    public int compareTo(CharacterFreq t) {
        
        if (this.frequence > t.getFrequence())
        {
            return 1;
        }
        else if (this.frequence < t.getCharacter())
        {
            return -1;
        }
        else
        {
            return 0;
        }
    }
}
