package by.it.kirova.project.java.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

public class FrontController extends HttpServlet {
    private ActionFactory actionFactory;

    @Override
    public void init() throws ServletException {
        actionFactory = new ActionFactory();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String viewPage;
        try {
            Cmd cmd = actionFactory.defineCmd(req);
            Cmd next = cmd.execute(req, resp);
            if (next == null) {
                viewPage = cmd.getJsp();
                getServletContext().getRequestDispatcher(viewPage).forward(req, resp);
            } else {
                resp.sendRedirect("do?command=" + next.toString());
            }
        } catch (Exception e) {
            req.setAttribute("err", e.getMessage());
            String log = Arrays.toString(e.getStackTrace()).replaceAll(",","<br>");
            req.setAttribute("log", log);
            getServletContext().getRequestDispatcher(Actions.ERROR.command.getJsp()).forward(req, resp);

        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String viewPage;
        try {
            Cmd cmd = actionFactory.defineCmd(req);
            Cmd next = cmd.execute(req, resp);
            if (next == null) {
                viewPage = cmd.getJsp();
                getServletContext().getRequestDispatcher(viewPage).forward(req, resp);
            } else {
                resp.sendRedirect("do?command=" + next.toString());
            }
        } catch (Exception e) {
            req.setAttribute("err", e.getMessage());
            String log = Arrays.toString(e.getStackTrace()).replaceAll(",","<br>");
            req.setAttribute("log", log);
            getServletContext().getRequestDispatcher(Actions.ERROR.command.getJsp()).forward(req, resp);

        }
    }


//    private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//        Cmd cmd = actionFactory.defineCmd(req);
//        String viewPage;
//        try {
//            viewPage = cmd.getJsp();
//        } catch (Exception e) {
//            viewPage = Actions.ERROR.command.getJsp();
//        }
//        ServletContext servletContext = getServletContext();
//        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(viewPage);
//        requestDispatcher.forward(req, resp);
//
//
//    }
}
