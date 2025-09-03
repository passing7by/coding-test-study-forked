package d250825.b7576;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 익은 토마토 주변이 계속 익어나감 => 너비우선탐색(BFS)
 * 익은 토마토 주변을 익혀나가고 더이상 익을 토마토가 없으면 멈춤
 * 한 번 돌 때마다 횟수 1증가(초기값 0)
 * 
 */
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String firstLine[] = br.readLine().split(" ");
		int m = Integer.parseInt(firstLine[0]);
		int n = Integer.parseInt(firstLine[1]);
		
		int[][] arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			String inputs[] = br.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				if("0".equals(inputs[j])) continue;
				
				arr[i][j] = Integer.parseInt(inputs[j]);
			}
		}
		
		
		
	}
}
