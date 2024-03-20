import java.util.Arrays;

public class Sort {

    public static void main(String[] args) {
        int[] array = {4, 7, 2, 6, 9, 0, 1, 3, 5, 8};
       // bubbleSort(array);
       // System.out.println("bubble sort " + Arrays.toString(array));
       // quickSort(array, 0, array.length - 1);
       // System.out.println("quick sort " + Arrays.toString(array));
        mergeSort(array);
        System.out.println("merge sort " + Arrays.toString(array));
    }

    public static void bubbleSort(int[] array) {
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 1; i < array.length; i++) {
                if (array[i] < array[i - 1]) {

                    int temp = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = temp;
                    isSorted = false;
                }
            }
        }
    }


    public static void quickSort(int[] array, int lowIndex, int highIndex) {
        if (lowIndex < highIndex) {

            int leftPointer = lowIndex;
            int pivot = array[highIndex];
            int rightPointer = highIndex;

            while (leftPointer < rightPointer) {
                while (array[leftPointer] <= pivot && leftPointer < rightPointer) {
                    leftPointer++;
                }

                while (array[rightPointer] > pivot && leftPointer < rightPointer) {
                    rightPointer--;
                }

                int temp = array[leftPointer];
                array[leftPointer] = array[rightPointer];
                array[rightPointer] = temp;
            }

            int temp = array[leftPointer];
            array[leftPointer] = array[highIndex];
            array[highIndex] = temp;

            quickSort(array, lowIndex, leftPointer - 1);
            quickSort(array, leftPointer + 1, highIndex);
        }


    }

    public static void mergeSort(int[] array) {
        int inputLength = array.length;

        if (inputLength < 2) {
            return;
        }

        int midIndex = inputLength / 2;
        int[] leftArray = new int[midIndex];
        int[] rightArray = new int[inputLength - midIndex];

        for (int i = 0; i < midIndex; i++) {
            leftArray[i] = array[i];
        }

        for (int i = midIndex; i < inputLength; i++) {
            rightArray[i - midIndex] = array[i];
        }

        mergeSort(leftArray);
        mergeSort(rightArray);
        //merge

        merge(array, leftArray, rightArray);
    }

    public static void merge(int[] array, int[] leftHalf, int[] rightHalf) {
        int leftSize = leftHalf.length;
        int rightSize = rightHalf.length;

        int l = 0, r = 0, m = 0;


        //looping until
        //we run out of elements in the left array
        //or we run out of elements on the right array

        while (l < leftSize && r < rightSize) {
            //here what we actually want to do is
            //compare the l'th
            //element of the left half with the r'th
            //element of the right half

            if(leftHalf[l] <=  rightHalf[r]) {
                array[m] = leftHalf[l];
                l++;
            } else {
                array[m] = rightHalf[r];
                r++;
            }
            m++;
            // we added the smallest element  to  the merge array
        }
        //now we need to add the remaining elements from the bought halfs
        while (l < leftSize) {
            array[m] = leftHalf[l];
            l++;
            m++;
        }

        while (r < rightSize) {
            array[m] = rightHalf[r];
            r++;
            m++;
        }
    }

}

