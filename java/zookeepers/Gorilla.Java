public class Gorilla extends Mammal{
    public Gorilla(int energyLevel){
        super(energyLevel);
    }
    public void throwSomething(){
        System.out.println("The gorilla is throwing things.");
        energyLevel -=5;
    }
    public void eatBananas(){
        System.out.println("The gorilla is now satisfied.");
        energyLevel +=10;
    }
    public void climb(){
        System.out.println("The gorilla climbed a tree. Time for some rest.");
        energyLevel -=10;
    }
}