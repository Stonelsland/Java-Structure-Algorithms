public class SparseArray {

    public static void main(String[] args) {
        //创建二维数组
        int chessArr1[][] = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        chessArr1[4][5] = 1;
        chessArr1[3][3] = 2;
        for (int[] row:chessArr1){
            for (int data:row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }

        //将二维数组转换为稀疏数组
        //
        int sum = 0;
        for (int i = 0; i <11 ; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr1[i][j] != 0){
                    sum++;
                }
            }
        }
        //创建对应稀疏数组
        int sparseArray[][] = new int[sum+1][3];
        sparseArray[0][0] =11;
        sparseArray[0][1] =11;
        sparseArray[0][2] =sum;

        //遍历二维数组将非零数据存入稀疏数组
        int count = 0;//记录非零数据个数
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr1[i][j] !=0){
                    count++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = chessArr1[i][j];
                }
            }
        }
        System.out.println();
        System.out.println("得到的稀疏数组为======");
        for (int i = 0; i < sparseArray.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n",sparseArray[i][0],sparseArray[i][1],sparseArray[i][2]);
        }
        System.out.println();

        //将稀疏数组恢复为二维数组
        /*
         * 1.先读取稀疏数组第一行，根据第一行数据创建原始二位数组；
         * 2.读取稀疏数组后几行数据，并赋给原始的二位数组即可
         */
        //1.
        int chessArr2[][] = new int[sparseArray[0][0]][sparseArray[0][1]];
        //2.
        for (int i = 1; i < sparseArray.length; i++) {
            chessArr2[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }
        System.out.println();
        System.out.println("输出恢复后的二维数组");
        for (int[] row:chessArr2){
            for (int data:row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }

    }
}