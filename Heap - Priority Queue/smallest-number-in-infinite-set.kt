class SmallestInfiniteSet() {
    val hashSet = mutableSetOf<Int>()
    val pq = PriorityQueue<Int>()
    var current = 1

    fun popSmallest(): Int {
        if (pq.isEmpty()) {
            return current++
        } else {
            hashSet.remove(pq.peek())
            return pq.poll()
        }
    }

    fun addBack(num: Int) {
        if (num < current && !hashSet.contains(num)) {
            hashSet.add(num)
            pq.add(num)
        }
    }

}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * var obj = SmallestInfiniteSet()
 * var param_1 = obj.popSmallest()
 * obj.addBack(num)
 */