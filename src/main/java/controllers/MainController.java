package controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import utils.Utils;

import java.io.IOException;

@RestController
public class MainController {





    @GetMapping("/test")
    public String getCose(@RequestParam String id) throws Exception {
    Utils utils = new Utils();
        return utils.getBalance(id);
    }
}
