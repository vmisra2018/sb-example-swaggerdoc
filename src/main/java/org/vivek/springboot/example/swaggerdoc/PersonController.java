package org.vivek.springboot.example.swaggerdoc;
import java.net.http.HttpRequest;

import javax.validation.Valid;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
    @RequestMapping(path = "/person", method = RequestMethod.POST)
    public Person person(@Valid @RequestBody Person person) {
        return person;
    }
    
    @RequestMapping(path = "/personrequest", method = RequestMethod.POST)
    public Person personHttpRequest(HttpRequest req) {
    	Person person = new Person();
        return person;
    }
}
