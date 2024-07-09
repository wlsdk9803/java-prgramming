package ex.buyphoneEx;

public class Main {
    public static void main(String[] args) {
        Phone iphone = new Iphone("애플폰");
        Phone galaxy = new Galaxy("삼송폰");

        Person jobs = new Person("잡스");
        Person jaeyong = new Person("재용");

        jobs.buy(iphone);
        jobs.turnOn(iphone);
        System.out.println();
        jaeyong.buy(galaxy);
        jaeyong.turnOn(galaxy);
    }
}
