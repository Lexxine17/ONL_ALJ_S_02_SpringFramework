package pl.coderslab.day2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Random;

@Controller
@RequestMapping("/first")
public class RandomController {

    @RequestMapping(path = "/show-random", produces = "text/html; charset=UTF-8")
    @ResponseBody
    public String showRandom() {
        int randomNumber = (int) (Math.random() * 100);
        return "Wylosowano liczbę: " + randomNumber;
    }


    @RequestMapping(path = "/random/{max}", produces = "text/html; charset=UTF-8")
    @ResponseBody
    public String max(@PathVariable int max) {
        int i = (int) (Math.random() * max);
        return "Użytkownik podał wartość max. Wylosowano liczbę:  " + i;
    }

    @RequestMapping(path = "/random/{min}/{max}", produces = "text/html; charset=UTF-8")
    @ResponseBody
    public String maxToMin(@PathVariable int min, @PathVariable int max) {

        Random rand = new Random();
        int randNum = rand.nextInt((max - min) + 1) + min;

        return "Użytkownik podał wartości min i max. Wylosowano liczbę:  " + randNum;
    }

    @RequestMapping(path = "/hello/{firstName}/{lastNama}", produces = "text/html; charset=UTF-8")
    @ResponseBody
    public String showName(@PathVariable String firstName, @PathVariable String lastNama) {

        return "Witaj " + firstName + " " + lastNama;
    }

    @PostMapping("/form")
    @ResponseBody
    public String showForm(@RequestParam String paramName, @RequestParam String paramDate) {
        String name = paramName;
        LocalDate localDate = LocalDate.parse(paramDate);
        System.out.println(name);
        return name + " " + localDate;
    }

}
