package com.zaggle.xpns.admin.authentication.web.rest;

import com.zaggle.xpns.admin.authentication.service.impl.JwtServiceImpl;
import com.zaggle.xpns.admin.authentication.service.dto.JwtRequest;
import com.zaggle.xpns.admin.authentication.service.dto.JwtResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/api/v1")
@RestController
@CrossOrigin
public class JwtController {

    @Autowired
    private JwtServiceImpl jwtServiceImpl;

    @PostMapping({"/authenticate"})
    public JwtResponse createJwtToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        return jwtServiceImpl.createJwtToken(jwtRequest);
    }
}
