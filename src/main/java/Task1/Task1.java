package Task1;

import java.util.Random;

public class Task1 {
    public static void main(String[] args) {
        final int ARRAY_SIZE = 5;
        int[] arrayA = new int[ARRAY_SIZE];
        int[] arrayB = new int[ARRAY_SIZE];
        int[] arrayC = new int[ARRAY_SIZE];

        Random r = new Random();
        for (int i = 0; i < ARRAY_SIZE; i++) {
            arrayA[i] = r.nextInt();
            arrayB[i] = r.nextInt();
            arrayC[i] = r.nextInt();
        }

        int[] result = new int[arrayA.length + arrayB.length + arrayC.length];
        System.arraycopy(arrayA, 0, result, 0, arrayA.length);
        System.arraycopy(arrayB, 0, result, arrayA.length, arrayB.length);
        System.arraycopy(arrayC, 0, result, arrayA.length + arrayB.length, arrayC.length);

        int[] sortedArray = sortArray(result);
        for (int e: sortedArray) {
            System.out.println(e);
        }

    }

    private static int[] sortArray(int[] arrayA) {
        if (arrayA == null) {
            return null;
        }
        if (arrayA.length < 2) {
            return arrayA;
        }
        int[] arrayB = new int[arrayA.length / 2];
        System.arraycopy(arrayA, 0, arrayB, 0, (arrayA.length / 2));

        int[] arrayC = new int[arrayA.length - (arrayA.length / 2)];
        System.arraycopy(arrayA, (arrayA.length / 2), arrayC, 0, (arrayA.length - arrayA.length / 2));

        arrayB = sortArray(arrayB);
        arrayC = sortArray(arrayC);

        return mergeArray(arrayB,arrayC);
    }

    private static int[] mergeArray(int[] arrayA, int[] arrayB) {
        int[] arrayC = new int[arrayA.length + arrayB.length];
        int indexA = 0;
        int indexB  = 0;
        for (int i = 0; i < arrayC.length; i++) {
            if (indexA == arrayA.length){
                arrayC[i] = arrayB[indexB];
                indexB++;
            } else if (indexB == arrayB.length) {
                arrayC[i] = arrayA[indexA];
                indexA++;
            } else if (arrayA[indexA] > arrayB[indexB]) {
                arrayC[i] = arrayA[indexA];
                indexA++;
            } else {
                arrayC[i] = arrayB[indexB];
                indexB++;
            }
        }
        return arrayC;
    }
}
