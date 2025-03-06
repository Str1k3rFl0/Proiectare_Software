class Form
{
    private String color;

    public Form()
    {
        color = "white";
    }

    public Form(String color)
    {
        this.color = color;
    }

    public float getArea() { return 0; }
    public String toString() { return "This form has the color" + color; }
}

class Square extends Form
{
    private float side;

    public Square()
    {
        side = 10;
    }

    public Square(String color, float side)
    {
        super(color);
        this.side = side;
    }

    @Override
    public float getArea() { return this.side * this.side; }

    @Override
    public String toString() { return "This form have " + side; }
}

class Triangle extends Form
{
    private float height;
    private float base;

    public Triangle()
    {
        height = 0;
        base = 0;
    }

    public Triangle(String color, float height, float base)
    {
        super(color);
        this.height = height;
        this.base = base;
    }

    @Override
    public float getArea() { return this.height + this.base / 2; }

    @Override
    public String toString() { return "This form have " + height + " and " + base; }

    public boolean equals(Triangle tr)
    {
        return (this.height == tr.height) && (this.base == tr.base);
    }
}

class Circle extends Form
{
    public float radius;

    public Circle()
    {
        radius = 0;
    }

    public Circle(String color, float radius)
    {
        super(color);
        this.radius = radius;
    }

    @Override
    public float getArea() { return (float) Math.PI * radius * radius; }

    @Override
    public String toString() { return "This form have " + radius; }
}

public class Main
{
    public static void main(String[] args)
    {
        Triangle tri = new Triangle("red", 1.1F, 2.0F);
        Circle c = new Circle("yellow", 1.5F);
        Square sq = new Square("blue", 1.2F);

        System.out.println("Area = " + tri.getArea() + " details: " + tri);
        System.out.println("Area = " + c.getArea() + " details: " + c);
        System.out.println("Area = " + sq.getArea() + " details: " + sq);

        Triangle tri2 = new Triangle("red", 1.1F, 2.0F);
        System.out.println("Triangle2 equals to Triangle1: " + tri.equals(tri2));

        Triangle tri3 = new Triangle("brown", 1.1F, 2.0F);
        System.out.println("Triangle3 equals to Triangle1: " + tri.equals(tri3));
    }
}
