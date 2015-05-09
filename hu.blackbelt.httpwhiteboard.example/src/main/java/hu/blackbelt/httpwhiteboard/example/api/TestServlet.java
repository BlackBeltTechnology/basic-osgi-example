package hu.blackbelt.httpwhiteboard.example.api;

import hu.blackbelt.logger.api.CustomLoggerService;
import org.apache.felix.scr.annotations.*;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static org.apache.felix.scr.annotations.ReferenceCardinality.MANDATORY_UNARY;
import static org.apache.felix.scr.annotations.ReferenceCardinality.OPTIONAL_UNARY;

@Component
@Service(Servlet.class)
@Properties(value = {
        @Property(name = "alias", value = "/"),
        @Property(name = "servlet-name", value = "HelloWorld example"),
        @Property(name = "defaultIndex", value = "/index.html")

})
public class TestServlet extends HttpServlet {

    @Reference(cardinality = MANDATORY_UNARY)
    private CustomLoggerService customLoggerService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        customLoggerService.info("Printing Hello world.");

        PrintWriter out = resp.getWriter();
        out.println("Hello world.");
        out.flush();
    }
}
