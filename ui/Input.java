package ui;

import javax.swing.*;
import java.awt.*;

public class Input {
    private static int idCount = 0;
    
    private int id;
    private int size;
    
    public int arrayId = -1;
    
    public Input(int intVar) {
        this.size = intVar;
        this.id = idCount;
        idCount++;
    }
    
    public int getSize() {
        return this.size;
    }
    
    public int getID() {
        return this.id;
    }
    
    public String getText() {
        if(arrayId > -1) {
            return Window.getTextFromField(arrayId);
        }
        return "";
    }
    
    public static void sync(Stage stageVar) {
        JPanel panelVar = Window.getComponentPanel("input");
        if(stageVar.getInputs() == null) return;
        else panelVar.removeAll();
        panelVar.setLayout(new BoxLayout(panelVar, BoxLayout.Y_AXIS));
        for(int i = 0; i < stageVar.getInputs().length; i++) {
            stageVar.getInputs()[i].arrayId = i;
            JTextField jT = new JTextField(stageVar.getInputs()[i].getSize());
            jT.setMaximumSize(jT.getPreferredSize());
            jT.setAlignmentX(0.0F);
            panelVar.add(jT);
        }
        panelVar.revalidate();
        panelVar.repaint();
    }
}
