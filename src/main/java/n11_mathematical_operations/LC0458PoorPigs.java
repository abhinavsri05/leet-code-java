package n11_mathematical_operations;

public class LC0458PoorPigs
{
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest)
    {
        /*
        There are total of n = minutesToTest / minutesToDie rounds of trials.
        Each round will result in a pig being dead or alive.
        An alive pig can be used in next round as well

        So for a pig there are total of (n + 1) states possible.
            Alive,
            Dead after 1st round
            Dead after 2nd round
            ...
            Dead after nth round

        Total states for p pigs = (n + 1).(n + 1). ... . (n + 1) = (n + 1) ^ p

        Note that the states are nothing but how many ways we can feed the pigs. This is equal to the number of buckets

        Therefore, we need to find smallest p such that

        (n + 1) ^ p >= buckets
        p >= log(buckets) / log (n + 1)

        min p = Ceil (log(buckets) / log (n + 1))

        If log(buckets) / log (n + 1) = 2.5 then p = 3

        */
        return (int) Math.ceil(Math.log(buckets) / Math.log((minutesToTest / minutesToDie) + 1));
    }
}
