class Solution {
    fun findMinArrowShots(points: Array<IntArray>): Int {
        points.sortBy { it[1] }

        var res = 1
        var curArrow = points[0][1]
        for (i in 1 until points.size) {
            if (curArrow < points[i][0]) {
                res++
                curArrow = points[i][1]
            }
        }

        return res
    }
}