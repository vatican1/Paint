import java.awt.*;

class MyRectangle extends ObjectOfPaint{

    int x1,y1;
    int width, height;
    Color color=Color.black ;
    Color fill = null;

    MyRectangle(int x1,int y1,int x2,int y2,Color color,Color fill){
        this.x1=x1;
        this.y1=y1;
        this.color= color;
        width = -x1+x2 ;
        height = -y1+y2;
        this.fill=fill;
    }
    MyRectangle (String string){
        String retval[] = string.split(" ", 0) ;
        x1 = Integer.parseInt(retval[0]);
        y1 = Integer.parseInt(retval[1]);
        width = Integer.parseInt(retval[2]);
        height = Integer.parseInt(retval[3]);
    }

    @Override
    public String toString() {
        return  x1+" "+y1+" "+width+" "+height+" " +color.toString();
    }


    @Override
    public void draw(Graphics graphics){
        if (fill!=null) {
            graphics.setColor(fill);
            if ((width < 0) && (height < 0)) {
                graphics.fillRect(x1 + width, y1 + height, Math.abs(width), Math.abs(height));
            }
            if ((width > 0) && (height > 0)) {
                graphics.fillRect(x1, y1, Math.abs(width), Math.abs(height));
            }
            if ((width > 0) && (height < 0)) {
                graphics.fillRect(x1, y1 + height, Math.abs(width), Math.abs(height));
            }
            if ((width < 0) && (height > 0)) {
                graphics.fillRect(x1 + width, y1, Math.abs(width), Math.abs(height));
            }
        }else{
        graphics.setColor(color);
        if ((width<0)&&(height<0)){
            graphics.drawRect(x1+width,y1+height,Math.abs(width),Math.abs(height));
        }
        if((width>0)&&(height>0)){
            graphics.drawRect(x1,y1,Math.abs(width),Math.abs(height));
        }
        if ((width>0)&&(height<0)){
            graphics.drawRect(x1,y1+height,Math.abs(width),Math.abs(height));
        }
        if((width<0)&&(height>0)){
            graphics.drawRect(x1+width,y1,Math.abs(width),Math.abs(height));
        }
        }

    }

    @Override
    public void drawOfProgress(int x,int y){
        width = -x1+x ;
        height = -y1+y;
    }
}
