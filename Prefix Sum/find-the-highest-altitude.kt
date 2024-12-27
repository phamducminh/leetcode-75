class Solution {
    fun largestAltitude(gain: IntArray): Int {
        var highest = 0
        var netGain = 0
        gain.forEach { value ->
            netGain += value
            highest = max(highest, netGain)
        }
        return highest
    }
}