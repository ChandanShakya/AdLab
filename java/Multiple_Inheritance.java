interface Eat {
    void eat();
}
interface Play {
    void play();
}
class Animal implements Eat,Play {
    public void eat() {
        System.out.println("The animal is eating");
    }
    public void play() {
        System.out.println("The animal is playing");
    }
}
public class Main {
    public static void main(String args[]) {
        Animal a = new Animal();
        a.eat();
        a.play();
    }
}
