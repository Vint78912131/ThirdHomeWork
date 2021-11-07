import java.util.Arrays;

/**
 * Lesson 3. HomeWork
 *
 * @author SotnikovVS
 * @version 08.11.2021
 *
 */
class ThirdHomeWork {
    public static void main(String[] args) {
        System.out.println("*** Task 1 ***\n");
        int[] firstArr = getBinaryArray(20);
        printArrayToRow(firstArr);
        printArrayToRow(invertBinaryArray(firstArr));
        System.out.println();

        System.out.println("*** Task 2 ***\n");
        int[] secondArr = new int[100];
        printArrayToRow(setHundArray(secondArr));
        System.out.println();

        System.out.println("*** Task 3 ***\n");
        int[] thirdArr = new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        printArrayToRow(thirdArr);
        printArrayToRow(setDoubleSixArray(thirdArr));
        System.out.println();

        System.out.println("*** Task 4 ***\n");
        printDoubleArray(setDiagonalsAtOnes(getZeroSquareMatrix(5)));
        System.out.println();

        System.out.println("*** Task 5 ***\n");
        printArrayToRow(getValueArray(3, 7));
        System.out.println();

        System.out.println("*** Task 6 ***\n");
        int[] fourthArr = new int[]{-2, 5, 3, 17, 1, 15, 0, 22, -6, -22, 2, 2, 33};
        printArrayToRow(fourthArr);
        getMinMaxOfArray(fourthArr);
        System.out.println();

        System.out.println("*** Task 7 ***\n");
        int[] fiveArr = new int[]{2, 2, 2, 1, 2, 2, 10, 1};
        printArrayToRow(fiveArr);
        System.out.println();
        checkBalance(fiveArr);
        System.out.println();
        int[] sixArr = new int[]{1, 1, 1, 2, 1};
        printArrayToRow(sixArr);
        checkBalance(sixArr);
        System.out.println();
        int[] sevenArr = new int[]{5, 5, 5, 5, 5, 5, 5, 5};
        printArrayToRow(sevenArr);
        checkBalance(sevenArr);
        System.out.println();
        int[] eighthArr = new int[]{2, 3, 6, -2, 0, 4, 8, -12};
        printArrayToRow(eighthArr);
        checkBalance(eighthArr);
        System.out.println();

        System.out.println("*** Task 8 ***\n");
        int[] ninthArr = new int[]{3, 5, 7, 0, 8, 10, 12, -1};
        printArrayToRow(ninthArr);
        System.out.println("n = 3");
        printArrayToRow(moveArray(ninthArr,3));
        System.out.println();
        int[] tenthArr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        printArrayToRow(tenthArr);
        System.out.println("n = -2");
        printArrayToRow(moveArray(tenthArr,-2));
        System.out.println();

    }

    static int[] getBinaryArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int) Math.round(Math.random());
        }
        return arr;
    }

    static int[] invertBinaryArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) arr[i] = 1;
            else arr[i] = 0;
        }
        return arr;
    }

    static int[] setHundArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        return arr;
    }

    static int[] setDoubleSixArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) arr[i] *= 2;
        }
        return arr;
    }

    static int[][] getZeroSquareMatrix(int size) {
        int[][] arr = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                arr[i][j] = 0;
            }
        }
        return arr;
    }

    static int[][] setDiagonalsAtOnes(int[][] arr) {
        int size = arr.length;
        for (int i = 0; i < size; i++) {
            arr[i][i] = 1;
            arr[i][size - 1 - i] = 1;
        }
        return arr;
    }

    static int[] getValueArray(int len, int initialValue) {
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = initialValue;
        }
        return arr;
    }

    static void getMinMaxOfArray(int[] arr) {
        if (arr.length!=0) {
            int min = arr[0], max = arr[0];
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] > max) max = arr[i];
                if (arr[i] < min) min = arr[i];
            }
            System.out.println("min = "+min+", max = "+max);
        }
        else System.out.println("the array contains no elements!");
    }

    static boolean checkBalance(int[] arr) {
        if (arr.length!=0) {
                int leftSum = 0;
                int rightSum = 0;
            for (int i = 0; i < arr.length; i++) {
                String leftSide = "";
                String rightSide = "";
                for (int m = 0; m <= i; m++) {
                    leftSide += arr[m] + ", ";
                    leftSum += arr[m];
                }
                for (int n = i+1; n < arr.length; n++) {
                    rightSide += arr[n] + ", ";
                    rightSum += arr[n];
                }
            if (leftSum == rightSum) {
                System.out.println("[" + leftSide.replaceAll(", $", "") + " ||| " + rightSide.replaceAll(", $", "") + "]");
                System.out.println(true);
                return true;
            } else {
                leftSide = "";
                rightSide = "";
                leftSum = 0;
                rightSum = 0;
            }
            }
            System.out.println(false);
            return false;
        }
        else {
            System.out.println("the array contains no elements!");
            return false;
        }
    }

    static int[] moveArray(int[] arr, int n) {
        int size = arr.length;
        if (n > 0) {
            for (int count = 0; count < n; count++) {
                int buff = arr[size - 1];
                for (int i = size-1; i >= 1; i--) {
                    arr[i] = arr[i-1];
                }
                arr[0] = buff;
            }
        }
        if (n < 0) {
            for (int count = 0; count < Math.abs(n); count++) {
                int buff = arr[0];
                for (int i = 1; i <= size-1; i++) {
                    arr[i-1] = arr[i];
                }
                arr[size-1] = buff;
            }
        }
        return arr;
    }

    static void printArrayToRow(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    static void printDoubleArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            printArrayToRow(arr[i]);
        }
        System.out.println();
    }

}