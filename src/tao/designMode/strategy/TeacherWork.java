package tao.designMode.strategy;

public class TeacherWork implements WorkStrategy {
    @Override
    public void work() {
        System.out.println("teacher working");
    }
}
