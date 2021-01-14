public class Main {

    public static void main(String[] args) {
        LinkedList numbers = new LinkedList();
        numbers.addLast(10);
        numbers.addLast(15);
        numbers.addLast(20);
        numbers.addLast(30);
        numbers.remove(3);
        System.out.println(numbers);
    }
}
