import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel {
    MyMouseListner listner;

    MyPanel(Color color){
        listner =new MyMouseListner();
        this.addMouseListener(listner);
        this.addMouseMotionListener(listner);
        listner.color = color;
    }
    public void chengeColor(Color color){
        listner.color = color;

    }
    public void chengeFillColor(Color color){
        listner.fillColor = color;

    }

    @Override
    public void paintComponent(Graphics g) {
        for (int i =0 ; i<listner.objectOfPaints.size(); i++) {
            listner.objectOfPaints.get(i).draw(g);
        }
    }
}