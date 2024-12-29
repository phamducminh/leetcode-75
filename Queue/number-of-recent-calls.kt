class RecentCounter() {
    private val requests = mutableListOf<Int>()

    fun ping(t: Int): Int {
        requests.add(t)
        
        var count = 0
        for (i in requests.lastIndex downTo 0) {
            count += if (requests[i] >= t - 3000) 1 else 0
        }

        return count
        // return requests.count { it in t - 3000 .. t }
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * var obj = RecentCounter()
 * var param_1 = obj.ping(t)
 */