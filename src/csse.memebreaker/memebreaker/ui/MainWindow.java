package memebreaker.ui;
/**
 * MainWindow
 */
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class MainWindow extends JFrame {

    JTextArea textArea;
    public MainWindow() {
        this.setTitle("MemeBreaker");
        this.setLayout(new BorderLayout());

        this.textArea = new JTextArea("Hello Frame!");

        this.add(this.textArea, BorderLayout.CENTER);

        this.setSize(600, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
}