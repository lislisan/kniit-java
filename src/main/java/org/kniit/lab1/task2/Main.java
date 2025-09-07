package org.kniit.lab1.task2;

public class Main {
    public static void main(String[] args) {
        SimpleUrl simpleurl = new SimpleUrl();

        simpleurl.setProtocol("https");
        simpleurl.setAddress("test.ru");
        simpleurl.setDomainZone("ru");
        simpleurl.setSiteName("test");
        simpleurl.setWebpageName("page.jsp");
        simpleurl.setWebPageExtention("jsp");

        System.out.println(simpleurl);
    }
}
