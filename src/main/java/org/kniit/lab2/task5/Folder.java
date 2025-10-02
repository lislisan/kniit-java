package org.kniit.lab2.task5;

import java.util.ArrayList;
import java.util.List;


class Folder implements FileSystemComponent {
    private String name;
    private List<FileSystemComponent> components = new ArrayList<>();

    public Folder(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getSize(){
        double totalSize = 0;
        for (FileSystemComponent component : components){
            totalSize += component.getSize();
        }
        return totalSize;
    }

    @Override
    public void add(FileSystemComponent component) {
        components.add(component);
    }

    @Override
    public void remove(FileSystemComponent component) {
        components.remove(component);
    }

    @Override
    public void display(String indent) {
        System.out.println(indent + name);
        for (FileSystemComponent component : components) {
            component.display(indent + "  "); // Рекурсивно отображаем вложенные элементы
        }
    }
}
