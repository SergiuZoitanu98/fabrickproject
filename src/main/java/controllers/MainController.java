package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import utils.Utils;

@RestController
public class MainController {





    @GetMapping("/test")
    public String getCose(@RequestBody String id){
    Utils utils = new Utils();
        return utils.getBalance(id);
    }
}
