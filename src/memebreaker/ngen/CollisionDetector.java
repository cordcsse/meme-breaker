package memebreaker.ngen;
/**
 * CollisionDetector
 */
public class CollisionDetector {
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