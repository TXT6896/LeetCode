package tao.easy;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Student implements Cloneable {
    public static void main(String[] args) {
        System.out.println(Long.valueOf("123"));
    }
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}
