/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huffmancodering.gui;

/**
 *
 * @author Luke
 */
public class Node implements Comparable<Node> {
    
    public char letter;
    public int freq;
    public String code = null;
    public Node left;
    public Node right;
    
    public Node(char l, int f, Node left, Node right)
    {
        letter = l;
        freq = f;
        this.left = left;
        this.right = right;
    }

    @Override
    public int compareTo(Node t) {
        if (this.freq > t.freq)
        {
            return 1;
        }
        else if (this.freq < t.freq)
        {
            return -1;
        }
        else
        {
            return 0;
        }
    }
}
