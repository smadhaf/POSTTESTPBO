package POSTTEST5DEPIN;

public final class Makanan extends AbstractBarang {
    public Makanan(final String nama, final int stok, final double harga) {
        super(nama, stok, harga);
    }

    @Override
    public void doSomething() {
        System.out.println("ngapain disini, mau makan?");
    }
}
