package n02_divide_and_conquer;

public class P0278FirstBadVersion {
    private int N, bad;

    public P0278FirstBadVersion(int N, int bad)
    {
        this.N = N;
        this.bad = bad;
    }

    private boolean isBadVersion(int n)
    {
        return n >= this.bad;
    }


    public int firstBadVersion(int n)  // Check how this solution is different from others.
    {
        int start = 1;
        int end = n;
        int mid;

        while (start < end)
        {
            mid = start + (end - start) / 2;

            if (isBadVersion(mid))
                end = mid;
            else
                start = mid + 1;
        }

        return start;
    }

//    public int firstBadVersion(int n)
//    {
//        int start = 1;
//        int end = n;
//        int mid;
//
//        while (true)
//        {
//            if (start > end)
//                return 0;
//
//            if (isBadVersion(start))
//                return start;
//
//            //mid = (start + end) / 2;  This will overflow for very large values
//            mid = start + (end - start) / 2;
//            System.out.println(mid);
//
//            if (isBadVersion(mid))
//            {
//                if (!isBadVersion(mid - 1))
//                    return mid;
//                end = mid - 1;
//            }
//            else
//                start = mid + 1;
//        }
//
//        /*
//        public int firstBadVersion(int n)
//        {
//            int left = 1;
//            int right = n;
//            while (left < right) {
//                int mid = left + (right - left) / 2;
//                if (isBadVersion(mid)) {
//                    right = mid;
//                } else {
//                    left = mid + 1;
//                }
//            }
//            return left;
//        }
//         */
//    }

    public static void main(String[] args) {
        int N = 12324234;
        int bad = 15;

        P0278FirstBadVersion obj = new P0278FirstBadVersion(N, bad);

        System.out.println("Output: "
                + obj.firstBadVersion(N));
    }
}
