package com.example.jsp_check.servlet;

import com.example.jsp_check.Rq;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/gugudan")
public class GugudanServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setCharacterEncoding("UTF-8"); // 들어오는 데이터를 utf-8로 해석
//        resp.setCharacterEncoding("UTF-8"); // 완성되는 html의 인코딩을 utf-8로 하겠다.
//        resp.setContentType("text/html; charset-utf-8"); // 브라우저에게 우리가 만든 결과물이 utf-8이라고 알리는 의미

        Rq rq = new Rq(req, resp);

        int dan = rq.getIntParam("dan", 9); // 문장으로 인식되는 변수를 숫자로 변형
        int limit = rq.getIntParam("limit", 9);

        // request에 정보를 담는다.
        // 왜냐하면 나중에 gugudan.jsp에서 해당 내용을 꺼낼 수 있기 때문에
        req.setAttribute("dan", dan);
        req.setAttribute("limit", limit);

        //gugudan2.jsp 에게 나머지 작업을 토스
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/gugudan2.jsp");
        requestDispatcher.forward(req, resp);

    }
}
