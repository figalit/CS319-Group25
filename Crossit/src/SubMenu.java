import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;


public class SubMenu extends Menu implements ActionListener {

    protected JButton backButton = new JButton();
    protected BufferedImage back;   
    
    protected GameEngine gameEngine;
    
    protected SubMenu(GameEngine gameEngine ){
        
        try { back = ImageIO.read(getClass().getResourceAsStream("/back.png")); } 
        catch(IOException e) {    e.printStackTrace(); }
        
        this.gameEngine = gameEngine;
        
        repaint();
        
        backButton.setBounds(115, 730, 160, 60);
        backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        backButton.setBorderPainted(false);
        backButton.setContentAreaFilled(false);
        backButton.setToolTipText("Back to Main Menu");
        
        backButton.addActionListener(this);
        
        add(backButton);
        
    }
    
    public void paint(Graphics g){
        //Background
        super.paint(g);
        g.drawImage(back, 25, 675, 350, 200, null);
    }
    
    public void actionPerformed(ActionEvent e) {
            
            if (e.getSource() == backButton) {
                Frame.switchPanel(new MainMenu( gameEngine));
            }
    }
    
    public void superRepaint() {
    	super.repaint();
    }
    
}