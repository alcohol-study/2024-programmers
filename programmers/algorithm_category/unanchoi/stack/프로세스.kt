import java.util.LinkedList

class Solution {
    fun solution(priorities: IntArray, location: Int): Int {
        var answer = 0
        val locationQueue = LinkedList<Int>()
        val queue:LinkedList<Int> = LinkedList()

        for (idx in priorities.indices) {
            queue.add(priorities[idx])
            locationQueue.add(idx)
        }

        var answerList = mutableListOf<Int>()

        while (queue.isNotEmpty()) {
            val num = queue.peek()
            val numIdx = locationQueue.peek()

            if (num == queue.maxOrNull()) {
                answerList.add(numIdx)
                queue.pop()
                locationQueue.pop()
            }
            else {
               queue.add(queue.pop())
                locationQueue.add(locationQueue.pop())
            }
        }

        println(answerList)

        for (idx in 0..answerList.size-1) {
            if (location == answerList[idx]) {
                return idx+1
            }
        }
        return 0
    }
}