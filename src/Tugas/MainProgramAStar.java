package Tugas;
import Tugas.astar.AStarSearch;
import Tugas.astar.Node;

class MainProgramAstar {
    public static void main(String[] args) {
        // Membuat objek Node yang mewakili kota-kota
        Node jakarta = new Node("Jakarta", 6, 7);
        Node bandung = new Node("Bandung", 20, 5);
        Node surabaya = new Node("Surabaya", 9, 5);
        Node medan = new Node("Medan", 12, 10);
        Node yogyakarta = new Node("Yogyakarta", 5, 4);
        Node semarang = new Node("Semarang", 6, 3);
        Node palembang = new Node("Palembang", 5, 8);

        // Menambahkan tetangga-tetangga kota
        jakarta.addNeighbor(bandung);
        jakarta.addNeighbor(semarang);
        bandung.addNeighbor(jakarta);
        bandung.addNeighbor(semarang);
        bandung.addNeighbor(yogyakarta);
        surabaya.addNeighbor(yogyakarta);
        surabaya.addNeighbor(semarang);
        medan.addNeighbor(palembang);

        // Membuat objek AStarSearch
        AStarSearch astar = new AStarSearch();

        // Menjalankan algoritma A* untuk mencari rute dari bandung ke Medan
        astar.search(bandung, medan);
        astar.printPath(medan);
    }
}

