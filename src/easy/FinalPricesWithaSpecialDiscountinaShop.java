package easy;

import java.util.Stack;

/**
 * 1475 Final Prices With a Special Discount in a Shop
 */
public class FinalPricesWithaSpecialDiscountinaShop {
    public int[] finalPrices(int[] prices) {
        int[] result = new int[prices.length];
        Stack<Integer> st = new Stack();
        for (int i = prices.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() > prices[i]) {
                st.pop();
            }
            result[i] = prices[i] - (st.isEmpty() ? 0 : st.peek());

            st.push(prices[i]);

        }
        return result;
    }
}
