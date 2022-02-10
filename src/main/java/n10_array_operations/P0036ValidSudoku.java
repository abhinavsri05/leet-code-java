package n10_array_operations;

public class P0036ValidSudoku {
//    public boolean isValidSudoku(char[][] board)
//    {
//        boolean[] values;
//        int boardVal;
//        int i, j, row, col;
//
//        // rows
//
//        for (row = 0; row < 9; row++)
//        {
//            values = new boolean[9];
//            for (col = 0; col < 9; col++)
//            {
//                if (board[row][col] != '.')
//                {
//                    boardVal = board[row][col] - '1';
//                    if (values[boardVal])
//                        return false;
//                    values[boardVal] = true;
//                }
//            }
//
//        }
//
//        // columns
//
//        for (col = 0; col < 9; col++)
//        {
//            values = new boolean[9];
//            for (row = 0; row < 9; row++)
//            {
//                if (board[row][col] != '.')
//                {
//                    boardVal = board[row][col] - '1';
//                    if (values[boardVal])
//                        return false;
//                    values[boardVal] = true;
//                }
//            }
//
//        }
//
//        // blocks
//
//        for (i = 0; i < 3; i++)
//        {
//            for (j = 0; j < 3; j++)
//            {
//                values = new boolean[9];
//                for (row = i * 3; row < (i + 1) * 3; row++)
//                {
//                    for (col = j * 3; col < (j + 1) * 3; col++)
//                    {
//                        if (board[row][col] != '.')
//                        {
//                            boardVal = board[row][col] - '1';
//                            if (values[boardVal])
//                                return false;
//                            values[boardVal] = true;
//                        }
//                    }
//                }
//            }
//        }
//        return true;
//    }

    public boolean isValidSudoku(char[][] board)
    {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] blocks = new boolean[9][9];

        int boardVal;
        int blk, row, col;


        for (row = 0; row < 9; row++)
        {

            for (col = 0; col < 9; col++)
            {
                if (board[row][col] != '.')
                {
                    boardVal = board[row][col] - '1';

                    // row
                    if (rows[row][boardVal]) return false;
                    rows[row][boardVal] = true;

                    // col
                    if (cols[col][boardVal]) return false;
                    cols[col][boardVal] = true;

                    //block
                    blk = 3 * (row / 3) + col / 3;
                    if (blocks[blk][boardVal]) return false;
                    blocks[blk][boardVal] = true;
                }
            }

        }
        return true;
    }


}
