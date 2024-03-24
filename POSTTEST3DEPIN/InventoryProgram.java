package POSTTEST3DEPIN;
import java.util.ArrayList;
import java.util.Scanner;

class Barang {
    private String nama;
    private int stok;
    private double harga;

    public Barang(String nama, int stok, double harga) {
        this.nama = nama;
        this.stok = stok;
        this.harga = harga;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    @Override
    public String toString() {
        return "Nama: " + nama + ", Stok: " + stok + ", Harga: " + harga;
    }
}

class Makanan extends Barang {
    private boolean halal;

    public Makanan(String nama, int stok, double harga, boolean halal) {
        super(nama, stok, harga);
        this.halal = halal;
    }

    public boolean isHalal() {
        return halal;
    }

    public void setHalal(boolean halal) {
        this.halal = halal;
    }

    @Override
    public String toString() {
        return "Nama: " + super.getNama() + ", Stok: " + super.getStok() + ", Harga: " + super.getHarga() + ", Halal: " + halal;
    }
}

class Amunisi extends Barang {
    private boolean senjataApi;

    public Amunisi(String nama, int stok, double harga, boolean senjataApi) {
        super(nama, stok, harga);
        this.senjataApi = senjataApi;
    }

    public boolean isSenjataApi() {
        return senjataApi;
    }

    public void setSenjataApi(boolean senjataApi) {
        this.senjataApi = senjataApi;
    }

    @Override
    public String toString() {
        return "Nama: " + super.getNama() + ", Stok: " + super.getStok() + ", Harga: " + super.getHarga() + ", Senjata Api: " + senjataApi;
    }
}
public class InventoryProgram {
    public static void main(String[] args) {
        ArrayList<Barang> inventory = new ArrayList<Barang>();

        int choice;

        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Tambah Barang");
            System.out.println("2. Lihat Barang");
            System.out.println("3. Update Barang");
            System.out.println("4. Hapus Barang");
            System.out.println("5. Exit");

            System.out.print("\nPilih menu (1-5): ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    tambahBarang(inventory, scanner);
                    break;
                case 2:
                    lihatBarang(inventory);
                    break;
                case 3:
                    updateBarang(inventory, scanner);
                    break;
                case 4:
                    hapusBarang(inventory, scanner);
                    break;
                case 5:
                    System.out.println("Program selesai.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (choice != 5);
    }

    private static void tambahBarang(ArrayList<Barang> inventory, Scanner scanner) {
        System.out.print("Masukkan nama barang (tanpa spasi): ");
        String nama = scanner.next();
    
        System.out.print("Masukkan stok barang: ");
        int stok = scanner.nextInt();
    
        System.out.print("Masukkan harga barang: ");
        double harga = scanner.nextDouble();
    
        System.out.println("Pilih jenis barang:");
        System.out.println("1. Makanan");
        System.out.println("2. Amunisi");
        System.out.print("Pilih menu (1-2): ");
        int jenisBarang = scanner.nextInt();
    
        Barang barang = null;
    
        if (jenisBarang == 1) {
            System.out.print("Apakah ini makanan (Y/N)? ");
            scanner.nextLine();
            boolean isMakanan = scanner.nextLine().equalsIgnoreCase("Y");
            barang = new Makanan(nama, stok, harga, isMakanan);
        } else if (jenisBarang == 2) {
            System.out.print("Apakah ini amunisi (Y/N)? ");
            scanner.nextLine(); 
            boolean isAmunisi = scanner.nextLine().equalsIgnoreCase("Y");
            barang = new Amunisi(nama, stok, harga, isAmunisi);
        } else {
            System.out.println("Pilihan tidak valid.");
            return;
        }
    
        inventory.add(barang);
        System.out.println("Barang berhasil ditambahkan.");
    }

    private static void lihatBarang(ArrayList<Barang> inventory) {
        if (inventory.isEmpty()) {
            System.out.println("Inventaris kosong.");
        } else {
            System.out.println("============================== Daftar Barang ==============================");
            System.out.printf("%-10s %-20s %-15s %-15s %s%n", "No", "Nama", "Stok", "Harga", "Jenis");
            System.out.println("---------------------------------------------------------------------------");
    
            for (int i = 0; i < inventory.size(); i++) {
                Barang barang = inventory.get(i);
                String jenis = "";
                if (barang instanceof Makanan) {
                    jenis = "Makanan";
                } else if (barang instanceof Amunisi) {
                    jenis = "Amunisi";
                }
                System.out.printf("%-10d %-20s %-15d %-15.2f %-10s%n", i+1, barang.getNama(), barang.getStok(), barang.getHarga(), jenis);
            }
            System.out.println("===========================================================================");
        }
    }

    private static void updateBarang(ArrayList<Barang> inventory, Scanner scanner){
        lihatBarang(inventory);

        if (!inventory.isEmpty()) {
            System.out.print("Masukkan indeks barang yang akan diupdate: ");
            int index = scanner.nextInt();

            if (index >= 0 && index < inventory.size()) {
                System.out.print("Masukkan stok baru: ");
                int newStok = scanner.nextInt();

                inventory.get(index).setStok(newStok);

                System.out.println("Stok barang berhasil diupdate.");
            } else {
                System.out.println("Indeks barang tidak valid.");
            }
        }
    }

    private static void hapusBarang(ArrayList<Barang> inventory, Scanner scanner) {
        lihatBarang(inventory);

        if (!inventory.isEmpty()) {
            System.out.print("Masukkan indeks barang yang akan dihapus: ");
            int index = scanner.nextInt();

            if (index >= 0 && index < inventory.size()) {
                inventory.remove(index);

                System.out.println("Barang berhasil dihapus.");
            } else {
                System.out.println("Indeks barang tidak valid.");
            }
        }
    }
}