package csse.memebreaker.ngen;

import java.lang.reflect.Array;
import java.util.ArrayList;
/**
 * CollisionDetector
 */
public class CollisionDetector {

    ArrayList<GameObject> env;

    Boolean detectCollision(GameObject object1, GameObject object2) {
        return(object1.collision(object2));
    }
    Boolean rectCollision(Rectangle rect, Shape shape) {
        if (rect.x < shape.x + shape.width &&
            rect.x + rect.width > shape.x &&
            rect.y < shape.y + shape.height &&
            rect.y + rect.height > shape.y) {
                return(true);
            }
    }
}

// Copyright (C) 2019 CSSE Club. Licensed under the Educational Community License, Version 2.0.
// See LICENSE.