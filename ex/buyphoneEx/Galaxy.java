package ex.buyphoneEx;

public class Galaxy extends Phone{
    public Galaxy(String brand) {
        super(brand);
    }
    @Override
    public void turnOn() {
        System.out.print("*** ");
        super.turnOn();
        System.out.println(" ***");
    }
}
