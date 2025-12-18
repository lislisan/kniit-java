package org.kniit.lab11.task25;

public class FileInfo {
    private int id;
    private String fileName;

    public FileInfo(int id, String fileName) {
        this.id = id;
        this.fileName = fileName;
    }

    public int getId() { return id; }
    public String getFileName() { return fileName; }

    @Override
    public String toString() {
        return id + ": " + fileName;
    }
}
