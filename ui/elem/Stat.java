package ui.elem;

public class Stat extends Dialog {
    /**
     * Create a new stat element
     * Set the stat's contents to specified text
     * @param stringVar The text of the dialog, new Stat("Line 1", "Line 2");
     */
    public Stat(String... stringVar) {
        super(stringVar);
    }
    
    public Stat() {
        super();
    }
}