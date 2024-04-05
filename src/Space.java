public class Space {
    private String symbol;

    public Space (String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public void print(String color) {
        System.out.print(color + " " + symbol + " " + Color.RESET);
    }
}
