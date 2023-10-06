package Tugas;

import Tugas.dls.DepthLimitedSearch;
import Tugas.ucs.NodeUCS;
import Tugas.ucs.UniformCostSearch;
import Tugas.bfs.BreadthFirstSearch;

/**
 * Kelas MainProgram berfungsi sebagai driver untuk menjalankan program pencarian rute pengiriman surat.
 */
public class MainProgram {

    public static void main(String[] args) {
        // Inisialisasi kantor-kantor (sebagai node) yang digunakan dalam simulasi.
        Node kantorPusat = new Node("Kantor Pusat");
        Node kantorCabangA = new Node("Kantor Cabang A");
        Node kantorCabangB = new Node("Kantor Cabang B");

        // Menyambungkan kantor pusat dengan kantor cabang A dan B (membentuk graph).
        kantorPusat.addTetangga(kantorCabangA);
        kantorPusat.addTetangga(kantorCabangB);

        // Mencoba metode Breadth First Search (BFS) untuk mencari rute dari kantor pusat ke kantor cabang B.
        System.out.println("BFS");
        BreadthFirstSearch bfs = new BreadthFirstSearch();
        bfs.search(kantorPusat, kantorCabangB);
        System.out.println();

        // Mencoba metode Depth Limited Search (DLS) dengan batas kedalaman 1 untuk mencari rute dari kantor pusat ke kantor cabang B.
        System.out.println("DLS");
        DepthLimitedSearch dls = new DepthLimitedSearch();
        dls.setLimit(1);
        dls.search(kantorPusat, kantorCabangB);
        System.out.println();

        // Membuat objek NodeUCS yang berisi data biaya untuk mencapai setiap kantor.
        NodeUCS kantorPusatUCS = new NodeUCS(kantorPusat, 0);  // Biaya dari kantor pusat ke dirinya sendiri adalah 0.
        NodeUCS kantorCabangAUCS = new NodeUCS(kantorCabangA, 2); // Misalnya biaya dari kantor pusat ke kantor cabang A adalah 2.
        NodeUCS kantorCabangBUCS = new NodeUCS(kantorCabangB, 3); // Misalnya biaya dari kantor pusat ke kantor cabang B adalah 3.

        // Menghubungkan objek NodeUCS, sama seperti yang dilakukan dengan objek Node di atas.
        kantorPusatUCS.addTetangga(kantorCabangAUCS);
        kantorPusatUCS.addTetangga(kantorCabangBUCS);

        // Mencoba metode Uniform Cost Search (UCS) untuk mencari rute dengan biaya terendah dari kantor pusat ke kantor cabang B.
        System.out.println("UCS");
        UniformCostSearch ucs = new UniformCostSearch();
        ucs.search(kantorPusatUCS, kantorCabangBUCS);
        System.out.println();
    }
}
