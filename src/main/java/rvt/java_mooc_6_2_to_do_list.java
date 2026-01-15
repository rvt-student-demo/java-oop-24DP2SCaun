package rvt;

import java.util.ArrayList;

public class java_mooc_6_2_to_do_list {

    private ArrayList<String> tasks;

    public java_mooc_6_2_to_do_list() {
        this.tasks = new ArrayList<>();
    }

    public void add(String task) {
        this.tasks.add(task);
    }
    
    public void print(){

        for(int i=0; i < this.tasks.size(); i++) {
            System.out.println((i + 1) + ": " + this.tasks.get(i));
        }
    }

    public void remove(int number) {

        int index = number - 1;
        if (index >= 0 && index < this.tasks.size()) {
            this.tasks.remove(index);
        }
    }
}