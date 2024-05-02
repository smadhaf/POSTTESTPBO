package POSTTEST6DEPIN;


public abstract class AbstractBarang implements Printable {
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

    @Override
    public void printDetails() {
        System.out.println("Nama: " + nama);
        System.out.println("Stok: " + stok);
        System.out.println("Harga: " + harga);
    }

    @Override
    public void printMessage(String message) {
        System.out.println(message);
    }
}