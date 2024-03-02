package Shapes;


public interface Mixin {
    static Circle getInstance(int radius, int x, int y, boolean filled) {
        return Circle.getInstanceOf(radius, x, y, filled);
    }
}
