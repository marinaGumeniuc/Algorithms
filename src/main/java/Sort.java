import java.util.Arrays;

public class Sort {

    public static void main(String[] args) {
        int[] array = {4,7,2,6,9,0,1,3,5,8};
        bubbleSort(array);
        System.out.println("bubble sort" + Arrays.toString(array));
        quickSort(array, 0, array.length - 1);
        System.out.println("quick sort" + Arrays.toString(array));
    }

    public static void bubbleSort(int[] array) {
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for(int i = 1; i < array.length; i++){
                if(array[i] < array[i-1]){

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

    }

