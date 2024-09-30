import java.util.Scanner;

abstract class BangunDatar {
    public abstract double hitungLuas();
    public abstract double hitungKeliling();
}

class Persegi extends BangunDatar {
    private double sisi;

    public Persegi(double sisi) {
        this.sisi = sisi;
    }

    public double hitungLuas() {
        return sisi * sisi;
    }

    public double hitungKeliling() {
        return 4 * sisi;
    }
}

class PersegiPanjang extends BangunDatar {
    private double panjang;
    private double lebar;

    public PersegiPanjang(double panjang, double lebar) {
        this.panjang = panjang;
        this.lebar = lebar;
    }

    public double hitungLuas() {
        return panjang * lebar;
    }


    public double hitungKeliling() {
        return 2 * (panjang + lebar);
    }
}

class Lingkaran extends BangunDatar {
    private double jariJari;

    public Lingkaran(double jariJari) {
        this.jariJari = jariJari;
    }

    public double hitungLuas() {
        return Math.PI * jariJari * jariJari;
    }

    public double hitungKeliling() {
        return 2 * Math.PI * jariJari;
    }
}
public class HitungBangunDatar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Pilih bangun datar:");
        System.out.println("1. Persegi");
        System.out.println("2. Persegi Panjang");
        System.out.println("3. Lingkaran");

        System.out.print("Masukkan pilihan Anda: ");
        int pilihan = scanner.nextInt();

        BangunDatar bangun;

        switch (pilihan) {
            case 1:
                System.out.print("Masukkan sisi persegi: ");
                double sisi = scanner.nextDouble();
                bangun = new Persegi(sisi);
                break;
            case 2:
                System.out.print("Masukkan panjang persegi panjang: ");
                double panjang = scanner.nextDouble();
                System.out.print("Masukkan lebar persegi panjang: ");
                double lebar = scanner.nextDouble();
                bangun = new PersegiPanjang(panjang, lebar);
                break;
            case 3:
                System.out.print("Masukkan jari-jari lingkaran: ");
                double jariJari = scanner.nextDouble();
                bangun = new Lingkaran(jariJari);
                break;
            default:
                System.out.println("Pilihan tidak valid");
                scanner.close();
                return;
        }

        System.out.printf("Luas: %.1f\n", bangun.hitungLuas());
        System.out.printf("Keliling: %.1f\n", bangun.hitungKeliling());

        scanner.close();
    }
}