package ru.nsu.izhuravskii;

public class heapsort_tests {
    public static void main(String[] args) {
        int[] arr_correct = {0, 1, 2, 3, 4, 5};
        int[] arr_incorrect = {1, 5, 0, 2, 4, 3};

        heapsort ob = new heapsort();
        ob.sort(arr_incorrect);

        for (int i = 0; i < 6; i++) {
            assert (arr_incorrect[i] == arr_correct[i]);
        }
    }

    static {
        int[] arr_correct = {0, 0, 0, 0, 0, 0};
        int[] arr_incorrect = {0, 0, 0, 0, 0, 0};

        heapsort ob = new heapsort();
        ob.sort(arr_incorrect);

        for (int i = 0; i < 6; i++) {
            assert (arr_incorrect[i] == arr_correct[i]);
        }
    }

    static {
        int[] arr_correct = {0};
        int[] arr_incorrect = {0};

        heapsort ob = new heapsort();
        ob.sort(arr_incorrect);

        for (int i = 0; i < 1; i++) {
            assert (arr_incorrect[i] == arr_correct[i]);
        }
    }

    static {
        int[] arr_correct = {-2, -1, 0, 1, 2, 3};
        int[] arr_incorrect = {0, -2, 1, 3, 2, -1};

        heapsort ob = new heapsort();
        ob.sort(arr_incorrect);

        for (int i = 0; i < 6; i++) {
            assert (arr_incorrect[i] == arr_correct[i]);
        }
    }

}
