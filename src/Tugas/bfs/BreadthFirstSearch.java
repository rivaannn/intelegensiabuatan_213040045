package Tugas.bfs;

import Tugas.Node;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class BreadthFirstSearch {

    /**
     * Fungsi untuk mencari jalur dari node start ke node goal menggunakan algoritma BFS.
     *
     * @param start Node awal pencarian
     * @param goal  Node tujuan pencarian
     */
    public void search(Node start, Node goal) {

        // Antrian untuk menyimpan solusi sementara selama pencarian.
        Queue<Solusi> queue = new LinkedBlockingQueue<>();

        // Membuat solusi awal dengan node awal (start).
        Solusi solusiStart = new Solusi();
        solusiStart.setNode(start);

        // Menambahkan solusi awal ke antrian.
        queue.add(solusiStart);

        // Informasi bahwa kita sedang mencari solusi dari node awal ke node tujuan.
        System.out.println("Mencari solusi dari "+start.getNilai()+" ke "+goal.getNilai());

        // Selama antrian tidak kosong, proses terus mencari jalur.
        while (!queue.isEmpty()) {
            // Mengambil (poll) solusi dari antrian untuk dievaluasi.
            Solusi eval = queue.poll();

            // Menampilkan node yang sedang dievaluasi.
            System.out.println("Evaluasi: "+eval.getNode().getNilai());

            // Jika node yang dievaluasi sama dengan node tujuan, maka solusi ditemukan.
            if (eval.getNode().equals(goal)) {
                System.out.println("Solusi ditemukan: ");
                for(Node node: eval.getNodes()) {
                    System.out.print(node.getNilai()+" -> ");
                }
                System.out.println(eval.getNode().getNilai());
                break;
            } else {
                // Jika bukan node tujuan, lanjutkan ke node tetangganya.
                System.out.println("Suksesor "+eval.getNode().getNilai());
                for (Node successor: eval.getNode().getTetangga()) {
                    System.out.print(successor.getNilai()+" ");

                    // Membuat solusi baru berdasarkan node tetangga.
                    Solusi solusiSuksesor = new Solusi();
                    solusiSuksesor.setNode(successor);
                    solusiSuksesor.setNodes(eval.getNodes());
                    solusiSuksesor.getNodes().add(eval.getNode());

                    // Menambahkan solusi baru ke antrian.
                    queue.offer(solusiSuksesor);
                }
                System.out.println();
                System.out.println();
            }
        }
    }
}
