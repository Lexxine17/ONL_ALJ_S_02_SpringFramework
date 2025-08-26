package pl.coderslab.day2.session;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class SessionController {

    @GetMapping("/session")
    public String session(HttpSession session) {
        if (session.getAttribute("loginStart") == null) {
            session.setAttribute("loginStart", LocalDate.now());
        }
        return session.getAttribute("loginStart").toString();
    }

}
