package hello.servlet.basic.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.servlet.basic.HelloDate;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "responseJsonServlet" , urlPatterns = "/response-json")
public class ResponseJsonServlet extends HttpServlet {
   private ObjectMapper objectMapper = new ObjectMapper();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");

        HelloDate helloDate = new HelloDate();
        helloDate.setUsername("kim");
        helloDate.setAge(20);
        String result = objectMapper.writeValueAsString(helloDate);
        //{"username" : "kim" , "age": 20}
        response.getWriter().write(result);
    }
}
