public class Solution {
    public static void main(String []args) {
        int []prices = {1,3,2,4,5,7,4,8};
        Method m = new Method();
        System.out.println(m.maxPrice(prices,0));
    }
}

class Method {

    public int state = 0;//没买

    public int startPrice;

    public int sum = 0;

    public int maxPrice(int []prices, int i) {

        if( i == prices.length - 1) { //最后一天还有库存,肯定应该卖
            if(state == 1) {
                sum += prices[i] - startPrice;
            }
            log(i,prices);
            return sum;
        }

        if(prices[i] < prices[i + 1] && state == 0) { //明天涨价，现在没有库存，买
            state = 1;
            startPrice = prices[i];
            log(i,prices);
            return maxPrice(prices, i + 1);
        }

        if(prices[i] > prices[i + 1] && state == 1) { //明天降价，现在有库存，卖
            state = 0;
            sum += (prices[i] - startPrice);
            log(i,prices);
            return maxPrice(prices, i + 1);
        }

        log(i,prices);
        return maxPrice(prices, i + 1);//明天不涨价也不讲价，不管手里有没有，维持现状
    }

    public void log(int i,int []prices) {
        System.out.println(startPrice + " "+ prices[i] + " " + sum + " " + i + " " + state);
    }
}