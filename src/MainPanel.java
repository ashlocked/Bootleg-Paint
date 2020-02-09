import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class MainPanel {
    public static void main(String[] args){
        Scanner magic = new Scanner(System.in);
        System.out.println("How many rows would you like the grid?");
        int gridRowSize = magic.nextInt();
        System.out.println("How many columns would you like the grid?");
        int gridColSize = magic.nextInt();

        JFrame frame = new JFrame("Bootleg Paint");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        Color backdrop = new Color(0, 0, 0, 227);
        Paint mainPanel = new Paint(gridColSize,gridRowSize);
        mainPanel.setPreferredSize(new Dimension(gridColSize*10+200,gridRowSize*10));
        mainPanel.setBackground(backdrop);
        frame.getContentPane().add(mainPanel);
        frame.pack();

    }
}
