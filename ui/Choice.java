package ui;

import javax.swing.*;
import java.awt.*;

public class Choice extends Element {
    private String text;
    
    public Choice(String stringVar) {
        this.text = stringVar;
    }
    
    public String getLabel() {
        return this.text;
    }
    
    public static void sync(Stage stageVar) {
        JPanel panelVar = getComponentPanel("choice");
        if(stageVar.getChoices() == null) return;
        else panelVar.removeAll();
        panelVar.setLayout(new GridLayout(stageVar.getChoices().length, 1));
        for(int i = 0; i < stageVar.getChoices().length; i++) {
            JButton jb = new JButton(stageVar.getChoices()[i].getLabel());
            jb.addActionListener(getWindowInstance());
            panelVar.add(jb);
        }
        panelVar.revalidate();
        panelVar.repaint();
    }
}
