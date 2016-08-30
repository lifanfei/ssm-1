package com.elin4it.ssm.util;

import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UserFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        // �����˵�uri
        String[] notFilter = new String[]{"login.html"};
        // �����uri
        String uri = request.getRequestURI();
        // uri�а���backgroundʱ�Ž��й���
        if (uri.indexOf("rest") != -1) {
            // �Ƿ����
            boolean doFilter = true;
            for (String s : notFilter) {
                if (uri.indexOf(s) != -1) {
                    // ���uri�а��������˵�uri���򲻽��й���
                    doFilter = false;
                    break;
                }
            }
            if (doFilter) {
                // ִ�й���
                // ��session�л�ȡ��¼��ʵ��
                Object obj = request.getSession().getAttribute("user");
                if (null == obj) {
                    // ���session�в����ڵ�¼��ʵ�壬�򵯳�����ʾ���µ�¼
                    // ����request��response���ַ�������ֹ����
                    request.setCharacterEncoding("UTF-8");
                    response.setCharacterEncoding("UTF-8");
                    PrintWriter out = response.getWriter();
                    String loginPage = "index.jsp";
                    StringBuilder builder = new StringBuilder();
                    builder.append("<script type=\"text/javascript\"charset=\"UTF-8\">");
                    builder.append("alert('��ҳ���ڣ������µ�¼��');");
                    builder.append("window.top.location.href='");
                    builder.append(loginPage);
                    builder.append("';");
                    builder.append("</script>");
                    out.print(builder.toString());
                } else {
                    // ���session�д��ڵ�¼��ʵ�壬�����
                    filterChain.doFilter(request, response);
                }
            } else {
                // �����ִ�й��ˣ������
                filterChain.doFilter(request, response);
            }
        } else {
            // ���uri�в�����background�������
            filterChain.doFilter(request, response);
        }
    }
}
