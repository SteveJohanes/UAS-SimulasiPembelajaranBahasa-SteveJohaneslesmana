package SimulasiPembelajaranBahasa;

public class UjianModel {

    private String kodesoal;  // Kode soal
    private String soal;      // Pertanyaan soal
    private String jawaban;   // Jawaban yang benar
    private String gambar;    // Lokasi gambar soal (jika ada)

    // Getter dan Setter untuk kodesoal
    public String getKodesoal() {
        return kodesoal;
    }

    public void setKodesoal(String kodesoal) {
        this.kodesoal = kodesoal;
    }

    // Getter dan Setter untuk soal
    public String getSoal() {
        return soal;
    }

    public void setSoal(String soal) {
        this.soal = soal;
    }

    // Getter dan Setter untuk jawaban
    public String getJawaban() {
        return jawaban;
    }

    public void setJawaban(String jawaban) {
        this.jawaban = jawaban;
    }

    // Getter dan Setter untuk gambar
    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }
}
