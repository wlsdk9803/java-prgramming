package ex.buyphoneEx;

public class Person {
    String name;

    public Person(String name) {
        this.name = name;
    }

    public void buy(Phone phone){
        System.out.println(name + "님이 " + phone.getBrand() + "을 구매했습니다.");
    }
    public void turnOn(Phone phone){
        System.out.println(name + "님이 " + phone.getBrand() + "을 켰습니다.");
        phone.turnOn();
    }
}
