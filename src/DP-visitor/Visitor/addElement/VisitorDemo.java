package Visitor.addElement;

interface ICarElementVisitor {
    void visit(Wheel wheel);
    void visit(Engine engine);
    void visit(Body body);
    void visit(Car car); 
    void visit(Trunk trunk);
}

interface ICarElement {
    abstract public void accept(ICarElementVisitor visitor);   
}

public class VisitorDemo {
    public static void main(String[] args) {
        ICarElement car = new Car();
        car.accept(new CarElementPrintVisitor());
        car.accept(new CarElementDoVisitor());
        car.accept(new CarElementDestroyVisitor());
    }
}

class Trunk implements ICarElement {
    public void accept(ICarElementVisitor visitor) {
        visitor.visit(this);     
    }
}
class Wheel implements ICarElement {
    private String name;
    public Wheel(String name) { this.name = name; } 
    public String getName() { return this.name; }
    public void accept(ICarElementVisitor visitor) {
        visitor.visit(this);     
    }
}
class Engine implements ICarElement {
    public void accept(ICarElementVisitor visitor) {
        visitor.visit(this);     
    }
}
class Body implements ICarElement {
    public void accept(ICarElementVisitor visitor) {
        visitor.visit(this);     
    }
}

class Car implements ICarElement {
    ICarElement[] elements;
    public Car() {
        this.elements = new ICarElement[] { new Trunk(), new Wheel("front left"), new Wheel("front right"), 
        		     new Wheel("back left") , new Wheel("back right"), new Body(), new Engine() }; 
    }
    public void accept(ICarElementVisitor visitor) {    
        for(ICarElement elem : elements) 
            elem.accept(visitor);
        visitor.visit(this);    
    }
}

class CarElementPrintVisitor implements ICarElementVisitor {	
    public void visit(Wheel wheel) {      
      System.out.println("Visiting " + wheel.getName() + " wheel");     
    }
    public void visit(Engine engine) {
        System.out.println("Visiting engine");     
    }
    public void visit(Body body) {
        System.out.println("Visiting body");     
    }
    public void visit(Car car) {      
        System.out.println("Visiting car");     
    }
    public void visit(Trunk trunk) {      
        System.out.println("Visiting trunk");     
    }
}

class CarElementDoVisitor implements ICarElementVisitor {	
    public void visit(Wheel wheel) {
        System.out.println("Kicking my " + wheel.getName() + " wheel");  }
    public void visit(Engine engine) {
        System.out.println("Starting my engine");
    }
    public void visit(Body body) {
        System.out.println("Moving my body");
    }
    public void visit(Car car) {
        System.out.println("Starting my car");
    }
    public void visit(Trunk trunk) {      
        System.out.println("Closing trunk");     
    }
}

class CarElementDestroyVisitor implements ICarElementVisitor {	
    public void visit(Wheel wheel) {
        System.out.println("Destroying " + wheel.getName() + " wheel");  }
    public void visit(Engine engine) {
        System.out.println("Destroying engine");
    }
    public void visit(Body body) {
        System.out.println("Destroying body");
    }
    public void visit(Car car) {
        System.out.println("Destroying car");
    }
    public void visit(Trunk trunk) {      
        System.out.println("Destroying trunk");     
    }
}
