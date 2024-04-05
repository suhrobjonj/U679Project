public class X extends Space {
    public X() {
        super("X");
    }

    public void print() {
        System.out.print(Color.BLUE + "X: " + Color.RESET);
    }

    //printing X in blue
    @Override
    public void print(String color) {
        System.out.print(Color.BLUE + " X " + Color.RESET);
    }
}
