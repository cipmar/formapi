package com.softwaredevelopmentstuff.formapi.webserver;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;

public class WebServer {
    public static void main(String[] args) throws Exception {

        if (args.length < 3) {
            throw new RuntimeException("Not enough arguments!");
        }

        System.setProperty("APP_NAME", args[0]);
        System.setProperty("PORT", args[1]);
        System.setProperty("OTHER_PORTAL_ADDRESS", args[2]);

        int port = Integer.parseInt(System.getProperty("PORT"));

        Server server = new org.eclipse.jetty.server.Server(port);
        ServletHandler servletHandler = new ServletHandler();
        servletHandler.addServletWithMapping(VendorServlet.class, "/vendor");
        servletHandler.addServletWithMapping(VendorAjaxServlet.class, "/vendorAjax");
        servletHandler.addServletWithMapping(VendorsServlet.class, "/vendors");
        servletHandler.addServletWithMapping(AddVendorFormServlet.class, "/addVendor");
        server.setHandler(servletHandler);
        server.start();
        server.join();
    }
}
