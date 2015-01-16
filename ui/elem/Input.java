package ui.elem;

import ui.*;

import javax.swing.*;
import java.awt.*;

public class Input extends Element {
    private int size;
    private String name;
    
    public int arrayId = -1;
    
    public Input(String stringVar, int intVar) {
        this.size = intVar;
        this.name = stringVar;
    }
    
    public int getSize() {
        return this.size;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getText() {
        if(arrayId > -1) {
            return getTextFromField(arrayId);
        }
        return "";
    }
    
    public static void sync(Stage stageVar) {
        JPanel panelVar = getComponentPanel("input");
        if(stageVar.getInputs() == null) return;
        else panelVar.removeAll();
        panelVar.setLayout(new BoxLayout(panelVar, BoxLayout.Y_AXIS));
        for(int i = 0; i < stageVar.getInputs().length; i++) {
            stageVar.getInputs()[i].arrayId = i;
            JPanel temp = new JPanel();
            temp.setLayout(new FlowLayout(FlowLayout.LEFT));
            temp.add(new JLabel(stageVar.getInputs()[i].getName() + ": "));
            JTextField jT = new JTextField(stageVar.getInputs()[i].getSize());
            temp.setMaximumSize(new Dimension((int)panelVar.getWidth(), (int)jT.getPreferredSize().getHeight() + 10));
            temp.add(jT);
            panelVar.add(temp);
        }
        panelVar.revalidate();
        panelVar.repaint();
    }
}
