import java.awt.*;

public class Dot extends ObjectOfPaint {
    Color color ;
    private int x;
    private int y;

    Dot(String string){
        String retval[] = string.split(" ", 0) ;
        x = Integer.parseInt(retval[0]);
        y = Integer.parseInt(retval[1]);

    }
    Dot(int x, int y, Color color){
        this.color= color;
        this.x=x;
        this.y=y;
    }

    @Override
    public String toString() {
        return getX() + " "+getY()+" " +color.toString();
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }
    @Override
    public void draw(Graphics graphics){
        graphics.setColor(color);
        graphics.fillOval(x,y,3,3);
    }
}
