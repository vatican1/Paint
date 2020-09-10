import java.awt.*;

class MyCircle extends ObjectOfPaint {
    int x,y,radiusx=0,radiusy=0;
    Color color;
    Color fill = null;


    MyCircle(int x,int y,Color color,Color fill){
        this.x=x;
        this.y=y;
        this.color= color;
        radiusx=0;
        radiusy=0;
        this.fill=fill;
    }
    MyCircle(String string){
        String retval[] = string.split(" ", 0) ;
        x = Integer.parseInt(retval[0]);
        y = Integer.parseInt(retval[1]);
        radiusx = Integer.parseInt(retval[2]);
        radiusy = Integer.parseInt(retval[3]);
    }

    @Override
    public String toString() {
        return x+" "+y+" "+radiusx+" "+radiusy+" " +color.toString();
    }
    @Override
    public void draw(Graphics graphics){
        if(fill!=null){
            graphics.setColor(fill);
            if ((radiusx<0)&&(radiusy<0)){
                graphics.fillOval(x+radiusx,y+radiusy,Math.abs(radiusx),Math.abs(radiusy));
            }
            if((radiusx>0)&&(radiusy>0)){
                graphics.fillOval(x,y,Math.abs(radiusx),Math.abs(radiusy));
            }
            if ((radiusx>0)&&(radiusy<0)){
                graphics.fillOval(x,y+radiusy,Math.abs(radiusx),Math.abs(radiusy));
            }
            if((radiusx<0)&&(radiusy>0)){
                graphics.fillOval(x+radiusx,y,Math.abs(radiusx),Math.abs(radiusy));
            }
        } else {
            graphics.setColor(color);
            if ((radiusx < 0) && (radiusy < 0)) {
                graphics.drawOval(x + radiusx, y + radiusy, Math.abs(radiusx), Math.abs(radiusy));
            }
            if ((radiusx > 0) && (radiusy > 0)) {
                graphics.drawOval(x, y, Math.abs(radiusx), Math.abs(radiusy));
            }
            if ((radiusx > 0) && (radiusy < 0)) {
                graphics.drawOval(x, y + radiusy, Math.abs(radiusx), Math.abs(radiusy));
            }
            if ((radiusx < 0) && (radiusy > 0)) {
                graphics.drawOval(x + radiusx, y, Math.abs(radiusx), Math.abs(radiusy));
            }
        }
    }

    public void drawOfProgress(int x,int y){
        radiusx=x-this.x;
        radiusy=y-this.y;
    }
}
