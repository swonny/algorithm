package 백준.dijkstra;

import java.util.PriorityQueue;

public class Dijkstra {

    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(1);
        pq.offer(2);
        pq.offer(4);
        pq.offer(3);
        System.out.println(pq.toString());
    }
}
