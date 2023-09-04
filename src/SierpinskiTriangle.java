import javax.swing.*;
import java.awt.*;

public class SierpinskiTriangle extends JFrame {

    private JPanel jPanel;
    private double xp1=750;
    private double yp1=750;
    private double xp2=10;
    private double yp2=750;
    private double sin60=Math.sin(3.14/3.);
    private int nivel_de_recursividad;

    public SierpinskiTriangle(int nivel) throws HeadlessException {
        super("Triangulo de Sierpinski");

        this.nivel_de_recursividad = nivel;

        jPanel = new JPanel();

        setContentPane(jPanel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(800, 800));
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paintComponents(g);
        paintRecursivo(g,nivel_de_recursividad,xp1,yp1,xp2,yp2);
    }

    private void paintRecursivo(Graphics g, int i, double xp12, double yp12, double xp22, double yp22 ) {

        double dx=(xp22-xp12)/2.;
        double dy=(yp22-yp12)/2.;
        double xp32=xp12+dx-2*dy*sin60;
        double yp32=yp12+dy+2*dx*sin60;

        double dx1=(xp22+xp12)/2.;
        double dy1=(yp22+yp12)/2.;
        double dx2=(xp32+xp22)/2.;
        double dy2=(yp32+yp22)/2.;
        double dx3=(xp12+xp32)/2.;
        double dy3=(yp12+yp32)/2.;

        if(i<=0){
            g.drawLine((int)xp12,(int)yp12,(int)xp22,(int)yp22);
            g.drawLine((int)xp22,(int)yp22,(int)xp32,(int)yp32);
            g.drawLine((int)xp32,(int)yp32,(int)xp12,(int)yp12);
        }
        else{
            paintRecursivo(g,i-1,xp12,yp12,dx1,dy1);
            paintRecursivo(g,i-1,dx1,dy1,xp22,yp22);
            paintRecursivo(g,i-1,dx3,dy3,dx2,dy2);
        }

    }
}
