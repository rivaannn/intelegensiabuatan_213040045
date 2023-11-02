package Tugas.astar;

import java.util.*;

public class AStarSearch {
    private List<Node> path; // Deklarasikan path sebagai atribut kelas

    public AStarSearch() {
        path = new ArrayList<>();
    }

    public void search(Node start, Node goal) {
        PriorityQueue<Node> openSet = new PriorityQueue<>(new NodeComparator(goal));
        List<Node> closedSet = new ArrayList<>();

        System.out.println("Mencari rute dari " + start.getNama() + " ke " + goal.getNama());

        openSet.add(start);
        start.setGScore(0);
        path.add(start);

        while (!openSet.isEmpty()) {
            Node current = openSet.poll();
            closedSet.add(current);
            path.add(current); // Tambahkan ini untuk mencatat setiap langkah

            if (current.equals(goal)) {
                System.out.println("Solusi ditemukan:");
                printPath(current);
                break;
            }

            for (Node neighbor : current.getTetangga()) {
                if (closedSet.contains(neighbor)) {
                    continue;
                }

                double tentativeGScore = current.getGScore() + current.calculateDistance(neighbor);

                if (!openSet.contains(neighbor) || tentativeGScore < neighbor.getGScore()) {
                    neighbor.setCameFrom(current);
                    neighbor.setGScore(tentativeGScore);
                    neighbor.setFScore(tentativeGScore + neighbor.calculateHeuristic(goal));

                    if (!openSet.contains(neighbor)) {
                        openSet.add(neighbor);
                    }
                }
            }
        }
    }

    public void printPath(Node current) {
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
