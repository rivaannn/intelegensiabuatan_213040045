package Tugas.ucs;

import Tugas.Node;
import java.util.ArrayList;
import java.util.List;

/**
 * Kelas NodeUCS merepresentasikan sebuah node dengan biaya (cost) untuk Uniform Cost Search.
 */
public class NodeUCS {

    // Nilai dari node.
    private String nilai;

    // Biaya untuk mencapai node ini.
    private int cost;

    // Daftar tetangga dari node ini.
    private List<NodeUCS> tetangga;

    /**
     * Constructor untuk menciptakan sebuah NodeUCS dengan nilai dan biaya tertentu.
     *
     * @param node Node yang akan diambil nilainya.
     * @param cost Biaya untuk mencapai node ini.
     */
    public NodeUCS(Node node, int cost) {
        this.nilai = node.getNilai();
        this.cost = cost;
        tetangga = new ArrayList<>();
    }

    // Getter untuk mendapatkan nilai dari node.
    public String getNilai() {
        return nilai;
    }

    // Setter untuk menetapkan nilai ke node.
    public void setNilai(String nilai) {
        this.nilai = nilai;
    }

    // Setter untuk menetapkan biaya ke node.
    public void setCost(int cost) {
        this.cost = cost;
    }

    // Getter untuk mendapatkan biaya dari node.
    public int getCost() {
        return cost;
    }

    // Setter untuk menetapkan daftar tetangga ke node.
    public void setTetangga(List<NodeUCS> tetangga) {
        this.tetangga = tetangga;
    }

    // Getter untuk mendapatkan daftar tetangga dari node.
    public List<NodeUCS> getTetangga() {
        return tetangga;
    }

    /**
     * Menambahkan sebuah node tetangga ke dalam daftar tetangga dari node ini.
     *
     * @param node Node tetangga yang akan ditambahkan.
     */
    public void addTetangga(NodeUCS node) {
        tetangga.add(node);
    }

    /**
     * Override metode equals untuk membandingkan apakah dua objek NodeUCS memiliki nilai yang sama.
     *
     * @param obj Objek yang akan dibandingkan.
     * @return True jika objek memiliki nilai yang sama, sebaliknya false.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof NodeUCS) {
            return ((NodeUCS) obj).nilai.equals(this.nilai);
        }
        return false;
    }
}
