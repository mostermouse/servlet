package hello.servlet.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;

/*
* 1.파라미터 전송 기능
* http://localhost:8080/request-param?username=hello&age=20
* */
@WebServlet(name = "requestParamServlet" , urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("All Parameter select - start");
        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> System.out.println(paramName + "=" + request.getParameter(paramName)));
        System.out.println("All Parameter select - end");
        System.out.println();

        System.out.println("One Parameter select - start");
        String userName = request.getParameter("username");
        String age = request.getParameter("age");

        System.out.println("userName = " + userName);
        System.out.println("age = " + age);
        System.out.println("One Parameter select - end");
        System.out.println();

        System.out.println("same name parameter -- strat");
        String[] userNames = request.getParameterValues("username");
        for (String name : userNames) {
            System.out.println(name);
        }

        System.out.println("same name parameter -- end");
        response.getWriter().write("ok");
    }
}
