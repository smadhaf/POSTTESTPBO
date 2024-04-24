package POSTTEST5DEPIN;

public final class Amunisi extends AbstractBarang {
    public Amunisi(final String nama, final int stok, final double harga) {
        super(nama, stok, harga);
    }

    @Override
    public void doSomething() {
        System.out.println("Hayoo loh, ngapain disini?");
    }
}
