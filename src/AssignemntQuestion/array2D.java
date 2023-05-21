package AssignemntQuestion;

public class array2D {
    public static int no_times(int array[][]){
        int count = 0;
        for (int i = 0;i<array.length;i++){
            for(int j = 0 ;j<array[0].length;j++){
                if(array[i][j] == 7 ){
                    count++;
                }
            }
        }
        return count;
    }

    public static int sum(int array[][]){
        int count = 0;

            for (int j = 0;j< array[0].length;j++){

                    count = count+array[1][j];

            }
            return count;

    }

    public static void transpose(int arr[][]){
        //we have to interchange the row and colume
        int row = 2;
        int col = 3;

        int[][] transpose = new int[col][row];
        for(int i = 0;i<row;i++){
            for (int j = 0 ;j<col ;j++){
                transpose[j][i] = arr[i][j];

            }
        }

        for (int i = 0;i<transpose.length ;i++){
            for (int j = 0;j<transpose[0].length;j++){
                System.out.print(transpose[i][j] + " ");
            }
            System.out.println();
        }
    }



    public static void main(String[] args) {


//        int[][] array = { {4,7,8},{8,8,7} };
        int[][] nums = { {1,4,9},{11,4,3},{2,2,3} };
//        System.out.println(no_times(array));
//        System.out.println(sum(nums));
        int[][] matrix = { {2, 3, 7}, {5, 6, 7} };
        transpose(matrix);




    }
}
