package Tugas.ucs;

import Tugas.Node;
import java.util.ArrayList;
import java.util.List;

/**
 * Kelas UniformCostSearch untuk melakukan pencarian berdasarkan biaya terendah.
 */
public class UniformCostSearch {

    /**
     * Melakukan pencarian dari node awal (start) ke node tujuan (goal) berdasarkan biaya terendah.
     *
     * @param start Node awal pencarian.
     * @param goal  Node tujuan pencarian.
     */
    public void search(NodeUCS start, NodeUCS goal) {

        // Menampilkan informasi pencarian dari node awal ke node tujuan.
        System.out.println("Mencari solusi dari "+start.getNilai()+" ke "+goal.getNilai());

        // Memulai pencarian dari node awal.
        NodeUCS eval = start;
        boolean done = false; // Flag untuk menentukan apakah pencarian sudah selesai atau belum.

        // Daftar untuk menyimpan solusi dari node-node yang telah dilewati.
        List<NodeUCS> solusi = new ArrayList<>();

        // Selama pencarian belum selesai.
        while (!done) {
            // Menampilkan node yang sedang dievaluasi beserta biayanya.
            System.out.println("Evaluasi: "+eval.getNilai()+" dengan cost "+eval.getCost());

            solusi.add(eval); // Menambahkan node yang sedang dievaluasi ke dalam daftar solusi.

            // Jika node yang sedang dievaluasi sama dengan node tujuan, maka pencarian selesai.
            if (eval.equals(goal)) {
                System.out.println("Solusi ditemukan ");
                done = true;
            }

            // Jika node yang dievaluasi memiliki tetangga.
            if (!eval.getTetangga().isEmpty()) {
                NodeUCS best = null; // Node dengan biaya terendah.
                int min = Integer.MAX_VALUE; // Nilai awal untuk biaya terendah.

                // Iterasi untuk setiap tetangga dari node yang dievaluasi.
                for (NodeUCS node: eval.getTetangga()) {
                    System.out.print(node.getNilai() + " ("+ node.getCost() + "), ");

                    // Jika biaya dari node tetangga lebih rendah dari nilai min saat ini.
                    if (min > node.getCost()) {
                        min = node.getCost(); // Update nilai min.
                        best = node; // Tetapkan node ini sebagai node dengan biaya terendah.
                    }
                }
                System.out.println();
                // Menampilkan node dengan biaya terendah yang dipilih untuk dievaluasi selanjutnya.
                System.out.println("Node terpilih: "+best.getNilai()+" ("+min+")");
                eval = best; // Update eval dengan node dengan biaya terendah.
            } else {
                // Jika node yang dievaluasi tidak memiliki tetangga, maka pencarian selesai.
                done = true;
            }
        }

        // Menampilkan solusi akhir.
        System.out.println();
        System.out.println("Solusi ditemukan: ");
        for (NodeUCS node: solusi) {
            System.out.println(node.getNilai()+" ("+node.getCost()+")");
        }
    }
}
