package easy;

/**
 * 860. Lemonade Change
 * <p>
 * At a lemonade stand, each lemonade costs $5.
 * <p>
 * Customers are standing in a queue to buy from you, and order one at a time (in the order specified by bills).
 * <p>
 * Each customer will only buy one lemonade and pay with either a $5, $10, or $20 bill.  You must provide the correct change to each customer, so that the net transaction is that the customer pays $5.
 * <p>
 * Note that you don't have any change in hand at first.
 * <p>
 * Return true if and only if you can provide every customer with correct change.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [5,5,5,10,20]
 * Output: true
 * Explanation:
 * From the first 3 customers, we collect three $5 bills in order.
 * From the fourth customer, we collect a $10 bill and give back a $5.
 * From the fifth customer, we give a $10 bill and a $5 bill.
 * Since all customers got correct change, we output true.
 * Example 2:
 * <p>
 * Input: [5,5,10]
 * Output: true
 * Example 3:
 * <p>
 * Input: [10,10]
 * Output: false
 * Example 4:
 * <p>
 * Input: [5,5,10,10,20]
 * Output: false
 * Explanation:
 * From the first two customers in order, we collect two $5 bills.
 * For the next two customers in order, we collect a $10 bill and give back a $5 bill.
 * For the last customer, we can't give change of $15 back because we only have two $10 bills.
 * Since not every customer received correct change, the answer is false.
 */
public class LemonadeChange {
    public boolean lemonadeChange(int[] bills) {

//无序
        int five = 0, ten = 0;
        for (int i : bills) {
            if (i == 5) five++;
            else if (i == 10) {
                five--;
                ten++;
            } else if (ten > 0) {
                ten--;
                five--;
            } else five -= 3;
            if (five < 0) return false;
        }
        return true;


        //   有序 return canSell(bills, 0, 0, 0);


    }


    private boolean canSell(int[] bills, int five, int ten, int index) {
        for (int i = index; i < bills.length; i++) {
            int bill = bills[i];
            if (bill == 5) {
                five++;
                continue;
            }
            if (bill == 10) {
                if (five > 0) {
                    five--;
                    ten++;
                    continue;
                } else {
                    return false;
                }
            }
            if (bill == 20) {
                if (five == 0 || (five * 5 + ten * 10) < 20) {
                    return false;
                } else {
                    if (ten == 0) {
                        return canSell(bills, five - 3, ten, i + 1);
                    }
                    if (five < 3) {
                        return canSell(bills, five - 1, ten - 1, i + 1);
                    }
                    return canSell(bills, five - 3, ten, i + 1) || canSell(bills, five - 1, ten - 1, i + 1);
                }
            }

        }
        return true;
    }
}
