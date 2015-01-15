package ui;

import javax.swing.*;
import javax.imageio.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

import java.io.*;

public class Window extends JFrame implements ActionListener { 
    private static Painter painterVar;
    private static Window windowVar;
    
    private static JPanel actionsMenu;
    private static JPanel statsMenu;
    private static JPanel ostatsMenu;
    private static JPanel displayMenu;
    private static ImagePanel imageMenu;
    
    private static JPanel ioMenu;
    private static JPanel inMenu;
    
    private static JLabel dialog;
    
    public static void init() {
        windowVar = new Window("RPG");
        Stage.begin();
    }
    
    public Window(String str) {
        super(str);
        this.setSize(800,600);
        displayMenu = new JPanel();
        statsMenu = new JPanel();
        ostatsMenu = new JPanel();
        actionsMenu = new JPanel();
        imageMenu = new ImagePanel();
        ioMenu = new JPanel();
        inMenu = new JPanel();
        this.setLayout(new BorderLayout());
        displayMenu.setLayout(new GridLayout(1,2));
        ioMenu.setLayout(new GridLayout(2,1));
        JPanel temp = new JPanel();
        dialog = new JLabel(" ");
        temp.add(dialog, BorderLayout.WEST);
        ioMenu.add(temp, BorderLayout.WEST);
        ioMenu.add(inMenu);
        displayMenu.add(ioMenu);
        displayMenu.add(imageMenu);
        this.add(displayMenu, BorderLayout.CENTER);
        this.add(statsMenu, BorderLayout.NORTH);
        this.add(ostatsMenu, BorderLayout.SOUTH);
        this.add(actionsMenu, BorderLayout.WEST);
        this.setVisible(true);
    }
    
    public static void updateText() {
        dialog.setText(" " + Stage.getStage().getDialog());
    }
    
    public static void renderDisplay() {
        displayMenu.revalidate();
        displayMenu.repaint();
        updateText();
        syncImages();
    }
    
    public static void syncInputs() {
        if(Stage.getStage().getInputLengths() == null) return;
        else inMenu.removeAll();
        inMenu.setLayout(new BoxLayout(inMenu, BoxLayout.Y_AXIS));
        for(int i = 0; i < Stage.getStage().getInputLengths().length; i++) {
            JTextField jT = new JTextField(Stage.getStage().getInputLengths()[i]);
            jT.setMaximumSize(jT.getPreferredSize());
            jT.setAlignmentX(0.0F);
            inMenu.add(jT);
        }
        inMenu.revalidate();
        inMenu.repaint();
        renderDisplay();
    }
    
    private static void syncImages() { //MY way of adding images next to eachother without adding another painter
        if(Stage.getStage().getImages() == null) return;
        else imageMenu.removeAll();
        imageMenu.setLayout(new GridLayout(1, Stage.getStage().getImages().length));
        for(int i = 0; i < Stage.getStage().getImages().length; i++) {
            if(Stage.getStage().getImages()[i].length() < 1) continue;
            JLabel jl = new JLabel();
            BufferedImage bufferedImage;
            try { bufferedImage = ImageIO.read(new File("resources/" + Stage.getStage().getImages()[i] + ".png"));
            } catch(Exception e) { bufferedImage = null; }
            Image image = bufferedImage.getScaledInstance(bufferedImage.getWidth() / bufferedImage.getHeight() * imageMenu.getHeight(), imageMenu.getHeight(), Image.SCALE_FAST);
            jl.setIcon(new ImageIcon(image));
            imageMenu.add(jl);
        }
    }
    
    public static Window getInstance() {
        return windowVar;
    }
    
    public static JPanel getComponentPanel(String type) {
        switch(type) {
            case "choice": return actionsMenu;
            case "image": return imageMenu;
            case "input": return inMenu;
            default: return null;
        }
    }
    
    public static Component[] getComponentArray(String type) {
        return getComponentPanel(type).getComponents();
    }
    
    public static String getTextFromField(int id) {
        return ((JTextField)getComponentArray("input")[id]).getText();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i = 0; i < actionsMenu.getComponents().length; i++) {
            actionsMenu.getComponents()[i].setEnabled(false);
        }
        Stage.getStage().choiceDone(((JButton)e.getSource()).getText());
        renderDisplay();
    }
    
    static class ImagePanel extends JPanel {
        @Override
        public void repaint() {
            super.revalidate();
            super.repaint();
        };
    };
}
