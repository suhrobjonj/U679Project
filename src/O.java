public class O extends Space {
    public O() {
        super("O");
    }

    public void print() {
        System.out.print(Color.RED + "O: " + Color.RESET);
    }

    @Override
    public void print(String color) {
        System.out.print(Color.RED + " O " + Color.RESET);
    }
}
