import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class PetFood {
    private String namaProduk;
    private String jenisHewan; 
    private String rasSpesifik; 
    private double harga;
    private String deskripsi;

    // Constructor untuk mengisi data produk
    public PetFood(String namaProduk, String jenisHewan, String rasSpesifik, double harga, String deskripsi) {
        this.namaProduk = namaProduk;
        this.jenisHewan = jenisHewan;
        this.rasSpesifik = rasSpesifik;
        this.harga = harga;
        this.deskripsi = deskripsi;
    }

    // Getter untuk mengambil data
    public String getNamaProduk() { return namaProduk; }
    public String getJenisHewan() { return jenisHewan; }
    public String getRasSpesifik() { return rasSpesifik; }
    public double getHarga() { return harga; }
    public String getDeskripsi() { return deskripsi; }
}

// Class Utama (Controlling Class)
public class PetFoodMatcher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Menyiapkan daftar produk (Database sederhana menggunakan ArrayList)
        List<PetFood> daftarMakanan = new ArrayList<>();
        daftarMakanan.add(new PetFood("Royal Canin Persian", "Kucing", "Persia", 150000, "Formula khusus bulu panjang dan pencernaan sensitif."));
        daftarMakanan.add(new PetFood("Whiskas Adult Tuna", "Kucing", "Semua", 45000, "Nutrisi harian seimbang untuk segala jenis kucing."));
        daftarMakanan.add(new PetFood("Pro Plan Kitten", "Kucing", "Persia", 95000, "Tinggi protein untuk anak kucing Persia/lokal."));
        daftarMakanan.add(new PetFood("Pedigree Golden Retriever", "Anjing", "Golden", 200000, "Formulasi persendian & otot anjing ras besar."));
        daftarMakanan.add(new PetFood("Bolt Dog Food", "Anjing", "Semua", 35000, "Makanan anjing ekonomis kaya serat dan nutrisi dasar."));

        System.out.println("=== SISTEM KECOCOKAN PET FOOD ===");

        // Input dari pengguna
        System.out.print("Masukkan Jenis Hewan (Kucing/Anjing) : ");
        String jenisHewan = scanner.nextLine().trim();

        System.out.print("Masukkan Ras Hewan (contoh: Persia / Golden / Semua) : ");
        String rasHewan = scanner.nextLine().trim();

        System.out.print("Masukkan Maksimal Budget Anda (Rp) : ");
        double budget = scanner.nextDouble();

        System.out.println("\n--------------------------------------------------");
        System.out.println("HASIL REKOMENDASI PET FOOD YANG COCOK:");
        System.out.println("--------------------------------------------------");

        boolean adaCocok = false;

        // Perulangan untuk mengecek satu-persatu produk dalam list
        for (PetFood makanan : daftarMakanan) {
            boolean jenisCocok = makanan.getJenisHewan().equalsIgnoreCase(jenisHewan);
            boolean rasCocok = makanan.getRasSpesifik().equalsIgnoreCase("Semua") || 
                               makanan.getRasSpesifik().equalsIgnoreCase(rasHewan);
            boolean budgetCocok = makanan.getHarga() <= budget;

            // Jika semua kriteria terpenuhi, tampilkan produk
            if (jenisCocok && rasCocok && budgetCocok) {
                System.out.println("Nama Produk : " + makanan.getNamaProduk());
                System.out.println("Kategori    : " + makanan.getJenisHewan() + " (" + makanan.getRasSpesifik() + ")");
                System.out.println("Harga       : Rp " + makanan.getHarga());
                System.out.println("Deskripsi   : " + makanan.getDeskripsi());
                System.out.println("--------------------------------------------------");
                adaCocok = true;
            }
        }

        // Peringatan jika tidak ada produk yang cocok
        if (!adaCocok) {
            System.out.println("Maaf, tidak ditemukan makanan hewan yang sesuai dengan budget atau kriteria Anda.");
        }
        scanner.close();
    }
}