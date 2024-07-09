package ex.buyphoneEx;

public class Iphone extends Phone{
    public Iphone(String brand) {
        super(brand);
    }
    @Override
    public void turnOn() {
        System.out.print("@@@ ");
        super.turnOn();
        System.out.println(" @@@");
    }
}
