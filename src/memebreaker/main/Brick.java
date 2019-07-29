package memebreaker.main;
/**
 * Brick
 */

import memebreaker.ngen.GameObject;

public class Brick extends GameObject {
    private int width = 80;
    private int height = 24;

    private int position;
    public Brick(int x, int y, int width, int height) {
        super(x, y, width, height);
    }
}