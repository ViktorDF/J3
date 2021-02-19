package l6;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 4, 2, 3, 4, 1, 7};
        int[] y = {0,2,5,6,3,5,6,8};
        int[] aaa = {1,4,1,4,1,4};
        int[] bbb = {2,3,5};


        for (int i = 0; i < checkArray(arr).length; i++) {
            System.out.print(checkArray(arr)[i]);
            System.out.print(" ");
        }
        System.out.println();

        for (int i = 0; i < checkArray(aaa).length; i++) {
            System.out.print(checkArray(aaa)[i]);
            System.out.print(" ");
        }
        System.out.println();

        System.out.println(checkArray2(arr));
        System.out.println(checkArray2(y));
        System.out.println(checkArray2(aaa));
        System.out.println(checkArray2(bbb));

    }

    public static int[] checkArray(int[] arr) {
        int x = 0;
        int [] result = null;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 4) {
                x = arr[i];
                result = new int[arr.length - i - 1];
                for (int j = i + 1, k = 0; j < arr.length; j++, k++) {
                    if (arr[j] == 4) continue;
                    result[k] = arr[j];
                }
            }
        }
        try{
            x = 1 / x;
        } catch(ArithmeticException e){
            throw new RuntimeException();
        }
        return result;
    }

    public static boolean checkArray2(int[] arr){

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] != 1 && arr[i] != 4) return false;
        }
        return true;
    }
}
