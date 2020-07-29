package medium;

import java.util.Stack;

/**
 * 901. Online Stock Span
 */
public class OnlineStockSpan {
    Stack<int[]> s;

    public OnlineStockSpan() {
        s = new Stack<>();
    }

    public int next(int price) {

        int res=1;
        while (!s.empty()&&s.peek()[0]<=price){
            res+=s.pop()[1];
        }
        s.push(new int[]{price,res});


        return res;
    }
}
