package org.kniit.lab2.task5;


class File implements FileSystemComponent {
    private String name;
    private double size;

    public File(String name, double size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public String getName() {return name; } // почему это в {} скобках?

    @Override
    public double getSize() {return size; }

    @Override
    public void add(FileSystemComponent component) {
        throw new UnsupportedOperationException("Файл не может содержать другие элементы");
    }

    @Override
    public void remove(FileSystemComponent component) {
        throw new UnsupportedOperationException("Файл не может удалять другие элементы");
    }

    @Override
    public void display(String indent) {
        System.out.println(indent + name + " (" + size + " bytes)");
    }
}
