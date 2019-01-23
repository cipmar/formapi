package com.softwaredevelopmentstuff.httpserver.webserver;

import com.softwaredevelopmentstuff.httpserver.database.Database;
import com.softwaredevelopmentstuff.httpserver.model.Vendor;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VendorAjaxServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        req.getParameterMap().forEach((k, v) -> System.out.println(k + " :" + v[0]));

        Vendor vendor = new Vendor();
        vendor.setName(req.getParameter("name"));
        vendor.setCountryOfRegistration(req.getParameter("countryOfRegistration"));
        vendor.setRegistrationNumber(req.getParameter("registrationNumber"));
        Database.instance().getVendors().add(vendor);

        resp.setStatus(HttpServletResponse.SC_OK);
    }
}
