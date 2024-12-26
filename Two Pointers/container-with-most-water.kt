class Solution {
    fun maxArea(height: IntArray): Int {
        // // Brute force
        // var res = 0
        // val n = height.size

        // for (l in 0 .. n - 1) {
        //     for (r in l + 1 .. n  - 1) {
        //         var area = min(height[l], height[r]) * (r - l)
        //         res = max(res, area)
        //     } 
        // }

        // return res
        var res = 0
        var l = 0
        var r = height.size - 1

        while (l < r) {
            var area = min(height[l], height[r]) * (r - l)
            res = max(res, area)
            if (height[l] <= height[r]) {
                l++
            } else {
                r--
            }
        }

        return res
    }
}