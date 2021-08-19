import java.util.concurrent.ThreadLocalRandom;

/**
 * A simple random number generation utility. It uses ThreadLocalRandom, which is a smart way of generating a bunch of
 * random numbers almost simultaneously.
 *
 * @author Phil O'Connell (pxo4@psu.edu)
 */
public class Util {
    /**
     * A method that generates a random integer between the min and max, inclusive.
     *
     * @param min - The minumum number in the range of possible random integers.
     * @param max - The maximum number in the range of possible random integers.
     * @return randomInt - a random integer between min and max.
     * @author Phil O'Connell (pxo4@psu.edu)
     */
    static int generateRandomEvenInt(int min, int max) {
        /*
         * To get a random integer between 2 and 10, we get a random int
         * between 1 and 5 (inclusive), then double it.
         *
         * Since Random.nextInt(5) returns a random integer between 0 and 4
         * (inclusive), we add 1 to it.  That gets us between 1 and 5.
         *
         * Doubling that result will give us the random integer between 2 and 10.
         */
        int randomInt = 2 * ThreadLocalRandom.current().nextInt(min, max / 2 + 1);

        return randomInt;

    }
}
