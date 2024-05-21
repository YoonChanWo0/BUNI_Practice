package org.example.intelijepractice;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import java.io.IOException;
@WebFilter("/*")
public class FilterTest02 extends HttpFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse Response, FilterChain filterChain) throws IOException, ServletException { // 요청이 올때마다 실행
        Response.setContentType("text/html;charset=utf-8");
        String ip = servletRequest.getRemoteAddr();
        System.out.println("Remote IP addRESS:::" + ip);
        filterChain.doFilter(servletRequest, Response);

        // doFilter() 호출 이후에 후 처리 코드
        System.out.println("후 처리 코드 실행");
    }

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
