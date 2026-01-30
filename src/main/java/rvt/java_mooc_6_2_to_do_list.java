package rvt;

import java.util.ArrayList;
import java.util.Scanner;

public class java_mooc_6_2_to_do_list {

    private ArrayList<String> tasks;

    public java_mooc_6_2_to_do_list() {
        this.tasks = new ArrayList<>();
    }

    public void add(String task) {
        this.tasks.add(task);
    }
    
    public void print(){

        for(int i=0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ": " + tasks.get(i));
        }
    }

    public void remove(int number) {

        if (number >= 1 && number <= tasks.size()) {
            tasks.remove(number - 1);
        }
    }
}


class UserInterface {
    private java_mooc_6_2_to_do_list list;
    private Scanner scanner;

    public UserInterface(java_mooc_6_2_to_do_list list, Scanner scanner) {
        this.list = list;
        this.scanner = scanner;
    }

    public void start() {
        while (true) {
            System.out.print("Command: ");
            String command = scanner.nextLine();

            if (command.equals("stop")) {
                break;
            } else if (command.equals("add")) {
                System.out.print("To add: ");
                String task = scanner.nextLine();
                list.add(task);
            } else if (command.equals("list")) {
                list.print();
            } else if (command.equals("remove")) {
                System.out.print("Which one is removed? ");
                int number = Integer.parseInt(scanner.nextLine());
                list.remove(number);
            }
        }
    }
}

class Main {

    public static void main(String[] args) {
        java_mooc_6_2_to_do_list list = new java_mooc_6_2_to_do_list();
        Scanner scanner = new Scanner(System.in);
        UserInterface ui = new UserInterface(list, scanner);
        ui.start();
    }
}