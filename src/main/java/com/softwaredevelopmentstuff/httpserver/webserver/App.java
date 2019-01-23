package com.softwaredevelopmentstuff.httpserver.webserver;

import java.io.PrintWriter;

class App {
    static String getPortalName() {
        return System.getProperty("APP_NAME");
    }

    static String getPort() {
        return System.getProperty("PORT");
    }

    static String getOtherPortalAddress() {
        return System.getProperty("OTHER_PORTAL_ADDRESS");
    }

    static String getTheme() {
        return getPortalName().contains("Purchase") ? "btn-primary" : "btn-success";
    }

    static void renderBeginOfPage(PrintWriter writer, String title) {
        writer.println("<!DOCTYPE html><html><head>");
        writer.println("<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\" integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">\n");
        writer.println("<title>" + title + "</title>");
        writer.println("</head><body>");
        writer.println("<nav class=\"navbar navbar-dark " + getTheme() + "\">");
        writer.println("<span class=\"navbar-brand mb-0\">" + getPortalName() + "</span>");
        writer.println("</nav><br>");
        writer.println("<div class=\"container\">");
    }

    static void renderEndOfPage(PrintWriter writer) {
        writer.println("</div>");
        writer.println("</body></html>");
    }
}
