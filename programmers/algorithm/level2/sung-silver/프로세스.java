import java.util.*;

class Solution {
    public class Process{
        int location;
        int priority;
        
        public Process(int location, int priority){
            this.location = location;
            this.priority = priority;
        }
        
        public int getLocation(){
            return location;
        }
        
        public int getPriority(){
            return priority;
        }
    
    }
    
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Process> p = new LinkedList<>();
        List<Integer> sort_priorities = new ArrayList<>();
        
        for(int i=0; i<priorities.length ; i++){
            p.add(new Process(i, priorities[i]));
            sort_priorities.add(priorities[i]);
        }
        
        sort_priorities.sort(Comparator.reverseOrder());
        
        while(!p.isEmpty()){
            Process process = p.poll();
            int priority = sort_priorities.get(0);
            
            if(process.getPriority() == priority){
                answer++;
                if(process.getLocation() == location){
                    break;
                }
                sort_priorities.remove(0);
            }
            else{
                p.add(process);
            }
        }
        
        

        return answer;
    }
}
