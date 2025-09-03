package d250825.b1260;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String firstLine[] = br.readLine().split(" ");
		
		int n = Integer.parseInt(firstLine[0]); // 정점 갯수
		int m = Integer.parseInt(firstLine[1]); // 간선 갯수
		int v = Integer.parseInt(firstLine[2]); // 탐색 시작 정점
		
		// 인덱스 0은 버리고 1부터 사용할것이기 때문에 (n+1)*(n+1)의 이중배열을 만듦
		int arr[][] = new int[n + 1][n + 1];
		for (int i = 0; i < m; i++) { // 간선 갯수 m만큼 입력을 읽어들임
			String input[] = br.readLine().split(" ");
			int left = Integer.parseInt(input[0]);
			int right = Integer.parseInt(input[1]);
			
			arr[left][right] = 1;
			arr[right][left] = 1;
		}
		
		// DFS
		// stack 이용
		// 연결된 노드가 여러개면 작은 것부터 탐색
		// => 작은 것이 가장 나중에 stack으로 들어와야 함
		// => 큰 인덱스 > 작은 인덱스 순으로 stack에 넣기
		
		Deque<Integer> stack = new ArrayDeque<>();
		List<Integer> visited = new ArrayList<>();
		stack.push(v);
		while(!stack.isEmpty()) {
			int node = stack.pop();
			if (visited.contains(node)) continue;
			
			for (int i = n; i >= 1; i--) {
				if (arr[node][i] > 0) stack.push(i);
			}
			
			visited.add(node);
		}
		
		visited.forEach(e -> System.out.print(e + " "));
		System.out.println();
		
		visited.clear();
		
		// BFS
		// queue 이용
		// 연결된 노드가 여러개면 작은 것부터 탐색
		// => 작은 것이 가장 먼저 queue로 들어와야 함
		// => 작은 인덱스 > 큰 인덱스 순으로 queue에 넣기
		
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(v);
		while(!queue.isEmpty()) {
			int node = queue.poll();
			if (visited.contains(node)) continue;
			
			for (int i = 1; i <= n; i++) {
				if (arr[node][i] > 0) queue.offer(i);
			}
			
			visited.add(node);
		}
		
		visited.forEach(e -> System.out.print(e + " "));
	}
}
