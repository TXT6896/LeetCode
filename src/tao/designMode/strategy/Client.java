package tao.designMode.strategy;

public class Client {

    public static void main(String[] args) {
        WorkStrategy strategy = StragegyFactory.build("2");
        strategy.work();
    }
}
