package Tugas.greedybfs;

import java.util.ArrayList;
import java.util.List;

public class Kota {
    private String nama;
    private int x;
    private int y;
    private List<Kota> tetangga;
    private boolean visited;

    public Kota(String nama, int x, int y) {
        this.nama = nama;
        this.x = x;
        this.y = y;
        this.tetangga = new ArrayList<>();
        this.visited = false;
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

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public boolean isVisited() {
        return visited;
    }

    public void addTetangga(Kota tetangga) {
        this.tetangga.add(tetangga);
    }

    public List<Kota> getTetangga() {
        return tetangga;
    }
}
