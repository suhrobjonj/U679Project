public class X extends Space {
    public X() {
        super("X");
    }

    public void print() {
        System.out.print(Color.BLUE + "X: " + Color.RESET);
    }

    @Override
    public void print(String color) {
        System.out.print(Color.BLUE + " X " + Color.RESET);
    }
}
