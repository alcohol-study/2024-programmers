class Solution {
fun solution(k: Int, tangerine: IntArray): Int {
    val countMap = mutableMapOf<Int, Int>()

    for (size in tangerine) {
        countMap[size] = countMap.getOrDefault(size, 0) + 1
    }
    val sortedSizes = countMap.toList().sortedByDescending { (_, count) -> count }

    var count = 0
    var result = 0
    for ((size, cnt) in sortedSizes) {
        count += cnt
        result++
        if (count >= k) {
            break
        }
    }

    return result
}

}
