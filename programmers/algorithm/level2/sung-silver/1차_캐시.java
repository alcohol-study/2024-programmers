import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
		int answer = 0;
		ArrayList<String> cache = new ArrayList<>();
		for(String city : cities){
			if(cacheSize!=0&&cache.contains(city.toLowerCase())) {
				cache.remove(city.toLowerCase());
				cache.add(city.toLowerCase());
				answer += 1;
			}
			else{
				if(cache.size()==cacheSize&cacheSize!=0){
					cache.remove(0);
				}
				cache.add(city.toLowerCase());
				answer+=5;
			}
		}
		return answer;
	}
}
