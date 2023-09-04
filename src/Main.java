import javax.swing.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        init();
    }

    private static void init() {
        Scanner scanner = new Scanner(System.in);
        JOptionPane.showMessageDialog(null, "Triangulo de Sierpinski", "Triangulo de Sierpinski", JOptionPane.INFORMATION_MESSAGE);
        int level = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nivel del triangulo"));
        SierpinskiTriangle sierpinskiTriangle = new SierpinskiTriangle(level);
    }


}