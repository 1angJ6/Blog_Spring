package com.lang;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by lang on 2018/3/31.
 */

@Controller
public class IndexController {

    @GetMapping("/**")
    public String index() {
        return "../static/index.html";
    }

}
