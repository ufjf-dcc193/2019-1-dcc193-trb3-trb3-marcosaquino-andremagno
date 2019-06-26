package trb3.dcc193.trb3;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ControllerHome {

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String inicio(){
        return "home.html";
    }

}