import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //Задание 1
        int arr[] = new int[] {1,0,0,1,0,0,1,0,1,1};
        System.out.println(Arrays.toString(arr));
        zeroAndOne(arr);

        System.out.println();
        //Задание 2
        int empty_arr[] = new int[8];
        arrFill(empty_arr);

        System.out.println();
        //Задание 3
        int arr_2[] = new int[] {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println(Arrays.toString(arr_2));
        isSmallerSix(arr_2);

        System.out.println();
        //Задание 4
        int arr2d[][]  = new int[5][5];
        arr2dFill(arr2d);

        System.out.println();
        //Задание 5
        int random_arr[] = new int[(int)(Math.random()*(10))+8];
        for (int i = 0; i < random_arr.length; i++) {
            random_arr[i] = (int) (Math.random()*(10));
            System.out.printf("%3d", random_arr[i]);
        }
        searchMaxMin(random_arr);

        System.out.println();
        //Задание 6
        System.out.println(checkBalance(random_arr));

        System.out.println();
        //Задание 7
        massivePrint(arr_2);
        massiveMove(arr_2, -3);
        massivePrint(arr_2);
    }

    public static void zeroAndOne(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (arr[i] == 1)? 0: 1; //Фигурные скобки не ставлю -> условие только одно
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void arrFill(int[] arr) {
        for (int i=0, j=0; i<arr.length; i++,j+=3) //Фигурные скобки не ставлю -> цикл выполняет всего-лишь одно действие
            arr[i]=j;
        System.out.println(Arrays.toString(arr));
    }

    public static void isSmallerSix(int[] arr) {
        for (int i=0; i<arr.length; i++)
            if (arr[i]<6) arr[i]*=2;
        System.out.println(Arrays.toString(arr));
    }

    public static void arr2dFill(int[][] arr) {
        for (int i=0; i < arr.length ; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = (i + j == arr.length - 1 ||  i == j) ? 1 : 0;
                System.out.printf("%3d",arr[i][j]);
            }
            System.out.println();
        }
    }

    public static void searchMaxMin(int[] arr) {
        int max = arr[0];
        int min = arr[0];
        for (int i = 1; i < arr.length ; i++) {
            if (arr[i] < min) min = arr[i];
            if (arr[i] > max) max = arr[i];
        }
        System.out.println("\nMin = " + min + "\nMax = " + max);
    }

    public static boolean checkBalance(int[] arr) {
        int left=0;
        int right=0;
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i >= j) left += arr[j];
                else right += arr[j];
            }
            if (left==right) {
                System.out.print("[");
                for (int k = 0; k <= i; k++)
                    System.out.printf("%d, ", arr[k]);
                System.out.print("|| ");
                for (int k = i + 1; k < arr.length-1; k++)
                    System.out.printf("%d, ", arr[k]);
                System.out.printf("%d] ", arr[arr.length-1]);
                return true;
            }
            else { left=0; right=0;}
        }
        return false;
    }

    public static void massiveMove(int[] arr, int n) {
        if (n>arr.length) n=Math.abs(n%arr.length);
        if (n>0) {
            for (int i=0; i<n; i++) {
                int last = arr[arr.length - 1];
                for (int j = arr.length - 2; j >= 0; j--)
                    arr[j + 1] = arr[j];
                arr[0] = last;
            }
        }
        else if (n<0) {
            for (int i=0; i>n; i--) {
                int first = arr[0];
                for (int j = 0; j <= arr.length - 2; j++)
                    arr[j] = arr[j + 1];
                arr[arr.length-1] = first;
            }
        }
    }

    public static void massivePrint(int[] arr) {
        for (int i=0; i < arr.length ; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}
