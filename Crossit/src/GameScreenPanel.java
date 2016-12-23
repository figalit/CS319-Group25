import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.image.ImageConsumer;
import java.awt.image.TileObserver;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import java.awt.Graphics;

public class GameScreenPanel extends JPanel{
   
    private ArrayList<BufferedImage> images;
    private BufferedImage road;   
    GameObject[][] gameMatrix;

    protected GameScreenPanel(GameGrid gameGrid) {
       
        gameMatrix = gameGrid.getGameMatrix();
       
        try {
            road = ImageIO.read(getClass().getResource("/road.png"));
            //road = ImageIO.read(getClass().getResourceAsStream("/road.png"));
            images = new ArrayList<BufferedImage>();
            images.add(road);
           
            for(BufferedImage image : images)
            {
                //image.;
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
       
        //repaint();
    }
   
    public void updateGameScreen(){
       
       
    }
   
    public void paintComponent(Graphics g){
       
        for(int i = 0; i < gameMatrix.length; i++)
        {   
            for(int j = 0; j < gameMatrix[i].length; j++)
            {
                if(gameMatrix[i][j] != null)
                	g.drawImage(gameMatrix[i][j].getImage(), i * 100, j * 90, 100, 90, null);
            }
        }           
    }

}
