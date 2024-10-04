package tao.designMode.proxy;

/**
 * 目标类
 */
public class Student implements Persion{

    @Override
    public void talk() {
        System.out.println("俺是学生");
    }

    @Override
    public void sing() {
        System.out.println("我唱七里香");
    }
}
