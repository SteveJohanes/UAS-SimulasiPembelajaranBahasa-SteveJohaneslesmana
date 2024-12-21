package SimulasiPembelajaranBahasa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DBUjian {

    private Koneksi koneksi;

    public DBUjian() {
        koneksi = new Koneksi();
    }

    // Fungsi untuk mengambil soal berdasarkan kodesoal
    public UjianModel getSoalByKode(String kodesoal) {
        UjianModel soal = null;
        try {
            koneksi.bukaKoneksi();
            String query = "SELECT * FROM soal WHERE kodesoal = ?";
            PreparedStatement pst = koneksi.dbKoneksi.prepareStatement(query);
            pst.setString(1, kodesoal);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                soal = new UjianModel();
                soal.setKodesoal(rs.getString("kodesoal"));
                soal.setSoal(rs.getString("soal"));
                soal.setJawaban(rs.getString("jawaban"));
                soal.setGambar(rs.getString("gambar"));
            }
            koneksi.tutupKoneksi();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return soal;
    }

    // Fungsi untuk memeriksa jawaban
public boolean cekJawaban(String kodesoal, String jawabanUser) {
        Connection conn = null;
        boolean isCorrect = false;
        try {
            // Membuka koneksi ke database
            Koneksi koneksi = new Koneksi();
            koneksi.bukaKoneksi();
            conn = koneksi.dbKoneksi;

            // Query untuk mengambil jawaban yang benar dari database
            String query = "SELECT jawaban FROM ujian WHERE kodesoal = ?";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, kodesoal);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                String jawabanDB = rs.getString("jawaban").trim(); // Mengambil jawaban dari DB dan menghapus spasi ekstra
                jawabanUser = jawabanUser.trim(); // Menghapus spasi ekstra dari jawaban pengguna

                // Membandingkan jawaban dengan benar (case-insensitive)
                if (jawabanDB.equalsIgnoreCase(jawabanUser)) {
                    isCorrect = true;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                new Koneksi().tutupKoneksi();
            }
        }

        return isCorrect;
    }
}
