package org.kniit.lab1.task2;

public class SimpleUrl {
    private String protocol;
    private String address;
    private String domainZone;
    private String siteName;
    private String webpageName;
    private String webPageExtention;

    public void setProtocol(String protocol1) {
        protocol = protocol1;
    }
    public void setAddress(String address1) {
        address = address1;
    }
    public void setDomainZone(String domainZone1) {
        domainZone = domainZone1;
    }
    public void setSiteName(String siteName1) {
        siteName = siteName1;
    }
    public void setWebpageName(String webpageName1) {
        webpageName = webpageName1;
    }
    public void setWebPageExtention(String webPageExtention1) {
        webPageExtention = webPageExtention1;
    }

    @Override
    public String toString() {
        return "protocol = " + protocol + "\n" +
                "address = " + address + "\n" +
                "domainZone = " + domainZone + "\n" +
                "siteName = " + siteName + "\n" +
                "webpageName = " + webpageName + "\n" +
                "webPageExtention = " + webPageExtention + "\n";
    }
}
