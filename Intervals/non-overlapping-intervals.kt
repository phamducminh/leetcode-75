class Solution {
    fun eraseOverlapIntervals(intervals: Array<IntArray>): Int {
        intervals.sortWith { a, b ->
        val firstCompare = a[0].compareTo(b[0])
        if (firstCompare != 0) firstCompare else a[1].compareTo(b[1])
    }

        var res = 0
        var prevEnd = intervals[0][1]
        for (i in 1 until intervals.size) {
            val (start, end) = intervals[i]
            if (start >= prevEnd) {
                prevEnd = end
            } else {
                res++
                prevEnd = min(end, prevEnd)
            }
        }

        return res
    }
}