import java.util.*;

class Program {

    public static List<Integer[]> fourNumberSum(int[] array, int targetSum) {
        Map<Integer, List<Integer[]>> allPairSums =  new HashMap<>();
        List<Integer[]> quadruplets = new ArrayList<>();

        for (var i = 1; i < array.length-1; i++) {
            for (var j = i + 1; j < array.length; j++) {
                int sum = array[i] + array[j];
                int difference = targetSum - sum;
                if (allPairSums.containsKey(difference)) {
                    for (Integer[] pairSums : allPairSums.get(difference)) {
                        Integer[] quadruplet = new Integer[]{pairSums[0], pairSums[1], array[i], array[j]};
                        quadruplets.add(quadruplet);
                    }
                }
            }
            for (var k = 0; k < i; k++){
                int tranverseSum = array[i] + array[k];
                Integer[] pair = new Integer[]{array[i], array[k]};
                if (!allPairSums.containsKey(tranverseSum)) {
                    List<Integer[]> newPairs = new ArrayList<>();
                    newPairs.add(pair);
                    allPairSums.put(tranverseSum, newPairs);
                } else {
                    allPairSums.get(tranverseSum).add(pair);
                }
                
            }
        }
        
        return quadruplets;
    }
}