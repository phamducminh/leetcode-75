class Solution {
    fun minFlips(a: Int, b: Int, c: Int): Int {
        var flips = 0
        var aa = a
        var bb = b
        var cc = c

        while (aa > 0 || bb > 0 || cc > 0) {
            val bitA = aa.and(1)
            val bitB = bb.and(1)
            val bitC = cc.and(1)

            if (bitC == 0) {
                flips += (bitA + bitB)
            } else {
                if (bitA == 0 && bitB == 0) {
                    flips++
                }
            }

            aa = aa.shr(1)
            bb = bb.shr(1)
            cc = cc.shr(1)
        }

        return flips
    }
}