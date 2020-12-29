package MultiMath_Math;

public class VectorCalc {

    public int[] vecAdd(int[] vec1, int[] vec2) {
        int[] vectorSum = new int[getVectorLength(vec1)];

        for(int elemCounter = 0; elemCounter < getVectorLength(vec1); elemCounter++){
            vectorSum[elemCounter] = vec1[elemCounter] + vec2[elemCounter];
        }

        return vectorSum;
    }

    private int getVectorLength(int[] vector) {
        return vector.length;
    }
}
