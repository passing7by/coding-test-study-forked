package d250825.b2606;

import java.io.*;
import java.util.*;

/*
 * 컴퓨터의 수는 100이하... 시간초과 신경쓰지 않고 구현만 하면 될 듯
 * https://coding-business.tistory.com/118
 * 이중 배열을 사용해서 구현
 * 1 2가 들어왔다 치면
 * arr[1][2] = 1, arr[2][1] = 1을 하는 거임 (양방향으로 연결)
 * 
 * 첫째줄은 컴퓨터의 수 n
 * 둘째줄은 연결쌍의 수 m
 * 배열은 arr[n][n]으로 생성, 입력받을 때의 반복횟수는 m번으로 설정
 */
public class Main {
	public static void main(String[] args) throws Exception {
//		int n = 7;
//		int m = 6;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine()); // 안씀

		int arr[][] = new int[n][n];
		
		for (int i = 0; i < m; i++) {
			String input[] = br.readLine().trim().split(" ");
			int left = Integer.parseInt(input[0]) - 1;
			int right = Integer.parseInt(input[1]) - 1;
			
			arr[left][right] = 1;
			arr[right][left] = 1;
		}
		
		// ----------------- try 2
		
		// 감염된 pc와 연결되면 그 pc도 감염됨 
		// => 개념적으로는 BFS(너비 우선 탐색) 적용이 적합하나, DFS(깊이 우선 탐색)으로도 풀 수는 있음
		// BFS에는 큐 자료구조를 사용, DFS에는 스택 자료구조를 사용
		
		// 감염된 pc가 감염시킨 pc들을 큐에 담고, 큐에 있는 pc들을 하나씩 확인
		// 큐에 있는 pc가 감염시킨 pc들을 큐에 담고, 또 큐에 있는 pc들을 하나씩 확인
		// 큐가 비어있으면(감염시킨 pc를 더이상 찾을 수 없다면) 반복 중지
		// 이 때 pc들은 양방향으로 연결되어 있으므로, 한 번 큐에 들어갔던 pc가 또 들어갈 수 있음
		// 이미 방문했던 pc는 set에 넣고, set에 있는 pc는 다시 방문하지 않으면 효율을 놓일 수 있음
		
		// ArrayDeque메서드 중 Queue 자료구조의 메서드만 사용하도록 강제하기 위해 Queue로 선언
		Queue<Integer> queue = new ArrayDeque<Integer>(); // 감염된 pc들 (방문해야 할 pc들)
		Set<Integer> visited = new HashSet<Integer>(); // 이미 방문한 pc들
		
		queue.offer(0); // pc = 1 부터 시작
		while(!queue.isEmpty()) {
			int pc = queue.poll();
			if (visited.contains(pc)) continue; // 이미 방문했던 pc면 다시 방문하지 않음
			
			for (int i = 0; i < n; i++) {
				if (arr[pc][i] > 0) queue.offer(i);
			}
			
			visited.add(pc);
		}
		
		System.out.println(visited.size() - 1); // 방문했던 pc의 갯수를 출력 (pc = 1 은 제외)
		
		// ----------------- try 1
		
		// arr[1]에서 값이 1 이상인 인덱스는 바이러스 감염
		// 감염 목록을 set에 담음
		// arr[2]로 이동
		// 2가 만약 감염 목록에 있다면 arr[2]를 확인하며 set에 담고, 없다면 패스
		
		// set에 더이상 추가되지 않을 때까지 순회 -> 시간 초과...
		/*
		Set<Integer> set = new HashSet<>();
		set.add(1);
		
		boolean isChanged = true;
		while(isChanged) {
			isChanged = false; // set에 추가했는지 여부의 기본값을 false로 설정
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (!set.contains(i)) continue;
					else if (arr[i][j] > 0) {
						set.add(j);
						isChanged = true; // 추가되면 true로 변경
					}
				}
			}			
		}
		
		// 문제는 1을 통해 감염된 pc의 수를 요구하고 있기 때문에
		// set에서 1을 제외한 size를 출력
		System.out.println(set.size() - 1);
		 */
	}
}
