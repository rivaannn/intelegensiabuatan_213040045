package Tugas.astar;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private String nama;
    private int x;
    private int y;
    private List<Node> tetangga;
    private double gScore; // Biaya sejauh ini dari titik awal ke titik ini
    private double fScore; // Biaya total perkiraan dari titik awal ke titik akhir
    private Node cameFrom; // Node sebelumnya dalam rute terpendek

    public Node(String nama, int x, int y) {
        this.nama = nama;
        this.x = x;
        this.y = y;
        this.tetangga = new ArrayList<>();
        this.gScore = Double.POSITIVE_INFINITY;
        this.fScore = Double.POSITIVE_INFINITY;
        this.cameFrom = null;
    }

    public String getNama() {
        return nama;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public double getGScore() {
        return gScore;
    }

    public void setGScore(double gScore) {
        this.gScore = gScore;
    }

    public double getFScore() {
        return fScore;
    }

    public void setFScore(double fScore) {
        this.fScore = fScore;
    }

    public Node getCameFrom() {
        return cameFrom;
    }

    public void setCameFrom(Node cameFrom) {
        this.cameFrom = cameFrom;
    }

    public double calculateDistance(Node neighbor) {
        double deltaX = neighbor.getX() - this.getX();
        double deltaY = neighbor.getY() - this.getY();
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }

    public double calculateHeuristic(Node goal) {
        double deltaX = goal.getX() - this.getX();
        double deltaY = goal.getY() - this.getY();
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }

    public void addNeighbor(Node neighbor) {
        this.tetangga.add(neighbor);
    }

    public List<Node> getTetangga() {
        return tetangga;
    }
}
