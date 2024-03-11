package POSTTEST1DEPIN;
import java.util.ArrayList;
import java.util.Scanner;

class Barang {
    String nama;
    int stok;
    double harga;

    public Barang(String nama, int stok, double harga) {
        this.nama = nama;
        this.stok = stok;
        this.harga = harga;
    }
}

public class InventoryProgram {
    public static void main(String[] args) {
        ArrayList<Barang> inventory = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        int choice;

        do {
            System.out.println("Menu:");
            System.out.println("1. Tambah Barang");
            System.out.println("2. Lihat Barang");
            System.out.println("3. Update Barang");
            System.out.println("4. Hapus Barang");
            System.out.println("5. Exit");

            System.out.print("Pilih menu (1-5): ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    tambahBarang(inventory);
                    break;
                case 2:
                    lihatBarang(inventory);
                    break;
                case 3:
                    updateBarang(inventory);
                    break;
                case 4:
                    hapusBarang(inventory);
                    break;
                case 5:
                    System.out.println("Program selesai.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (choice != 5);
    }

    private static void tambahBarang(ArrayList<Barang> inventory) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan nama barang: ");
        String nama = scanner.nextLine();

        System.out.print("Masukkan stok barang: ");
        int stok = scanner.nextInt();

        System.out.print("Masukkan harga barang: ");
        double harga = scanner.nextDouble();

        Barang barang = new Barang(nama, stok, harga);
        inventory.add(barang);

        System.out.println("Barang berhasil ditambahkan.");
    }

    private static void lihatBarang(ArrayList<Barang> inventory) {
        if (inventory.isEmpty()) {
            System.out.println("Inventaris kosong.");
        } else {
            System.out.println("Daftar Barang:");
            for (Barang barang : inventory) {
                System.out.println("Nama: " + barang.nama);
                System.out.println("Stok: " + barang.stok);
                System.out.println("Harga:"  + barang.harga);
            }
        }
    }

    private static void updateBarang(ArrayList<Barang> inventory) {
        Scanner scanner = new Scanner(System.in);

        lihatBarang(inventory);

        if (!inventory.isEmpty()) {
            System.out.print("Masukkan indeks barang yang akan diupdate: ");
            int index = scanner.nextInt();

            if (index >= 0 && index < inventory.size()) {
                System.out.print("Masukkan stok baru: ");
                int newStok = scanner.nextInt();

                inventory.get(index).stok = newStok;

                System.out.println("Stok barang berhasil diupdate.");
            } else {
                System.out.println("Indeks barang tidak valid.");
            }
        }
    }

    private static void hapusBarang(ArrayList<Barang> inventory) {
        Scanner scanner = new Scanner(System.in);

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
