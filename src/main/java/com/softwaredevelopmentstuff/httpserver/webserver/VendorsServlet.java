package com.softwaredevelopmentstuff.httpserver.webserver;

import com.softwaredevelopmentstuff.httpserver.database.Database;
import org.eclipse.jetty.http.MimeTypes;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.softwaredevelopmentstuff.httpserver.webserver.App.renderBeginOfPage;
import static com.softwaredevelopmentstuff.httpserver.webserver.App.renderEndOfPage;

public class VendorsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType(MimeTypes.Type.TEXT_HTML.asString());
        resp.setStatus(HttpServletResponse.SC_OK);

        renderBeginOfPage(resp.getWriter(), "Vendors List");

        resp.getWriter().println("<h3>Vendors List</h3>");
        resp.getWriter().println("<table class=\"table table-striped\">");
        resp.getWriter().println("<thead>");
        resp.getWriter().println("<tr>");
        resp.getWriter().println("<th>Name</th>");
        resp.getWriter().println("<th>Country of Registration</th>");
        resp.getWriter().println("<th>Registration Number</th>");
        resp.getWriter().println("<th>Actions</th>");
        resp.getWriter().println("</tr>");
        resp.getWriter().println("</thead>");

        Database.instance().getVendors().forEach(vendor -> {
            try {
                resp.getWriter().println("<tr>");
                resp.getWriter().println("<td>" + vendor.getName() + "</td>");
                resp.getWriter().println("<td>" + vendor.getCountryOfRegistration() + "</td>");
                resp.getWriter().println("<td>" + vendor.getRegistrationNumber() + "</td>");
                resp.getWriter().println("<td><a href=\"/vendor?name=" + vendor.getName() + "\">view</a></td>");
                resp.getWriter().println("</tr>");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        String addVendorAddress = App.getOtherPortalAddress() + "/addVendor";
        String returnAddress = "http://localhost:" + App.getPort() + "/vendor";

        resp.getWriter().println("</table>");

        resp.getWriter().println("<br>");
        resp.getWriter().println("<form action=\"" + addVendorAddress + "\" method=\"post\">");
        resp.getWriter().println("<input type=\"hidden\" name=\"version\" value=\"v1\">");
        resp.getWriter().println("<input type=\"hidden\" name=\"requestId\" value=\"1204edb0-ff8d-11e4-a322-1697f925ec7b\">");
        resp.getWriter().println("<input type=\"hidden\" name=\"timestamp\" value=\"2015-09-18T10:32:59Z\">");
        resp.getWriter().println("<input type=\"hidden\" name=\"language\" value=\"fi\">");
        resp.getWriter().println("<input type=\"hidden\" name=\"authenticationKey\" value=\"e742b07db66e3f3095398c454203414537f25d34cb816920d5fd99a24b4aa0a3\">");
        resp.getWriter().println("<input type=\"hidden\" name=\"authenticationKeyVersion\" value=\"v1\">");
        resp.getWriter().println("<input type=\"hidden\" name=\"returnAddress\" value=\"" + returnAddress + "\">");
        resp.getWriter().println("<input type=\"hidden\" name=\"baswareAccountId\" value=\"12424224234\">");
        resp.getWriter().println("<input type=\"hidden\" name=\"rejectEmailAddress\" value=\"reject@example.com\">");
        resp.getWriter().println("<input type=\"submit\" value=\"Add Vendor\" class=\"btn btn-default\">");
        resp.getWriter().println("</form>");

        renderEndOfPage(resp.getWriter());

        resp.flushBuffer();
    }
}
