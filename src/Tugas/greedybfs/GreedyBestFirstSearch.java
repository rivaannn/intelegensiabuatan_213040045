package Tugas.greedybfs;

import java.util.ArrayList;
import java.util.PriorityQueue; //  menyimpan kota-kota yang dievaluasi dalam urutan prioritas berdasarkan heuristiknya.
import java.util.List; // Import List

public class GreedyBestFirstSearch {
    private List<Kota> path; // Mendeklarasikan path sebagai atribut kelas

    public GreedyBestFirstSearch() {
        path = new ArrayList<>(); // Inisialisasi path sebagai ArrayList
    }

    public void search(Kota start, Kota goal) {
        PriorityQueue<Kota> queue = new PriorityQueue<>(new HeuristicComparator(goal));

        System.out.println("Mencari rute dari " + start.getNama() + " ke " + goal.getNama());

        queue.add(start);
        start.setVisited(true);
        path.add(start);

        while (!queue.isEmpty()) {
            Kota currentKota = queue.poll();

            if (currentKota.equals(goal)) {
                System.out.println("Solusi ditemukan:");
                printPath();
                break;
            } else {
                for (Kota tetangga : currentKota.getTetangga()) {
                    if (!tetangga.isVisited()) {
                        queue.add(tetangga);
                        tetangga.setVisited(true);
                        path.add(tetangga);
                    }
                }
            }
        }
    }

    public void printPath() {
        System.out.print("Jalur: ");
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i).getNama());
            if (i < path.size() - 1) {
                System.out.print(" -> ");
            }
        }
        System.out.println();
    }
}
