package POSTTEST5DEPIN;


import java.util.ArrayList;
import java.util.Scanner;

public final class InventoryProgram {
    public static void main(final String[] args) {
        final ArrayList<AbstractBarang> inventory = new ArrayList<>();

        int choice;

        final Scanner scanner = new Scanner(System.in);

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

    private static void tambahBarang(final ArrayList<AbstractBarang> inventory, final Scanner scanner) {
        System.out.print("Masukkan nama barang (tanpa spasi): ");
        final String nama = scanner.next();

        System.out.print("Masukkan stok barang: ");
        final int stok = scanner.nextInt();

        System.out.print("Masukkan harga barang: ");
        final double harga = scanner.nextDouble();

        System.out.println("Pilih jenis barang:");
        System.out.println("1. Makanan");
        System.out.println("2. Amunisi");
        System.out.print("Pilih menu (1-2): ");
        final int jenisBarang = scanner.nextInt();

        if (jenisBarang == 1) {
            inventory.add(new Makanan(nama, stok, harga));
        } else if (jenisBarang == 2) {
            inventory.add(new Amunisi(nama, stok, harga));
        } else {
            System.out.println("Pilihan tidak valid.");
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
                }
                System.out.printf("%-10d %-20s %-15d %-15.2f %-10s%n", i+1, barang.getNama(), barang.getStok(), barang.getHarga(), jenis);
            }
            System.out.println("===========================================================================");
        }
    }

    private static void updateBarang(final ArrayList<AbstractBarang> inventory, final Scanner scanner) {
        lihatBarang(inventory);

        if (!inventory.isEmpty()) {
            System.out.print("Masukkan indeks barang yang akan diupdate: ");
            final int index = scanner.nextInt();

            if (index >= 0 && index < inventory.size()) {
                System.out.print("Masukkan stok baru: ");
                final int newStok = scanner.nextInt();

                // Memanggil method setStok() untuk mengubah nilai stok
                inventory.get(index).setStok(newStok);

                System.out.println("Stok barang berhasil diupdate.");
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
