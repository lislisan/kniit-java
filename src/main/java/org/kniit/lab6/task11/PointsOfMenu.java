package org.kniit.lab6.task11;

import java.util.TreeSet;
import java.util.Scanner;

public class PointsOfMenu {
    private int numOfMenu;
    private String resultOf;
    private TreeSet<String> students;
    private Scanner scanner;

    public PointsOfMenu(int input, TreeSet<String> students, Scanner scanner){
        this.numOfMenu = input;
        this.students = students;
        this.scanner = scanner;
        processFor(numOfMenu);
    }

    public String getResultOf(){
        return resultOf;
    }

    private void processFor(int numOfMenu){
        switch(numOfMenu) {
            case 1:
                addStudent();
                break;
            case 2:
                removeStudent();
                break;
            case 3:
                showAllStudents();
                break;
            case 4:
                findStudent();
                break;
            default:
                System.out.println("Нет такого пункта. Выберите от 1 до 5.");
        }
    }

    private void addStudent() {
        System.out.print("Введите ФИО студента: ");
        String name = scanner.nextLine().trim();

        if(name.isEmpty()) {
            resultOf = "Вы ничего не ввели";
        } else if(students.contains(name)) {
            resultOf = "Ошибка: студент '" + name + "' уже существует";
        } else {
            students.add(name);
            resultOf = "Студент '" + name + "' добавлен";
        }
        System.out.println(resultOf);
    }

    private void removeStudent() {
        if(students.isEmpty()) {
            resultOf = "Список студентов пуст";
            System.out.println(resultOf);
            return;
        }

        System.out.print("Введите ФИО студента для удаления: ");
        String name = scanner.nextLine().trim();

        if(students.remove(name)) {
            resultOf = "Студент '" + name + "' успешно удален";
        } else {
            resultOf = "Студент '" + name + "' не найден";
        }
        System.out.println(resultOf);
    }

    private void showAllStudents() {
        if(students.isEmpty()) {
            resultOf = "Список студентов пуст";
            System.out.println(resultOf);
            return;
        }

        System.out.println("\n📎 СПИСОК СТУДЕНТОВ ");
        int counter = 1;
        for(String student : students) {
            System.out.println(counter + ". " + student);
            counter++;
        }
        resultOf = "Всего студентов: " + students.size();
        System.out.println(resultOf);
    }

    private void findStudent() {
        if(students.isEmpty()) {
            resultOf = "Список студентов пуст!";
            System.out.println(resultOf);
            return;
        }

        System.out.print("Введите имя студента для поиска: ");
        String name = scanner.nextLine().trim();

        if(students.contains(name)) {
            resultOf = "Студент '" + name + "' найден";
        } else {
            resultOf = "Студент '" + name + "' не найден";
        }
        System.out.println(resultOf);
    }
}