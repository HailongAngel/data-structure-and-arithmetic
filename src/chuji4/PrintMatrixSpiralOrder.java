package chuji4;

/**
 * @program: idea代码
 * @description: 转圈打印矩阵
 * @author: Hailong
 * //整体思路：如果在同一行或者同一列就一直加上去
//否则，找两个点固定按照左->右；右->下;下->左；左->上
 * @create: 2018-08-29 22:59
 **/
public class PrintMatrixSpiralOrder {
    public static void spiralOrderPrint(int[][] matrix) {
        int tR = 0;
        int tC = 0;
        int dR = matrix.length - 1;
        int dC = matrix[0].length - 1;
        while (tR <= dR && tC <= dC) {//左上角的行小于等于右下角的行，左下角的列小于等于右下角的列
            printEdge(matrix, tR++, tC++, dR--, dC--);
        }
    }

    public static void printEdge(int[][] m, int tR, int tC, int dR, int dC) {
        if (tR == dR) {//左上角的行和右下角的行在同一行
            for (int i = tC; i <= dC; i++) {//左上角的列一直加到右下角的列
                System.out.print(m[tR][i] + " ");
            }
        } else if (tC == dC) {//左上角的列和右下角的列在同一列
            for (int i = tR; i <= dR; i++) {//左上角的行加到右下角的行
                System.out.print(m[i][tC] + " ");
            }
        } else {
            int curC = tC;
            int curR = tR;
            while (curC != dC) {
                System.out.print(m[tR][curC] + " ");
                curC++;
            }
            while (curR != dR) {
                System.out.print(m[curR][dC] + " ");
                curR++;
            }
            while (curC != tC) {
                System.out.print(m[dR][curC] + " ");
                curC--;
            }
            while (curR != tR) {
                System.out.print(m[curR][tC] + " ");
                curR--;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        spiralOrderPrint(matrix);

    }

}

