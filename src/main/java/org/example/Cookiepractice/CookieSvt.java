import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cookiesvt")
public class CookieSvt extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();  // 쿠키 가져오기

        String v_ = req.getParameter("v");
        String op = req.getParameter("operator");

        int v = 0;
        if (!v_.isEmpty()) {  // v_가 비어있지 않으면 정수로 변환
            v = Integer.parseInt(v_);
        }

        int result = 0;

        if(op.equals("=")) {  // 연산자가 "="인 경우
            int x = 0; // 변수 초기화
            String operator = ""; // 변수 초기화

            // 'value' 쿠키 가져오기
            if (cookies != null) {
                for (Cookie c : cookies) {
                    if (c.getName().equals("value")) {
                        x = Integer.parseInt(c.getValue());
                        break;
                    }
                }
            }

            // 'operator' 쿠키 가져오기
            if (cookies != null) {
                for (Cookie c : cookies) {
                    if (c.getName().equals("operator")) {
                        operator = c.getValue();
                        break;
                    }
                }
            }

            int y = v;

            // 연산자에 따른 계산 수행
            switch (operator) {
                case "+":
                    result = x + y;
                    break;
                case "-":
                    result = x - y;
                    break;
                case "*":
                    result = x * y;
                    break;
                case "/":
                    if (y != 0) {
                        result = x / y;
                    } else {
                        System.out.println("Error: 0으로 나눌 수 없습니다");
                        resp.getWriter().println("Error: 0으로 나눌 수 없습니다");
                        return;
                    }
                    break;
                default:
                    System.out.println("Error: 알 수 없는 연산자입니다");
                    resp.getWriter().println("Error: 알 수 없는 연산자입니다");
                    return;
            }

            System.out.printf("연산자: %s, 결과: %d%n", operator, result);
            resp.getWriter().printf("결과는 %d입니다", result);

        } else {
            // 값과 연산자를 쿠키에 저장
            Cookie valueCookie = new Cookie("value", String.valueOf(v));
            Cookie opCookie = new Cookie("operator", op);
            valueCookie.setPath("/");
            opCookie.setPath("/");

            resp.addCookie(valueCookie);
            resp.addCookie(opCookie);

            // 콘솔에 출력
            System.out.printf("값 %d와 연산자 %s를 쿠키에 저장했습니다%n", v, op);
        }
    }
}
