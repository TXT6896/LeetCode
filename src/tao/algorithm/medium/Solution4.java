package tao.algorithm.medium;

/**
 * 7. 整数反转
 */
public class Solution4 {

    public static void main(String[] args) {
        int i  = 746384741;
        i = i*10;
        i = i/10;
        System.out.println(i);
        //System.out.println(Long.getLong("123",));
       //System.out.println(new Solution4().reverse(2147483647));
    }

    public int reverse(int x) {
/*        int result = 0;
        while(x != 0) {
            int tmp = result; // 保存计算之前的结果
            result = (result * 10) + (x % 10);
            x /= 10;
            if (result == 746384741){
                System.out.println("sai");
            }
            // 将计算之后的结果 / 10，判断是否与计算之前相同，如果不同，证明发生溢出，返回0
            if (result / 10 != tmp){
                System.out.println("hah");
                return 0;
            }
        }

        return result;*/
        String s = String.valueOf(x);
        if (s.length() == 1) return x;
        if (s.startsWith("-")) {
            StringBuilder sb = new StringBuilder(s.substring(1));
            sb = sb.reverse();
            while (sb.toString().startsWith("0")) {
                sb = new StringBuilder(sb.substring(1));
            }
            if (Long.parseLong("-" + sb) < (long) -2147483648) return 0;
            return Integer.parseInt("-" + sb);
        }
        StringBuilder sb = new StringBuilder(s);
        sb = sb.reverse();
        while (sb.toString().startsWith("0")) {
            sb = new StringBuilder(sb.substring(1));
        }
        if (Long.parseLong(sb.toString()) > (long) 2147483647) return 0;
        return Integer.parseInt(sb.toString());

    }
}
