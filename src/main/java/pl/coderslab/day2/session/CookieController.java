package pl.coderslab.day2.session;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.WebUtils;


@Controller
public class CookieController {

    @RequestMapping("/setcookie/{value1}/{value2}")
    public void setCookie(HttpServletResponse response, @PathVariable String value1, @PathVariable String value2) {

        Cookie cookie1 = new Cookie("cookie1", value1);
        Cookie cookie2 = new Cookie("cookie2", value2);
        cookie1.setPath("/");
        cookie2.setPath("/");
        response.addCookie(cookie1);
        response.addCookie(cookie2);
    }
    @RequestMapping("/getCookies")
    @ResponseBody
    public String home(HttpServletRequest request){
        Cookie c1 = WebUtils.getCookie(request, "cookie1");
        Cookie c2 = WebUtils.getCookie(request, "cookie2");
        return "cookie1: " + c1.getValue() + ", cookie2: " + c2.getValue();
    }
    @RequestMapping("/cookieGet")
    @ResponseBody
    public String home(@CookieValue("cookie1") String cookie1, @CookieValue String cookie2) {
        return "cookie: " + cookie1 + ", cookie2: " + cookie2;
    }
}
