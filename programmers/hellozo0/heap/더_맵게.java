import java.util.*;

class Solution {
    
    static ArrayList<Integer> heap;
    static int answer;
    
    public int solution(int[] scoville, int K) {
        
        answer = 1; //정답 초기화
        minHeap(); //최소힙 세팅
        
        //초기 힙에 scoville 넣기
        for(int i=1; i <= scoville.length; i++){
            heap.add(i, scoville[i-1]);
        }
        
        //이제 해당 식이 K 넘을 때 까지 remove insert 반복.?
        while( heap.get(1) + heap.get(2) * 2 < 7){
            
            insert(heap.get(1) + heap.get(2) * 2);
            remove(); //1번,2번 요소 삭제하고 
            remove(); //1번,2번 요소 삭제하고 
            answer++;
        }
        
        return answer;
    }
    
    private void minHeap() {
        heap = new ArrayList<Integer>();
        heap.add(0); // 0번째 인덱스는 사용 안합
    }
    
    
    private void insert(int now){
        
        heap.add(now); //해당 노드를 넣고
        int nowIndex = heap.size()-1; // 처음에 5의 index:7
        
        while(nowIndex > 1 && heap.get(nowIndex/2) > heap.get(nowIndex)) { //부모 인덱스의 값이 더 크다면
            int parent = heap.get(nowIndex/2);
            heap.set(nowIndex/2, now);
            heap.set(nowIndex, parent);
            
            nowIndex /= 2; // 이제 현재 노드는 부모 노드 인덱스 
        }
    }
    
    private int remove(){
        
        //비어 있으면 0 리턴
        if( heap.size() -1 < 1){
            return 0;
        }
        
        //마지막 노드를 첫 노드에 넣기 && 첫 노드 삭제
        heap.set(1, heap.size()-1);
        heap.remove(heap.size()-1);
        int index = 1; //새로 삽입한 인덱스 
        
        //자식의 인덱스 값이 힙의 사이즈 값보다 크다는것은 더이상 삽입할 위치를 벗어났다는뜻
        while((index * 2) < heap.size()){ 
            
            //바꿀곳 비교 (왼 -> 오)
            int minIndex = index*2;
            int min = heap.get(minIndex);
            
            //오른쪽 자식의 인덱스가 사이즈보다 작고 왼쪽 보다 더 작을때 오른쪽 자식을 부모와 바꿔줄 자식으로 지정
            //size = 7, 오른쪽 인덱스 : 3, 
            if((index * 2 + 1) < heap.size() && heap.get(index * 2 + 1) < min){
                minIndex = index * 2 + 1;
                min = heap.get(minIndex);
            }
            
            //부모가 더 작으면 stop
            if(heap.get(index) < min) break;
            
            //부모 자식 교환 minIndex = 2, min = 2, index = 1, 
            int temp = heap.get(index);
            heap.set(index, min);
            heap.set(minIndex, temp);
            index = minIndex;   
        }
        
        return 1;
    }
}
