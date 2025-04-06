public class NextGreaterElement {
    public static void main(String args[]) {
        int arr[] = {6, 8, 1, 4, 3, 7, 2};
        for (int i = 0; i < arr.length; i++) {
            boolean found = false;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > arr[i]) {
                    arr[i] = arr[j];
                    found = true;
                    break;
                }
            }
            if (!found) {
                arr[i] = -1;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
