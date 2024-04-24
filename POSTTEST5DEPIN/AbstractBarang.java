package POSTTEST5DEPIN;


public abstract class AbstractBarang {
    protected final String nama;
    protected int stok; 
    protected final double harga;

    public AbstractBarang(final String nama, final int stok, final double harga) {
        this.nama = nama;
        this.stok = stok;
        this.harga = harga;
    }

    public String getNama() {
        return nama;
    }

    public int getStok() {
        return stok;
    }

    public double getHarga() {
        return harga;
    }

    public abstract void doSomething();

    public void setStok(int stok) { 
        this.stok = stok;
    }
}
