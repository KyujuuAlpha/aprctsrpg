package ui.elem;

public class OpponentStat extends Dialog { //inherit all methods from the dialog class
    /**
     * Create a new opponent stat element
     * Set the stat's contents to specified text
     * @param stringVar The text of the dialog, new OpponentStat("Line 1", "Line 2");
     */
    public OpponentStat(String... stringVar) {
        super(stringVar); //call the constructor of the parent class
    }
    
    @Override
    public void removeElement() {
        gameVar.stats2.setText("");
        canSync = false;
    }
    
    @Override
    public void sync() {
        if(canSync) gameVar.stats2.setText(this.text);
    }
}