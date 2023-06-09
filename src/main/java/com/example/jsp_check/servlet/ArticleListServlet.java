package com.example.jsp_check.servlet;

import com.example.jsp_check.util.DBUtil;
import com.example.jsp_check.util.SecSql;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@WebServlet("/article/list")
public class ArticleListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // DB 연결시작
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.printf("[ClassNotFoundException 예외, %s]", e.getMessage());
            System.out.println("DB 드라이버 클래스 로딩 실패");
            return;
        }

        String url = "jdbc:mysql://localhost:3306";
        String user = "root";
        String password = "zerobase";

        try {
            conn = DriverManager.getConnection(url, user, password);
            DBUtil dbUtil = new DBUtil();

            SecSql sql = new SecSql();
            sql.append("SELECT *");
            sql.append("FROM article");

            List<Map<String, Object>> articleRows = dbUtil.selectRows(conn, sql);

            req.setAttribute("articleRows", articleRows);
            req.getRequestDispatcher("../article/list.jsp").forward(req, resp);

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (conn != null && !conn.isClosed()) {
                        conn.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
    }
}
