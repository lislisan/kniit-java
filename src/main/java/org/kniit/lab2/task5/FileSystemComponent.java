package org.kniit.lab2.task5;

public interface FileSystemComponent {
    String getName();
    double getSize();
    void add(FileSystemComponent component);
    void remove(FileSystemComponent component);
    void display(String indent);
}
