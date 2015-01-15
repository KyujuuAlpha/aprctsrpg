package ui;

import javax.swing.*;
import java.awt.*;

public class Choice {
    private String text;
    
    public Choice(String stringVar) {
        this.text = stringVar;
    }
    
    public String getLabel() {
        return this.text;
    }
    
    public static void sync(Stage stageVar) {
        JPanel panelVar = Window.getComponentPanel("choice");
        if(Stage.getStage().getChoices() == null) return;
        else panelVar.removeAll();
        panelVar.setLayout(new GridLayout(stageVar.getChoices().length, 1));
        for(int i = 0; i < stageVar.getChoices().length; i++) {
            JButton jb = new JButton(stageVar.getChoices()[i].getLabel());
            jb.addActionListener(Window.getInstance());
            panelVar.add(jb);
        }
        panelVar.revalidate();
        panelVar.repaint();
    }
}
