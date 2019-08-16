package csse.memebreaker.gui;

import java.awt.Window;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JViewport;
import javax.swing.JWindow;

/**
 * StartMenu
 */
public class StartMenu extends JWindow {
    JTextArea textArea;
    JButton button;

    public StartMenu() {

        this.setTitle("MemeBreaker");
        this.setLayout(new BorderLayout());

        this.textArea = new JTextArea("Hello Frame!");

        this.add(this.textArea, BorderLayout.CENTER);

        this.setSize(600, 500);
        this.setVisible(true);
    }
    
}

// Copyright (C) 2019 CSSE Club. Licensed under the Educational Community License, Version 2.0.
// See LICENSE.