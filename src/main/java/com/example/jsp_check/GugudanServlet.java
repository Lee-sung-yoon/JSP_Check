package com.example.jsp_check;

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

        rq.appendBody(String.format("<h1>%d단</h1>\n", dan));

        for (int i = 1; i <= limit; i++) {
            rq.appendBody(String.format("<div>%d * %d = %d </div>\n", dan, i, dan * i));
        }
    }
}
