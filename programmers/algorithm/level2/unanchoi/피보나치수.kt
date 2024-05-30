class Solution {
    fun solution(n: Int): Int {
    val cache = IntArray(n + 2)

    fun calc(x: Int): Int {
        if (x == 0) return 0
        if (x == 1) return 1

        if (cache[x] != 0) return cache[x]

        cache[x] = (calc(x - 1) + calc(x - 2)) % 1234567
        return cache[x]
    }

    return calc(n)
}
    
}
