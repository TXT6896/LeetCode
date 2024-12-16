package tao.interviewQuestion;

public class PrintImage {
    public static void main(String[] args) {
        print();
    }
    public static void print() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10 - i; j++) {
                int num = j;
                if (j == 5 - i - 1){
                    System.out.print("*");
                }  else {
                    System.out.print(" ");
                }
            }
            System.out.println("");
        }
    }
}
