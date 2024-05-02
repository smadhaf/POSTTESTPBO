package POSTTEST6DEPIN;

public final class Amunisi extends AbstractBarang implements Printable {
    public Amunisi(final String nama, final int stok, final double harga) {
        super(nama, stok, harga);
    }

    @Override
    public void doSomething() {
        System.out.println("Hayoo loh, ngapain disini?");
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