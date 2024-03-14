public class Search {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(binarySearch(array, 5));
    }

    public static int binarySearch(int[] array, int numberToFind) {
        int low = 0; int high = array.length -1;
        while(low<=high){
            int mid = (low+high)/2;
            if(array[mid] == numberToFind){ return mid;
        }
            else if(numberToFind < mid){
                high = mid - 1;

            }
            low = mid + 1;
        }
        return -1;
    }
}
