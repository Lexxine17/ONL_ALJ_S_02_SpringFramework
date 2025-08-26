package pl.coderslab.day2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

@Controller
public class FreeTimeController {
    Logger log = LoggerFactory.getLogger(FreeTimeController.class);

    @RequestMapping(path = "/time", produces = "text/html; charset=UTF-8")
    @ResponseBody
    public String isFreeOrNot() {
        DayOfWeek today = LocalDate.now().getDayOfWeek();

        LocalTime now = LocalTime.now();
        if (today == DayOfWeek.SATURDAY || today == DayOfWeek.SUNDAY) {
            return "Wolne";
        } else if (now.isAfter(LocalTime.of(8, 59)) && now.isBefore(LocalTime.of(17, 0))) {
            return "Pracuje, nie dzwoń.";
        } else {
            return "Po Pracy";
        }

    }
}
