package com.softwaredevelopmentstuff.formapi.webserver;

import org.apache.commons.io.IOUtils;
import org.eclipse.jetty.http.MimeTypes;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import static com.softwaredevelopmentstuff.formapi.webserver.App.getPortalName;
import static com.softwaredevelopmentstuff.formapi.webserver.App.getTheme;

public class AddVendorFormServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        addVendorFormResponse(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        addVendorFormResponse(req, resp);
    }

    private void addVendorFormResponse(HttpServletRequest req,HttpServletResponse resp) throws IOException {
        InputStream is = getClass().getClassLoader().getResourceAsStream("addVendorForm.html");

        resp.setContentType(MimeTypes.Type.TEXT_HTML.asString());
        resp.setStatus(HttpServletResponse.SC_OK);

        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        IOUtils.copy(is, bos);
        String page = new String(bos.toByteArray());

        page = page.replace("${theme}", getTheme());
        page = page.replace("${portalName}", getPortalName());
        page = page.replace("${action}", req.getParameter("returnAddress"));

        resp.getOutputStream().write(page.getBytes());
        resp.getOutputStream().flush();
    }
}
