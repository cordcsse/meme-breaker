package memebreaker.main;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import memebreaker.ui.MainWindow;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello Module!");

        SwingUtilities.invokeLater(new Runnable(){
            public void run() { new MainWindow(); }
        });
    }
}

// Copyright (C) 2019 CSSE Club. Licensed under the Educational Community License, Version 2.0.
// See LICENSE.