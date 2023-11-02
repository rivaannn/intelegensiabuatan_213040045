package Tugas.greedybfs;

import java.util.Comparator;

public class HeuristicComparator implements Comparator<Kota> {
    private Kota goal;

    public HeuristicComparator(Kota goal) {
        this.goal = goal;
    }

    @Override
    public int compare(Kota kota1, Kota kota2) {
        double heuristic1 = calculateHeuristic(kota1);
        double heuristic2 = calculateHeuristic(kota2);

        return Double.compare(heuristic1, heuristic2);
    }

    private double calculateHeuristic(Kota kota) {
        double deltaX = kota.getX() - goal.getX();
        double deltaY = kota.getY() - goal.getY();
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }
}
