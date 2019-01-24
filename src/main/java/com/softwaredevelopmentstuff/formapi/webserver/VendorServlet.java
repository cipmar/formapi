package com.softwaredevelopmentstuff.formapi.webserver;

import com.softwaredevelopmentstuff.formapi.database.Database;
import com.softwaredevelopmentstuff.formapi.model.Vendor;
import org.eclipse.jetty.http.MimeTypes;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.softwaredevelopmentstuff.formapi.webserver.App.renderBeginOfPage;
import static com.softwaredevelopmentstuff.formapi.webserver.App.renderEndOfPage;

public class VendorServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        Vendor vendor = Database.instance().findVendor(name);

        resp.setContentType(MimeTypes.Type.TEXT_HTML.asString());
        resp.setStatus(HttpServletResponse.SC_OK);

        renderBeginOfPage(resp.getWriter(), "Vendors List");
        resp.getWriter().println("<h3>View Vendor</h3>");

        resp.getWriter().println("<form>");
        resp.getWriter().println("<label for=\"name\">Name</label>");
        resp.getWriter().println("<input type=\"text\" class=\"form-control\" readonly value=" + vendor.getName() + ">");
        resp.getWriter().println("<label for=\"name\">Country or Registration</label>");
        resp.getWriter().println("<input type=\"text\" class=\"form-control\" readonly value=" + vendor.getCountryOfRegistration() + ">");
        resp.getWriter().println("<label for=\"name\">Registration number</label>");
        resp.getWriter().println("<input type=\"text\" class=\"form-control\" readonly value=" + vendor.getRegistrationNumber() + ">");
        resp.getWriter().println("</form>");

        resp.getWriter().println("<a href=\"/vendors\" class=\"btn btn-default\">back</a>");

        renderEndOfPage(resp.getWriter());
        resp.getWriter().flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getParameterMap().forEach((k, v) -> System.out.println(k + " :" + v[0]));

        Vendor vendor = new Vendor();
        vendor.setName(req.getParameter("name"));
        vendor.setCountryOfRegistration(req.getParameter("countryOfRegistration"));
        vendor.setRegistrationNumber(req.getParameter("registrationNumber"));
        Database.instance().getVendors().add(vendor);

        resp.sendRedirect("/vendor?name=" + vendor.getName());
    }
}
