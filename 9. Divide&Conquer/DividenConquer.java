public class DividenConquer {
    public static void printArray(int arr[]) {
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void mergeSort(int arr[], int si, int ei) {
        if(si >= ei) {
            return;
        }
        //kaam
        int mid = si + (ei-si)/2;
        mergeSort(arr, si, mid);
        mergeSort(arr, mid+1, ei);
        merge(arr, si, mid, ei);
    }

    public static void merge(int arr[], int si, int mid, int ei) {
        int temp[] = new int[ei-si+1];
        int i = si;
        int j = mid+1;

        int k = 0;

        while(i <= mid && j <= ei) {
            if(arr[i] < arr[j]) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }

        while(i <= mid) {
            temp[k++] = arr[i++];
        }

        while(j <= ei) {
            temp[k++] = arr[j++];
        }

        for(k = 0, i = si; k < temp.length; i++, k++) {
            arr[i] = temp[k];
        }
    }

    public static void quickSort(int arr[], int si, int ei) {
        if(si >= ei) {
            return;
        }
        //kaam
        int pIdx = partiton(arr, si, ei);
        quickSort(arr, si, pIdx-1); //left
        quickSort(arr, pIdx+1, ei); //right
    }

    public static int partiton(int arr[], int si, int ei) {
        int pivot = arr[ei];
        int i = (si-1);
       
        for(int j = si; j < ei; j++) {
            if(arr[j] < pivot) {
                i++;
                //swap
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        i++;
        int temp = pivot;
        arr[ei] = arr[i];
        arr[i] = temp;
        return i;
    }

    public static int search(int arr[], int target, int si, int ei) {
        if(si > ei) {
            return -1;
        }
        //kaam
        int mid = si + (ei-si)/2;

        //FOUND
        if(arr[mid] == target) {
            return mid;
        }

        //L1
        if(arr[si] <= arr[mid]) {
            //case: a
            if(arr[si] <= target && target <= arr[mid]) {
                return search(arr, target, si, mid-1);
            }

            else {
                return search(arr, target, mid+1, ei);
            }
        }

        //L2
        else {
            if(arr[mid] <= target && target <= arr[ei]) {
                return search(arr, target, mid+1, ei);
            }

            else {
                return search(arr, target, si, mid-1);
            }
        }
    }

    public static int searchIterate(int arr[], int target) {
        int si = 0;
        int ei = arr.length;
       
        while(si <= ei) {
            int mid = si + (ei-si)/2;
            if(arr[mid] == target) {
                return mid;
            }

            if(arr[si] <= arr[mid]) {
                if(arr[si] <= target && target <= arr[mid]) {
                    ei = mid-1;
                }

                else {
                    si = mid+1;
                }
            }

            else {
                if(arr[mid] <= target && target <= arr[ei]) {
                    si = mid+1;
                }

                else {
                    ei = mid-1;
                }
            }
        }

        return -1;
        
    }

    public static void mergeSortOnString(String arr[], int si, int ei) {
        if(si >= ei) {
            return;
        }
        int mid = si + (ei-si)/2;
        mergeSortOnString(arr, si, mid);
        mergeSortOnString(arr, mid+1, ei);
        mergeString(arr, si, mid, ei);
    }

    public static void mergeString(String arr[], int si, int mid, int ei) {
        String temp[] = new String[ei-si+1];
        int i = si;
        int j = mid+1;

        int k = 0;

        while(i <= mid && j <= ei) {
            if(arr[i].compareTo(arr[j]) < 0) {
                temp[k] = arr[i];
                i++;
            }
            else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }

        while(i <= mid) {
            temp[k++] = arr[i++];
        }

        while(j <= ei) {
            temp[k++] = arr[j++];
        }

        for(k = 0, i = si; k < temp.length; i++, k++) {
            arr[i] = temp[k];
        }
    }

   

    public static void printStrArray(String arr[]) {
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    
    public static void main(String[] args) {
    //    String arr[] = {"sun", "earth", "mars", "mercury"};
        
    }
}
