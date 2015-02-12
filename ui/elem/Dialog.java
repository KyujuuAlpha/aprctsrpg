package ui.elem;

import ui.*;

import javax.swing.*;
import javax.imageio.*;

import java.awt.*;
import java.awt.image.*;

import java.io.*;

public class Dialog implements Element {
    protected String text;
    protected boolean canSync = false;
    
    protected Display gameVar;
    
    public Dialog() {
        this.text = "";
    }
    
    /**
     * Create a new dialog element
     * Set the dialog's contents to specified text
     * (ALERT) for multiliners, add another parameter: new Dialog("Line1, "Line2");
     */
    public Dialog(String... stringVar) {
        this.text = handleText(stringVar);
    }
    
    /**
     * Get the dialog's text
     */
    public String getText() {
        return this.text.replaceAll("<br>","\n").replace("<html>", "").replace("</html>", "");
    }
    
    /**
     * Set the dialog's contents to specified text
     * (ALERT) for multiliners, add another parameter: dialogVar.setText("Line1, "Line2");
     */
    public void setText(String... stringVar) {
        this.text = handleText(stringVar);
    }
    
    /**
     * Add text onto the dialog's contents
     * (ALERT) for multiliners, add another parameter: dialogVar.appendText("Line1, "Line2");
     */
    public void appendText(String... stringVar) {
        String temp = handleText(stringVar);
        this.text = this.text.replace("</html>", "").replace("<html>", ""); 
        temp = temp.replace("</html>", "").replace("<html>", ""); 
        this.text = "<html>" + this.text + temp + "</html>";
    }
    
    /**
     * Replace ALL certain strings with another
     */
    public void replaceText(String stringVar0, String stringVar1) {
        this.text = this.text.replaceAll(stringVar0, stringVar1);
    }
    
    private String handleText(String[] stringVar) {
        String temp = "<html>";
        if(stringVar.length > 1) {
            for(int i = 0; i < stringVar.length - 1; i++) temp += stringVar[i] + "<br>";
            temp += stringVar[stringVar.length - 1];
        } else temp += stringVar[0];
        temp += "</html>";
        return temp;
    }
    
    @Override
    public void createElement() {
        canSync = true;
    }
    
    @Override
    public void removeElement() {
        gameVar.dialog.setText("");
        canSync = false;
    }
    
    @Override
    public void sync() {
        if(canSync && gameVar != null) gameVar.dialog.setText(this.text);
    }
    
    @Override
    public void setGameInstance(Display displayVar) {
        gameVar = displayVar;
    }
}