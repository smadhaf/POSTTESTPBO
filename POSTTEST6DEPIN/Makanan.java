package POSTTEST6DEPIN;

public final class Makanan extends AbstractBarang implements Printable {
    public Makanan(final String nama, final int stok, final double harga) {
        super(nama, stok, harga);
    }

    @Override
    public void doSomething() {
        System.out.println("ngapain disini, mau makan?");
    }

    @Override
    public void printDetails() {
        super.printDetails();
    }

    @Override
    public void printMessage(String message) {
        super.printMessage(message);
    }
}