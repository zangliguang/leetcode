package medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 950. Reveal Cards In Increasing Order
 * In a deck of cards, every card has a unique integer.  You can order the deck in any order you want.
 * <p>
 * Initially, all the cards start face down (unrevealed) in one deck.
 * <p>
 * Now, you do the following steps repeatedly, until all cards are revealed:
 * <p>
 * Take the top card of the deck, reveal it, and take it out of the deck.
 * If there are still cards in the deck, put the next top card of the deck at the bottom of the deck.
 * If there are still unrevealed cards, go back to step 1.  Otherwise, stop.
 * Return an ordering of the deck that would reveal the cards in increasing order.
 * <p>
 * The first entry in the answer is considered to be the top of the deck.
 */
public class RevealCardsInIncreasingOrder {
    public static void main(String[] args) {
//        2,13,3,11,5,17,7
        System.out.println(Arrays.toString(deckRevealedIncreasing(new int[]{17, 13, 11, 2, 3, 5, 7})));
    }

    public static int[] deckRevealedIncreasing2(int[] deck) {
        int n = deck.length;
        Arrays.sort(deck);
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) q.add(i);
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[q.poll()] = deck[i];
            q.add(q.poll());
        }
        return res;
    }

    public static int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        int[] result = new int[deck.length];
        boolean skip = false;
        for (int i = 0, j = 0; i < deck.length; j++) {
            if (result[j] == 0) {
                //only if the result[j] is not occupied
                if (!skip) {
                    //and if you dont have to skip it, then add it in result
                    result[j] = deck[i];
                    skip = true;
                    i++;
                } else {
                    //its to be skipped, ignore and move on but don't increment i
                    //we still need to place it in result!!
                    skip = false;
                }
            }

            if (j == deck.length - 1) {
                //reached end of result, rotate and come back to initial value and do the same
                j = 0;
            }
//            System.out.println("循环" + j + ":" + Arrays.toString(result));
        }
        return result;

    }
}
