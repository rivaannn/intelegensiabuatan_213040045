package Tugas.astar;

import java.util.Comparator;

public class NodeComparator implements Comparator<Node> {
    private Node goal;

    public NodeComparator(Node goal) {
        this.goal = goal;
    }

    @Override
    public int compare(Node node1, Node node2) {
        double fScore1 = node1.getFScore();
        double fScore2 = node2.getFScore();

        return Double.compare(fScore1, fScore2);
    }
}
