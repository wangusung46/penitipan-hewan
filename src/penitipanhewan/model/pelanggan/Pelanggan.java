package penitipanhewan.model.pelanggan;

public class Pelanggan {
    
    private Long id;
    private String nama;
    private String nomorHp;
    private String alamat;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNomorHp() {
        return nomorHp;
    }

    public void setNomorHp(String nomorHp) {
        this.nomorHp = nomorHp;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    @Override
    public String toString() {
        return "Pelanggan{" + "id=" + id + ", nama=" + nama + ", nomorHp=" + nomorHp + ", alamat=" + alamat + '}';
    }
    
}
