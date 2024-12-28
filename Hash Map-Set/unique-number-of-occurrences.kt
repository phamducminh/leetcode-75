class Solution {
    fun uniqueOccurrences(arr: IntArray): Boolean {
        var result = true
        // val hashMap: MutableMap<Int, Int> = HashMap()
        // for (num in arr) {
        //     hashMap[num] = hashMap.getOrDefault(num, 0) + 1
        // }

        // val hashSet: MutableSet<Int> = HashSet()
        // hashMap.forEach { (_, value) -> 
        //     if (hashSet.contains(value)) 
        //         result = false
        //     else
        //         hashSet.add(value)
        // }
        
        // return result

        val hashMap: Map<Int, Int> = arr.asSequence().groupingBy { it }.eachCount()
        return hashMap.size == hashMap.values.toSet().size
    }
}