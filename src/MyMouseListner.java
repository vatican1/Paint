import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class MyMouseListner implements MouseMotionListener,MouseListener {
    int x, y;
    ArrayList <ObjectOfPaint> objectOfPaints = new ArrayList<ObjectOfPaint>();

    int drawingMode =0;
    Color color;
    Color fillColor = null;

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (drawingMode == 2) {
            x=e.getX();
            y=e.getY();
            objectOfPaints.add(new MyRectangle(x,y,x,y, color,fillColor));
        }

        if (drawingMode == 1) {
            objectOfPaints.add(new Segment());
            x=e.getX();
            y=e.getY();
        }
        if (drawingMode == 3) {
            objectOfPaints.add(new Dot(e.getX(),e.getY(),color));
        }
        if (drawingMode == 0) {
            objectOfPaints.add(new Dot(e.getX(), e.getY(),color));
        }
        if (drawingMode == 4) {
            objectOfPaints.add(new MyCircle(e.getX(), e.getY(),color,fillColor));
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (drawingMode == 1) {
            objectOfPaints.add(new Segment(x,e.getX(),y, e.getY(),color));
            x = e.getX();
            y = e.getY();
        }
        if (drawingMode == 2) {objectOfPaints.get(objectOfPaints.size()-1).drawOfProgress(e.getX(),e.getY());
        }
        if (drawingMode == 3) {
            objectOfPaints.add(new Dot(e.getX(),e.getY(),color));
        }
        if (drawingMode == 4) {
            objectOfPaints.get( objectOfPaints.size()-1).drawOfProgress(e.getX(), e.getY());
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
