package tao.designMode.strategy;

public class DoctorWork implements WorkStrategy {
    @Override
    public void work() {
        System.out.println("Doctor working");
    }
}
