// 단순 LinkedList
package d250825.impl.linkedlist;

public class SimpleLinkedList<T> {

    // 노드: 값 + 다음 노드 주소
    private static class Node<T> {
        T data;        // 실제 값
        Node<T> next;  // 다음 노드 참조

        Node(T data) {
            this.data = data;
        }
    }

    private Node<T> head; // 리스트 시작 노드
    private int size;     // 요소 개수

    // 끝에 요소 추가
    public void add(T data) {
        Node<T> newNode = new Node<>(data);

        // 리스트가 비어있으면 head로 설정
        if (head == null) {
            head = newNode;
        } else {
            // 마지막 노드까지 이동
            Node<T> curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = newNode;
        }
        size++;
    }

    // 인덱스로 요소 가져오기
    public T get(int index) {
        checkIndex(index);

        Node<T> curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr.data;
    }

    // 현재 리스트 크기
    public int size() {
        return size;
    }

    // 인덱스 유효성 체크
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("인덱스 오류: " + index);
        }
    }
}