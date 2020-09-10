import java.awt.*;

public class Segment extends ObjectOfPaint {
    Color color ;

    int xStart,xEnd,yStart,yEnd;
    Segment(){}
    Segment( int xStart,int xEnd,int yStart,int yEnd, Color color){
        this.xStart=xStart;
        this.xEnd=xEnd;
        this.yStart=yStart;
        this.yEnd=yEnd;
        this.color = color;
    }
    Segment(String string){
        String retval[] = string.split(" ", 0) ;
        xStart = Integer.parseInt(retval[0]);
        xEnd = Integer.parseInt(retval[1]);
        yStart = Integer.parseInt(retval[2]);
        yEnd = Integer.parseInt(retval[3]);
    }


    public void startSegment (int x, int y, Color color){
        xStart=x;
        yStart=y;
        this.color= color;
    }

    @Override
    public String toString() {
        return xStart+" "+xEnd+" "+yStart+" "+yEnd+" " +color.toString();
    }

    public void endSegment(int x, int y){
        xEnd=x;
        yEnd=y;
    }
    public void draw(Graphics graphics){
        graphics.setColor(color);
        graphics.drawLine(xStart,yStart,xEnd,yEnd);
    }
}
