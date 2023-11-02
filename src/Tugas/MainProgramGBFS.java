package Tugas;

import Tugas.greedybfs.GreedyBestFirstSearch;
import Tugas.greedybfs.Kota;

public class MainProgramGBFS {

    public static void main(String[] args) {
        Kota jakarta = new Kota("Jakarta", 6, 7);
        Kota bandung = new Kota("Bandung", 2, 6);
        Kota surabaya = new Kota("Surabaya", 9, 5);
        Kota medan = new Kota("Medan", 12, 10);
        Kota yogyakarta = new Kota("Yogyakarta", 5, 4);
        Kota semarang = new Kota("Semarang", 6, 3);
        Kota palembang = new Kota("Palembang", 5, 8);

        jakarta.addTetangga(bandung);
        jakarta.addTetangga(semarang);
        bandung.addTetangga(jakarta);
        bandung.addTetangga(semarang);
        bandung.addTetangga(yogyakarta);
        surabaya.addTetangga(yogyakarta);
        surabaya.addTetangga(semarang);
        medan.addTetangga(palembang);

        GreedyBestFirstSearch gbfs = new GreedyBestFirstSearch();
        gbfs.search(jakarta, medan);
        gbfs.printPath();
    }
}
