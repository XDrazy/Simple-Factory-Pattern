// Shape 接口
interface Shape {
    void draw();
    void erase();
}

// Circle 类
class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Circle");
    }

    @Override
    public void erase() {
        System.out.println("Erasing a Circle");
    }
}

// Rectangle 类
class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Rectangle");
    }

    @Override
    public void erase() {
        System.out.println("Erasing a Rectangle");
    }
}

// Triangle 类
class Triangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Triangle");
    }

    @Override
    public void erase() {
        System.out.println("Erasing a Triangle");
    }
}

// 自定义异常类
class UnsupportedShapeException extends Exception {
    public UnsupportedShapeException(String message) {
        super(message);
    }
}

// ShapeFactory 简单工厂类
class ShapeFactory {
    public Shape createShape(String shapeType) throws UnsupportedShapeException {
        if (shapeType == null) {
            throw new UnsupportedShapeException("Shape type cannot be null");
        }
        switch (shapeType.toLowerCase()) {
            case "circle":
                return new Circle();
            case "rectangle":
                return new Rectangle();
            case "triangle":
                return new Triangle();
            default:
                throw new UnsupportedShapeException("Unsupported shape type: " + shapeType);
        }
    }
}

// 测试类
public class ShapeTest {
    public static void main(String[] args) {
        ShapeFactory factory = new ShapeFactory();

        try {
            // 测试创建圆形
            Shape circle = factory.createShape("circle");
            circle.draw();
            circle.erase();

            // 测试创建矩形
            Shape rectangle = factory.createShape("rectangle");
            rectangle.draw();
            rectangle.erase();

            // 测试创建三角形
            Shape triangle = factory.createShape("triangle");
            triangle.draw();
            triangle.erase();

            // 测试不支持的形状
            Shape unknown = factory.createShape("pentagon");
            unknown.draw(); // 不会执行到这里
        } catch (UnsupportedShapeException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}