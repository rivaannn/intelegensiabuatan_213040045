package Tugas.dls;

import Tugas.Node;

/**
 * Kelas DepthLimitedSearch untuk melakukan pencarian berdasarkan kedalaman dengan batas tertentu.
 */
public class DepthLimitedSearch {

    // Batas maksimum kedalaman pencarian.
    private int limit;

    /**
     * Setter untuk menentukan batas kedalaman pencarian.
     *
     * @param limit Batas maksimum kedalaman pencarian.
     */
    public void setLimit(int limit) {
        this.limit = limit;
    }

    /**
     * Getter untuk mendapatkan batas kedalaman pencarian.
     *
     * @return Batas kedalaman pencarian.
     */
    public int getLimit() {
        return limit;
    }

    /**
     * Melakukan pencarian dari node awal (start) ke node tujuan (goal) dengan batas kedalaman tertentu.
     *
     * @param start Node awal pencarian.
     * @param goal  Node tujuan pencarian.
     */
    public void search(Node start, Node goal) {

        // Menampilkan informasi pencarian dari node awal ke node tujuan.
        System.out.println("Mencari solusi dari "+start.getNilai()+" ke "+goal.getNilai());

        // Memulai pencarian dari node awal.
        Node eval = start;

        // Melakukan iterasi berdasarkan limit kedalaman yang ditentukan.
        for (int i = 0; i < limit; i++) {

            // Menampilkan informasi level kedalaman saat ini dan node yang sedang dievaluasi.
            System.out.println("Level "+i+" evaluasi: "+eval.getNilai());

            // Jika node yang sedang dievaluasi adalah node tujuan, maka solusi ditemukan.
            if (eval.equals(goal)) {
                System.out.println("Solusi ditemukan ");
                break;
            }

            // Jika node yang dievaluasi memiliki tetangga, lanjutkan pencarian ke tetangga pertama.
            // DLS dalam kode ini hanya memeriksa tetangga pertama dari setiap node.
            if (!eval.getTetangga().isEmpty()) {
                eval = eval.getTetangga().get(0);
            } else {
                // Jika node tidak memiliki tetangga, berhenti dari pencarian.
                break;
            }
        }
    }
}
