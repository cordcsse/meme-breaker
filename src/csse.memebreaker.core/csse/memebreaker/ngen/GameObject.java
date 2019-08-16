package csse.memebreaker.ngen;

/**
 * GameObject
 */
abstract class GameObject {
    private class Dimensions {
        protected int width;
        protected int height;
        Dimensions(int width, int height) {
            this.width = width; this.height = height;
        }
        public int[] get() {
            return(new int[]{ this.width, this.height });
        }
    }
    private class Position {
        protected int x;
        protected int y;
        Position(int x, int y) {
            this.x = x; this.y = y;
        }
        public int[] get() {
            return(new int[]{ this.x, this.y });
        }
    }

    protected Dimensions dimensions;
    protected Position position;
    GameObject(int x, int y, int width, int height) {
        this.position = new Position(x, y);
        this.dimensions = new Dimensions(width, height);
    }

    public int[] getPostion() { return(this.position.get()); }
    public int[] getDimension() { return(this.dimensions.get()); }

    abstract void update();
}

// Copyright (C) 2019 CSSE Club. Licensed under the Educational Community License, Version 2.0.
// See LICENSE.