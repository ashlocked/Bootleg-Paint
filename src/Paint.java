import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class Paint extends JPanel implements MouseListener, MouseMotionListener {
    private int width;
    private int height;
    private int[][] clickIt;
    private int currentColor = 1;
    private ArrayList<Rectangle> arrayRectangles = new ArrayList<Rectangle>();

    public Paint(int width, int height){
        this.width=width;
        this.height=height;
        clickIt = new int[width][height];
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }
    // i = index
    // j = jndex

    private static Rectangle rectangle(int i,int j){
        int x = i*10;
        int y = j*10;
        return new Rectangle(x,y,10,10);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Color pen = new Color(0, 0, 0);
        Color[] colorsPlural = new Color[4];
        Color white = new Color(255, 255, 255);
        colorsPlural[0] = white;
        Color alsoWhite = new Color(255, 255, 255);
        colorsPlural[1] = alsoWhite;
        Color evenWhiter = new Color(255, 255, 255);
        colorsPlural[2] = evenWhiter;
        Color iCantBelieveItsWhite = new Color(255, 255, 255);
        colorsPlural[3] = iCantBelieveItsWhite;

        int counter = 0;
        for (int i=0;i<width;i++){
            for(int j=0;j<height;j++){
                int colorIndex = counter % 4;
                if(clickIt[i][j]>0){
                    g.setColor(pen);
                    switch (clickIt[i][j]){
                        case 1:
                            g.setColor(new Color(255, 17, 14));
                            break;
                        case 2:
                            g.setColor(new Color(18, 61, 255));
                            break;
                        case 3:
                            g.setColor(new Color(114, 255, 79));
                            break;
                        case 4:
                            g.setColor(new Color(76, 253, 255));
                            break;
                        case 5:
                            g.setColor(new Color(255, 249, 38));
                            break;
                        case 6:
                            g.setColor(new Color(255, 57, 176));
                            break;
                        case 7:
                            g.setColor(new Color(54, 54, 56));
                            break;
                        case 8:
                            g.setColor(new Color(177, 177, 179));
                            break;
                    }
                } else {
                    g.setColor(colorsPlural[colorIndex]);}
                g.fillRect(i*10,j*10,10,10);
                counter++;
            }
        }

        Color theBest = new Color(255, 17, 14);
        g.setColor(theBest);
        g.fillRect(width*10+45,50,35,35);

        Color blueStopSign = new Color(18, 61, 255);
        g.setColor(blueStopSign);
        g.fillRect(width*10+120,50,35,35);

        Color nasty = new Color(114, 255, 79);
        g.setColor(nasty);
        g.fillRect(width*10+45,105,35,35);

        Color beautiful = new Color(76, 253, 255);
        g.setColor(beautiful);
        g.fillRect(width*10+120,105,35,35);

        Color reflectiveVest = new Color(255, 249, 38);
        g.setColor(reflectiveVest);
        g.fillRect(width*10+45,160,35,35);

        Color alsoNasty = new Color(255, 57, 176);
        g.setColor(alsoNasty);
        g.fillRect(width*10+120,160,35,35);

        Color grey = new Color(177, 177, 179);
        g.setColor(grey);
        g.fillRect(width*10+120,215,35,35);

        Color gray = new Color(54, 54, 56);
        g.setColor(gray);
        g.fillRect(width*10+45,215,35,35);

        Color undo = new Color(255, 255, 255);
        g.setColor(undo);
        g.fillRect(width*10+50,270,100,50);
        Color nuke = new Color(0, 0, 0);
        g.setColor(nuke);
        g.drawString("Tactical Nuke", width*10+65,270);

    }


    @Override
    public void mouseClicked(MouseEvent e) {


        // undo

        if (width*10+50<e.getX() && e.getX()<width*10+150
                && height*10/2+75<e.getY() && e.getY()<height*10/2+125 &&
                arrayRectangles.size()>0){
            Rectangle rekt = arrayRectangles.get(arrayRectangles.size()-1);
            int i = rekt.x/10;
            int j = rekt.y/10;
            clickIt[i][j] = 0;
            revalidate();
            repaint();

            arrayRectangles.remove(arrayRectangles.size()-1);
        }

        // red aka theBest
        if (width*10+45<e.getX() && e.getX()<width*10+80
                && 50<e.getY() && e.getY()<85){
            currentColor = 1;
            revalidate();
            repaint();
        }

        // blue aka blueStopSign
        if (width*10+120<e.getX() && e.getX()<width*10+155
                && 50<e.getY() && e.getY()<85){
            currentColor = 2;
            revalidate();
            repaint();
        }

        // green aka nasty
        if (width*10+45<e.getX() && e.getX()<width*10+80
                && 105<e.getY() && e.getY()<140){
            currentColor = 3;
            revalidate();
            repaint();
        }

        // cyan aka beautiful
        if (width*10+120<e.getX() && e.getX()<width*10+155
                && 105<e.getY() && e.getY()<140){
            currentColor = 4;
            revalidate();
            repaint();
        }

        // yellow aka reflectiveVest
        if (width*10+45<e.getX() && e.getX()<width*10+80
                && 160<e.getY() && e.getY()<195){
            currentColor = 5;
            revalidate();
            repaint();
        }

        // magenta aka alsoNasty
        if (width*10+120<e.getX() && e.getX()<width*10+155
                && 160<e.getY() && e.getY()<195){
            currentColor = 6;
            revalidate();
            repaint();
        }

        // dark grey aka gay
        if (width*10+45<e.getX() && e.getX()<width*10+80
                && 215<e.getY() && e.getY()<250){
            currentColor = 7;
            revalidate();
            repaint();
        }

        // light grey aka grey
        if (width*10+120<e.getX() && e.getX()<width*10+155
                && 215<e.getY() && e.getY()<250){
            currentColor = 8;
            revalidate();
            repaint();
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {
        int i = e.getX()/10;
        int j = e.getY()/10;

        // this runs when we click in the drawing area
        if (i<width && j<height){
            clickIt[i][j] = currentColor;
            arrayRectangles.add(new Rectangle(i*10,j*10,10,10));
            revalidate();
            repaint(); }
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
        mousePressed(e);
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
