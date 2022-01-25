public class PhoneTester {
    public static void main(String[] args) {
        Galaxy s21 = new Galaxy("S21", 67, "AT&T", "I'm blue, bada-bee-bad-da..");
        IPhone iPhone11= new IPhone("11", 23, "Verizon", "Bzzz. Bzzz.");
        s21.displayInfo();
        iPhone11.displayInfo();
    }
}
