package Tugas.bfs;

import Tugas.Node;
import java.util.List;
import java.util.ArrayList;

/**
 * Kelas Solusi untuk merepresentasikan sebuah solusi dalam pencarian BFS.
 * Menyimpan sebuah node dan daftar node yang dilewati untuk mencapai node tersebut.
 */
public class Solusi {

    // Daftar node yang dilewati untuk mencapai node saat ini.
    private List<Node> nodes;

    // Node saat ini yang sedang dievaluasi atau diperiksa.
    private Node node;

    /**
     * Konstruktor Solusi.
     * Menginisialisasi daftar nodes dengan ArrayList kosong.
     */
    public Solusi() {
        nodes = new ArrayList<>();
    }

    /**
     * Setter untuk node saat ini.
     *
     * @param node Node yang ingin di-set.
     */
    public void setNode(Node node) {
        this.node = node;
    }

    /**
     * Getter untuk node saat ini.
     *
     * @return Node saat ini.
     */
    public Node getNode() {
        return node;
    }

    /**
     * Setter untuk daftar nodes.
     * Meng-copy seluruh isi dari daftar nodes yang diberikan ke daftar nodes di objek ini.
     *
     * @param nodes Daftar node yang ingin di-set.
     */
    public void setNodes(List<Node> nodes) {
        this.nodes = new ArrayList<>(nodes);
    }

    /**
     * Getter untuk daftar nodes.
     *
     * @return Daftar node yang telah dilewati.
     */
    public List<Node> getNodes() {
        return nodes;
    }
}
