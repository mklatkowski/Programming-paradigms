package Shapes;

import Main.Primitive;

public abstract class Shape extends Primitive {

    protected boolean filled;
    public Shape(){
        super();
        filled = false;
    }
    public Shape(boolean filled){
        super();
        this.filled = filled;
    }

    public boolean getFilled(){
        return filled;
    }


}
