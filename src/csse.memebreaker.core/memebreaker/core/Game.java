package memebreaker.core;

/**
 * The Runnable Game Class </p>
 * 
 * This class is the working logic for the MemeBreaker Game.  It is expected to run
 *   in a background thread for responsiveness and concurrency.
 */
public class Game implements Runnable {
    private Boolean quit = false;

    public synchronized void stop() {
        this.quit = true;
    }
    public synchronized void pause() {
        
    }

    public void run() {
        while (quit == false) {
            System.out.println("Hello Module!");
        }
    }
}

// Copyright (C) 2019 CSSE Club. Licensed under the Educational Community License, Version 2.0.
// See LICENSE.