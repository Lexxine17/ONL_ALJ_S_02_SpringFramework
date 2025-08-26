package pl.coderslab.hibernate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.coderslab.day1.beans.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {
    private final DaoPersonDetails daoPersonDetails;
    private final DaoPerson daoPerson;

    public PersonController(DaoPersonDetails daoPersonDetails, DaoPerson daoPerson) {
        this.daoPersonDetails = daoPersonDetails;
        this.daoPerson = daoPerson;
    }

    @GetMapping("/create")
    public String createPerson() {
        PersonDetails personDetails = new PersonDetails();
        personDetails.setFirstName("Karl");
        personDetails.setLastName("Walter");
        personDetails.setStreetNumber(17);
        personDetails.setCity("LA");
        personDetails.setStreet("Sunny");
        daoPersonDetails.save(personDetails);
        Person person = new Person();
        person.setEmail("some@gmail.com");
        person.setLogin("something");
        person.setPassword("password");
        person.setPersonDetails(personDetails);
        daoPerson.save(person);
        return "Dodano nową osobę";
    }

    @GetMapping("/read")
    public String readBook() {
        Person person = daoPerson.findById(1L);
        return person.toString();
    }

    @GetMapping("/update")
    public String updateBook() {
        Person person = daoPerson.findById(1L);
        person.setLogin("something new");
        person.setPassword("password 2");
        person.setEmail("somethingnew@gmail.com");
        daoPerson.update(person);
        return "Zaktualizowano informacje: " + person.toString();
    }

    @GetMapping("/delete")
    public String deleteBook() {
        Person person = daoPerson.findById(1L);
        daoPerson.delete(person);
        return "Usunięto osobę: " + person.toString();
    }
}
