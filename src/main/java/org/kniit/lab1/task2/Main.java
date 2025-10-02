package org.kniit.lab1.task2;

public class Main {
    public static void main(String[] args) {
        String webpage = "https://test.ru/test/1072/page.jsp?intParam=12345&doubleParam=3.14&textParameter=someText";

        SimpleUrl simpleUrl = new SimpleUrl();

        String[] mainParts = webpage.split("://");
        simpleUrl.setProtocol(mainParts[0]); // https

        String afterProtocol = mainParts[1];

        String[] addressAndPath = afterProtocol.split("/", 2);
        simpleUrl.setAddress(addressAndPath[0]); // test.ru

        String[] domainParts = simpleUrl.getAddress().split("\\.");
        simpleUrl.setSiteName(domainParts[0]); // test
        simpleUrl.setDomainZone(domainParts[1]); // ru

        if (addressAndPath.length > 1) {
            String pathAndParams = addressAndPath[1];

            String[] pathAndQuery = pathAndParams.split("\\?", 2);
            String path = pathAndQuery[0];

            String[] pathParts = path.split("/");
            String fileName = pathParts[pathParts.length - 1]; // page.jsp
            simpleUrl.setWebpageName(fileName);

            String[] nameParts = fileName.split("\\.");
            simpleUrl.setWebPageExtention(nameParts[1]); // jsp

            if (pathAndQuery.length > 1) {
                String paramsString = pathAndQuery[1]; // intParam=12345&doubleParam=3.14&textParameter=someText
                String[] params = paramsString.split("&");

                for (String param : params) {
                    String[] keyValue = param.split("=");
                    if (keyValue.length == 2) {
                        switch (keyValue[0]) {
                            case "intParam":
                                simpleUrl.setIntParam(keyValue[1]);
                                break;
                            case "doubleParam":
                                simpleUrl.setDoubleParam(keyValue[1]);
                                break;
                            case "textParameter":
                                simpleUrl.setTextParameter(keyValue[1]);
                                break;
                        }
                    }
                }
            }
        }

        System.out.println(simpleUrl);
    }
}

