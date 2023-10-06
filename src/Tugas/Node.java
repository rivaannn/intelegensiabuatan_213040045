package Tugas;

import java.util.ArrayList;
import java.util.List;

/**
 * Kelas Node merepresentasikan setiap titik (node) dalam graf. Dalam konteks ini, node dapat dianggap sebagai lokasi
 * atau kantor dalam simulasi pengiriman surat.
 */
public class Node {

    // Variabel untuk menyimpan nama atau identifikasi dari node.
    private String nilai;

    // Daftar tetangga dari node ini.
    private List<Node> tetangga;

    /**
     * Constructor dari kelas Node.
     * @param nilai Nilai atau nama dari node.
     */
    public Node(String nilai) {
        tetangga = new ArrayList<>();
        this.nilai = nilai;
    }

    /**
     * Mengatur nilai dari node.
     * @param nilai Nilai yang akan diatur.
     */
    public void setNilai(String nilai) {
        this.nilai = nilai;
    }

    /**
     * Mengembalikan nilai dari node.
     * @return Nilai dari node.
     */
    public String getNilai() {
        return nilai;
    }

    /**
     * Mengatur daftar tetangga untuk node ini.
     * @param tetangga Daftar tetangga yang akan diatur.
     */
    public void setTetangga(List<Node> tetangga) {
        this.tetangga = tetangga;
    }

    /**
     * Mengembalikan daftar tetangga dari node ini.
     * @return Daftar tetangga.
     */
    public List<Node> getTetangga() {
        return tetangga;
    }

    /**
     * Menambahkan sebuah tetangga ke dalam daftar tetangga dari node ini.
     * @param node Node tetangga yang akan ditambahkan.
     */
    public void addTetangga(Node node) {
        tetangga.add(node);
    }

    /**
     * Override dari method equals untuk membandingkan apakah dua objek Node memiliki nilai yang sama.
     * @param obj Objek lain yang akan dibandingkan.
     * @return true jika objek memiliki nilai yang sama, sebaliknya false.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Node) {
            return ((Node) obj).nilai.equals(this.nilai);
        }
        return false;
    }
}
