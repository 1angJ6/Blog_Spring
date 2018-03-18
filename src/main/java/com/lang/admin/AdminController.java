package com.lang.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by lang on 2018/3/17.
 */

@Controller
@RequestMapping("auth")
public class AdminController {

    @Autowired
    private IAdminService adminService;

//    @PostMapping("")

    @PostMapping(value = "login")
    public ResponseEntity<String> login(@RequestBody Admin admin) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        if (adminService.auth(admin)) {
            String status = "{\"status\": pass}";
            return new ResponseEntity<String>(status, headers, HttpStatus.OK);
        } else {
            String status = "{\"status\": fail}";
            return new ResponseEntity<String>(status, headers, HttpStatus.OK);
        }

    }

}
