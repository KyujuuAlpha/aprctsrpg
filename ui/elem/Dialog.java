package ui.elem;

import ui.*;

public class Dialog implements Element { //w00t inheritance
    protected String text; //protected to stay private, but to give access to these variables from a child class ;)
    protected boolean canSync = false;
    
    protected Display gameVar;
    
    public Dialog() {
        this.text = "";
    }
    
    /**
     * Create a new dialog element
     * Set the dialog's contents to specified text
     * @param stringVar The text of the dialog, new Dialog("Line 1", "Line 2");
     */
    public Dialog(String... stringVar) {
        this.text = handleText(stringVar);
    }
    
    /**
     * Get the dialog's text
     */
    public String getText() {
        return this.text.replaceAll("<br>","\n").replace("<html>", "").replace("</html>", ""); //who wants html artifacts?
    }
    
    /**
     * Set the dialog's contents to specified text
     * @param stringVar The text of the dialog, var.setText("Line 1", "Line 2");
     */
    public void setText(String... stringVar) {
        this.text = handleText(stringVar);
    }
    
    /**
     * Add text onto the dialog's contents
     * @param stringVar The text of the dialog, var.appendText("Line 1", "Line 2");
     */
    public void appendText(String... stringVar) {
        String temp = handleText(stringVar);
        this.text = this.text.replace("</html>", "").replace("<html>", ""); 
        temp = temp.replace("</html>", "").replace("<html>", ""); 
        this.text = "<html>" + this.text + temp + "</html>"; //i should use string builders to save performance, nah.
    }
    
    /**
     * Replace ALL certain strings with another
     * @param stringVar0 The text to replace
     * @param stringVar1 the text that replaces it
     */
    public void replaceText(String stringVar0, String stringVar1) {
        this.text = this.text.replaceAll(stringVar0, stringVar1);
    }
    
    private String handleText(String[] stringVar) { //handle the basic html text logic 4 multiliners!
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
        canSync = true; //you can now change the dialog element!
    }
    
    @Override
    public void removeElement() {
        gameVar.dialog.setText(""); //erase the dialog if this element is removed
        canSync = false; //you cannot change the dialog anymore if you cannot sync
    }
    
    @Override
    public void sync() {
        if(canSync && gameVar != null) gameVar.dialog.setText(this.text); //if you can sync and the display exists, then set  the text of the jlabel!
    }
    
    @Override
    public void setGameInstance(Display displayVar) {
        gameVar = displayVar;
    }
}