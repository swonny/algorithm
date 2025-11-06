package 프로그래머스.bfs;

import java.util.*;

/**
 * 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/1844
 * 문제명: 게임 맵 최단거리
 */
class PGS_ShortestGameMap {
    int[][] visited;
    int[] dx = {0, 0, -1, 1};
    int[] dy = {1, -1, 0, 0};
    
    public int solution(int[][] maps) {
        int answer = 0;
        visited = new int[maps.length][maps[0].length];
        
        bfs(0, 0, maps);
        
        if (visited[maps.length - 1][maps[0].length - 1] == 0) {
            return -1;
        }
        return visited[maps.length - 1][maps[0].length - 1];
    }
    
    public void bfs(int x, int y, int[][] maps) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = 1;
        
        while (!q.isEmpty()) {
            var root = q.poll();
            for (int i = 0; i < 4; i++) {
                var toX = root[0] + dx[i];
                var toY = root[1] + dy[i];
                
                if (toX >= 0 && toY >= 0 && toX < maps.length && toY < maps[0].length) {
                    if (visited[toX][toY] == 0 && maps[toX][toY] == 1) {
                        visited[toX][toY] = visited[root[0]][root[1]] + 1;
                        q.add(new int[]{toX, toY});
                    }
                }
            }
        }
    }
}
