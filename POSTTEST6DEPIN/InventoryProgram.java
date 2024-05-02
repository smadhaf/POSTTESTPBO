package POSTTEST6DEPIN;


import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public final class InventoryProgram {
    private static final String PROGRAM_NAME = "Program Inventori";
    private static int totalBarang = 0;

    public static void main(final String[] args) {
        final ArrayList<AbstractBarang> inventory = new ArrayList<>();

        int pilihan;
final Scanner scanner = new Scanner(System.in);

        // Menampilkan nama program
        displayProgramName();

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Tambah Barang");
            System.out.println("2. Lihat Barang");
            System.out.println("3. Update Barang");
            System.out.println("4. Hapus Barang");
            System.out.println("5. Keluar");

            System.out.print("\nPilih menu (1-5): ");
            pilihan = scanner.nextInt();

            switch (pilihan) {
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
                    System.out.println("\nTerima kasih telah menggunakan " + PROGRAM_NAME);
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
                    break;
            }
        } while (pilihan != 5);
    }

    // Menambahkan method displayProgramName() untuk menampilkan nama program
    private static void displayProgramName() {
        System.out.println(PROGRAM_NAME);
    }

    private static void tambahBarang(final ArrayList<AbstractBarang> inventory, final Scanner scanner) {
        try {
            System.out.print("Masukkan nama barang (tanpa spasi): ");
            final String nama = scanner.next();

            System.out.print("Masukkan stok barang: ");
            final int stok = scanner.nextInt();

            System.out.print("Masukkan harga barang: ");
            final double harga = scanner.nextDouble();

            System.out.print("Apakah barang ini amunisi (1) atau makanan (2): ");
            final int barangType = scanner.nextInt();

            AbstractBarang barang;

            if (barangType == 1) {
                barang = new Amunisi(nama, stok, harga);
            } else {
                barang = new Makanan(nama, stok, harga);
            }

            inventory.add(barang);

            totalBarang++;
            System.out.println("Total barang: " + totalBarang);
        } catch (InputMismatchException e) {
            System.out.println("Input tidak valid. Silakan coba lagi.");
            scanner.next(); // membersihkan input yang tidak valid
        }
    }

    private static void lihatBarang(final ArrayList<AbstractBarang> inventory) {
        if (inventory.isEmpty()) {
            System.out.println("Inventaris kosong.");
        } else {
            System.out.println("============================== Daftar Barang ==============================");
            System.out.printf("%-10s %-20s %-15s %-15s %s%n", "No", "Nama", "Stok", "Harga", "Jenis");
            System.out.println("---------------------------------------------------------------------------");

            for (int i = 0; i < inventory.size(); i++) {
                final AbstractBarang barang = inventory.get(i);
                String jenis = "";
                if (barang instanceof Makanan) {
                    jenis = "Makanan";
                } else if (barang instanceof Amunisi) {
                    jenis = "Amunisi";
                } else {
                    jenis = "Tidak diketahui";
                }
                System.out.printf("%-10d %-20s %-15d %-15.2f %-10s%n", i+1, barang.getNama(), barang.getStok(), barang.getHarga(), jenis);
            }
            System.out.println("===========================================================================");
        }
    }

    // Menambahkan method updateBarang() dan hapusBarang() dengan error handling
    private static void updateBarang(final ArrayList<AbstractBarang> inventory, final Scanner scanner) {
        lihatBarang(inventory);

        if (!inventory.isEmpty()) {
            System.out.print("Masukkan indeks barang yang akan diperbarui: ");
            final int index = scanner.nextInt();

            if (index >= 0 && index < inventory.size()) {
                System.out.print("Masukkan stok baru: ");
                final int newStok = scanner.nextInt();

                // Memanggilmethod setStok() untuk mengubah nilai stok
                inventory.get(index).setStok(newStok);

                System.out.println("Stok barang berhasil diperbarui.");
            } else {
                System.out.println("Indeks barang tidak valid.");
            }
        }
    }

    private static void hapusBarang(final ArrayList<AbstractBarang> inventory, final Scanner scanner) {
        lihatBarang(inventory);

        if (!inventory.isEmpty()) {
            System.out.print("Masukkan indeks barang yang akan dihapus: ");
            final int index = scanner.nextInt();

            if (index >= 0 && index < inventory.size()) {
                inventory.remove(index);
                System.out.println("Barang berhasil dihapus.");
            } else {
                System.out.println("Indeks barang tidak valid.");
            }
        }
    }
}