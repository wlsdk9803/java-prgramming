package ex.buyphoneEx;

public class Phone {
    private String brand;

    public Phone(String brand) {
        this.brand = brand;
    }

    public void turnOn(){
        System.out.print("폰 켜지는 중");
    }

    public String getBrand() {
        return brand;
    }
}
