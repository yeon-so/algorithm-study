import java.util.Arrays;

public class Sort {

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
      }

    static void selectionSort(int[] arr) {
        int n = arr.length;

        for(int i = 0; i < n - 1; i++) {
            int maxIndex = i;
            for(int j = i + 1; j < n; j++) {
                if(arr[j] > arr[maxIndex]) {
                    maxIndex = j;
                }
            }

            swap(arr, i, maxIndex);
        }
    }

    static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped = false;

        for(int i = 0; i < n - 1; i++) {
            for(int j = i + 1; j < n - 1 - i; j++) {
                if(arr[j] < arr[j + 1]) {
                    swap(arr, j, j + 1);
                    swapped = true;
                }
            }
            // 이미 정렬되었을 경우 조기 종료
            if(!swapped) break;
        }

    }

    static void mergeSort(int[] arr, int left, int right) {
        if (left == right) return; // 배열의 크기가 1이면 종료

        int mid = (left + right) / 2;

        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right); // 정렬된 두 배열 병합
    }

    static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1; // 왼쪽 배열 크기
        int n2 = right - mid; // 오른쪽 배열 크기

        int[] L = new int[n1];
        int[] R = new int[n2];

        System.arraycopy(arr, left, L, 0, n1);
        System.arraycopy(arr, mid + 1, R, 0, n2);

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i] > R[j]) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }
        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }

    private static void quickSort(int[] arr, int start, int end) {
        if (start >= end) return;
        
        int pivot = start;
        int lo = start + 1;
        int hi = end;
        
        while (lo <= hi) { 
            while (lo <= end && arr[lo] >= arr[pivot]) lo++; // 피벗보다 큰 값 찾기
            while (hi > start && arr[hi] <= arr[pivot]) hi--; // 피벗보다 작은 값 찾기
            if (lo > hi) 
                swap(arr, hi, pivot); // 엇갈리면 피벗과 교체
            else
                swap(arr, lo, hi); // 엇갈리지 않으면 lo, hi 값 교체
        }
        
        quickSort(arr, start, hi - 1);
        quickSort(arr, hi + 1, end);
    }
    

    // 내림차순으로 정렬
    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11};
        //selectionSort(arr);
        //bubbleSort(arr);
        //mergeSort(arr, 0, arr.length - 1);
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
