import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class GUI extends JFrame implements ActionListener {
    
    public int nextNum = 0;
  //-------------------Dictionary Code----------------
    private DLS[]A;
    public int totalWords = 0;
  //--------------------------------------------------
    
    
    private JLabel enterWord,null1,null2,enterCharacter,allCharacterWords,allDictionaryWords;
    private JTextField enterWordT,enterCharacterT,findT,nextT,previousT,findAllT,allCharacterWordsT,allDictionaryWordsT;
    private JButton add,delete,find,next,previous,findAll,clear,exit;
    
    public GUI (){
        super ("Dictionary");
      //-------------------Dictionary Code----------------
         A=new DLS [26];
         for (int i=0;i<26;i++){
             A[i]=new DLS ();
         }
      //--------------------------------------------------
         setLayout (new GridLayout(12,2,10,10));
         enterWord=new JLabel(" Enter a word to add or search ");
         null1=new JLabel("");
         null2=new JLabel("");
         enterCharacter=new JLabel(" Enter a character to search for all its words ");
         allCharacterWords=new JLabel(" All Character Words");
         allDictionaryWords=new JLabel(" All Dictionary Words");
         enterWordT=new JTextField(10);
         enterCharacterT=new JTextField(10);
         findT=new JTextField(10);
         nextT=new JTextField(10);
         previousT=new JTextField(10);
         findAllT=new JTextField(10);
         allCharacterWordsT=new JTextField(10);
         allDictionaryWordsT=new JTextField(10);
         add=new JButton("Add / Search");
         delete=new JButton("Delete Word");
         find=new JButton("The first word");
         next=new JButton("The next word");
         previous=new JButton("The previous word");
         findAll=new JButton("Find All Word");
         clear=new JButton("Clear");
         exit=new JButton("Exit");
         add(enterWord);add(enterWordT);
         add(add);add(null1);
         add(delete);add(null2);
         add(enterCharacter);add(enterCharacterT);
         add(find);add(findT);
         add(next);add(nextT);
         add(previous);add(previousT);
         add(findAll);add(findAllT);
         add(allCharacterWords);add(allCharacterWordsT);
         add(allDictionaryWords);add(allDictionaryWordsT);
         add(clear);add(exit);
         //-----------------------------
         findT.disable();
         nextT.disable();
         previousT.disable();
         findAllT.disable();
         allCharacterWordsT.disable();
         allDictionaryWordsT.disable();
         //-----------------------------
         add.addActionListener(this);
         delete.addActionListener(this);
         find.addActionListener(this);
         next.addActionListener(this);
         previous.addActionListener(this);
         findAll.addActionListener(this);
         clear.addActionListener(this);
         exit.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == add) {
                String data = enterWordT.getText();
                char x = data.charAt(0);
                int weight = characterWeight(x);
                if(weight == -1){
                   null1.setText("Enter a valid word");
                }
                else{
                    String word = changeCharacters(data);
                    boolean ok = A[weight].sortLinked(word);
                    if (ok) {  
                        totalWords++;
                        null1.setText(word + " Has Been Added ");
                        allDictionaryWordsT.setText(totalWords + "");
                        
                        enterCharacterT.setText("");
                        findT.setText("");
                        nextT.setText("");
                        previousT.setText("");
                        findAllT.setText("");
                        allCharacterWordsT.setText("");
                        null2.setText("");
                    }
                    else{
                        null2.setText("");
                        null1.setText("The word already exists");
                    }
                }  
            } 
            // ********-- Button 2 --******** 
            else if (e.getSource() == delete) {
                String data = enterWordT.getText();
                char x = data.charAt(0);
                int weight = characterWeight(x);
                if(weight == -1){
                    null1.setText("");
                    null2.setText("Enter a valid word");
                }
                else{
                    String word = changeCharacters(data);
                    boolean ok = A[weight].remove(word);
                    if(ok){
                        totalWords--;
                        null1.setText("");
                        null2.setText(word + " Has Been Deleted ");
                        allDictionaryWordsT.setText(totalWords+"");
                        
                        enterWordT.setText("");
                        enterCharacterT.setText("");
                        findT.setText("");
                        nextT.setText("");
                        previousT.setText("");
                        findAllT.setText("");
                        allCharacterWordsT.setText("");
                    }
                    else{
                        null2.setText("The word does not exist");
                    }
                    
                }    
            } 
            // ********-- Button 3 --********             
            else if (e.getSource() == find) {
                String charT = enterCharacterT.getText();
                char x = charT.charAt(0);
                int weight = characterWeight(x);
                if(weight == -1){
                   findT.setText("Enter the character correctly");
                }
                else{
                    findT.setText("");
                    nextT.setText("");
                    previousT.setText("");
                    findAllT.setText("");
                    String data = A[weight].getFirst();
                    if (data == null){
                        allCharacterWords.setText(" All Character Words");
                        findT.setText("There are no words .");
                        int totalChar = A[weight].size;
                        allCharacterWordsT.setText(totalChar+"");
                    }
                    else{
                        findT.setText(" The First Word Is ( "+data+" ) ");
                        allCharacterWords.setText(" All Words Of Character "+x);
                        int totalChar = A[weight].size;
                        allCharacterWordsT.setText(totalChar+"");
                    }
                }
            } 
            // ********-- Button 4 --********             
             else if (e.getSource() == next) {
                String charT = enterCharacterT.getText();
                char x = charT.charAt(0);
                int weight = characterWeight(x);
                if(weight == -1){
                   nextT.setText("Enter the character correctly");
                }
                else{
                    String data = A[weight].getNext();
                    if (data == null){
                        findT.setText("There are no words .");
                    }
                    else{
                        nextT.setText("The Next Word Is ( "+data+" )");
                    }
                }
            }
            // ********-- Button 5 --********                         
            else if (e.getSource() == previous) {
                String charT = enterCharacterT.getText();
                char x = charT.charAt(0);
                int weight = characterWeight(x);
                if(weight == -1){
                   nextT.setText("Enter the character correctly");
                }
                else{
                    String data = A[weight].getPrevious();
                    if (data == null){
                        findT.setText("There are no words .");
                    }
                    else{
                        previousT.setText("The previous Word Is ( "+data+" )");
                    }
                }
            }
            // ********-- Button 6 --********             
            else if (e.getSource() == findAll) {
                String charT = enterCharacterT.getText();
                char x = charT.charAt(0);
                int weight = characterWeight(x);
                if(weight == -1){
                   findAllT.setText("Enter the character correctly");
                }
                else{
                    findT.setText("");
                    nextT.setText("");
                    previousT.setText("");
                    findAllT.setText("");
                    String data  = A[weight].report(x);
                    findAllT.setText(data);
                }
            }
            // ********-- Button 7 --********
            else if (e.getSource() == clear) {
                enterWordT.setText("");
                enterCharacterT.setText("");
                findT.setText("");
                nextT.setText("");
                previousT.setText("");
                findAllT.setText("");
                allCharacterWordsT.setText("");
                allDictionaryWordsT.setText("");
                null1.setText("");
                null2.setText("");
                nextNum = 0;
                 
            }
            // ********-- Button 8 --********
            else if (e.getSource() == exit) {
                System.exit(0);
            }
        } 
        
        catch (NumberFormatException a) {
            JOptionPane.showMessageDialog(null, "You Should Enter a Number");
        } 
        
        catch (NegativeArraySizeException a) {
            JOptionPane.showMessageDialog(null, "You Should Enter a Positive Number");
        } 
        
        catch (ArrayIndexOutOfBoundsException a) {
            JOptionPane.showMessageDialog(null, "You Exceed Array Size");
        } 
        
        catch (Exception a) {
            JOptionPane.showMessageDialog(null, "You Should Enter a Word Or Character");
        }
    }
    
    public String changeCharacters(String e){
        String done ="";
        for (int i=0;i<e.length();i++){
            String chr = e.substring(i,i+1);
            if(i==0){
                chr = chr.toUpperCase();
                done+=chr;
            }
            else{
                chr = chr.toLowerCase();
                done+=chr;
            }
        }
        return done;
    }
    
    
    public int characterWeight(char x){
        if(x=='A'||x=='a'){
            return 0;
        }
        else if(x=='B'||x=='b'){
            return 1;
        }
        else if(x=='C'||x=='c'){
            return 2;
        }
        else if(x=='D'||x=='d'){
            return 3;
        }
        else if(x=='E'||x=='e'){
            return 4;
        }
        else if(x=='F'||x=='f'){
            return 5;
        }
        else if(x=='G'||x=='g'){
            return 6;
        }
        else if(x=='H'||x=='h'){
            return 7;
        }
        else if(x=='I'||x=='i'){
            return 8;
        }
        else if(x=='J'||x=='j'){
            return 9;
        }
        else if(x=='K'||x=='k'){
            return 10;
        }
        else if(x=='L'||x=='l'){
            return 11;
        }
        else if(x=='M'||x=='m'){
            return 12;
        }
        else if(x=='N'||x=='n'){
            return 13;
        }
        else if(x=='O'||x=='o'){
            return 14;
        }
        else if(x=='P'||x=='p'){
            return 15;
        }
        else if(x=='Q'||x=='q'){
            return 16;
        }
        else if(x=='R'||x=='r'){
            return 17;
        }
        else if(x=='S'||x=='s'){
            return 18;
        }
        else if(x=='T'||x=='t'){
            return 19;
        }
        else if(x=='U'||x=='u'){
            return 20;
        }
        else if(x=='V'||x=='v'){
            return 21;
        }
        else if(x=='W'||x=='w'){
            return 22;
        }
        else if(x=='X'||x=='x'){
            return 23;
        }
        else if(x=='Y'||x=='y'){
            return 24;
        }
        else if(x=='Z'||x=='z'){
            return 25;
        }
        return -1;
    }
    
}