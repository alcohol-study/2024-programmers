import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public static int solution(String w) {
        Deque<Character> q = new LinkedList<>();

        for (int i = 0; i < w.length(); i++) {
            if (i == 0) {
                q.addLast(w.charAt(i));
            } else {
                if (!q.isEmpty()) {
                    if (w.charAt(i) == q.peekLast()) {
                        q.removeLast();
                    } else {
                        q.addLast(w.charAt(i));
                    }
                } else {
                    q.addLast(w.charAt(i));
                }
            }
        }

        if (q.isEmpty()) {
            return 1;
        } else {
            return 0;
        }
    }
}
