class Solution {
    fun solution(brown: Int, yellow: Int): IntArray {
    val total = brown + yellow
    
    for (height in 1..totalCells) {
        if (total % height == 0) {
            val width = total / height
            if (width >= height) {
                val yellowCnt = (width - 2) * (height - 2)
                val brownCnt = total - yellow
                
                if (yellow == yellowCnt && brown == brownCnt) {
                    return intArrayOf(width, height)
                }
            }
        }
    }
    
    return intArrayOf()
}
}

