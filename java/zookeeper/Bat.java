public class Bat extends Mammal{
    public Bat(){
        super(300);
    }
    public void fly(){
        System.out.println("I'm a bat");
        energyLevel-=50;
    }
    public void eatHumans(){
        System.out.println("eating human");
        energyLevel+=25;
    }
    public void terrorizeTown(){
        System.out.println("Terrorizing the town");
        energyLevel-=100;
    }
}
