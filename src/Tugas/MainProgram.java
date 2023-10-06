package Tugas;

import Tugas.dls.DepthLimitedSearch;
import Tugas.ucs.NodeUCS;
import Tugas.ucs.UniformCostSearch;
import Tugas.bfs.BreadthFirstSearch;


public class MainProgram {
    public static void main(String[] args) {
        // Membuat kantor-kantor dan menghubungkannya
        Node kantorPusat = new Node("Kantor Pusat");
        Node kantorCabangA = new Node("Kantor Cabang A");
        Node kantorCabangB = new Node("Kantor Cabang B");

        kantorPusat.addTetangga(kantorCabangA);
        kantorPusat.addTetangga(kantorCabangB);

        System.out.println("BFS");
        BreadthFirstSearch bfs = new BreadthFirstSearch();
        bfs.search(kantorPusat, kantorCabangB);
        System.out.println();

        System.out.println("DLS");
        DepthLimitedSearch dls = new DepthLimitedSearch();
        dls.setLimit(1);
        dls.search(kantorPusat, kantorCabangB);
        System.out.println();

        NodeUCS kantorPusatUCS = new NodeUCS(kantorPusat, 0);
        NodeUCS kantorCabangAUCS = new NodeUCS(kantorCabangA, 2);
        NodeUCS kantorCabangBUCS = new NodeUCS(kantorCabangB, 3);

        kantorPusatUCS.addTetangga(kantorCabangAUCS);
        kantorPusatUCS.addTetangga(kantorCabangBUCS);

        System.out.println("UCS");
        UniformCostSearch ucs = new UniformCostSearch();
        ucs.search(kantorPusatUCS, kantorCabangBUCS);
        System.out.println();
    }
}

