package com.lang.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * Created by lang on 2018/3/17.
 */

@Controller
@CrossOrigin("http://localhost:4200")
@EnableRedisHttpSession
@RequestMapping("auth")
public class AdminController {

    @Autowired
    private IAdminService adminService;

//    @PostMapping("")

    @PostMapping(value = "login")
    public ResponseEntity<String> login(@RequestBody Admin admin, HttpSession session) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        if (adminService.auth(admin)) {
            String status = "{\"status\": \"pass\", \"sessionID\":\"" + session.getId() + "\"}";
            return new ResponseEntity<String>(status, headers, HttpStatus.OK);
        } else {
            String status = "{\"status\": fail}";
            String test = "abc";

            return new ResponseEntity<String>(status, headers, HttpStatus.UNAUTHORIZED);
        }
    }

}
