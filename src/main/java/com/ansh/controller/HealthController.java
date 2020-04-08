package com.ansh.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api(description = "This module is built to showcase swagger usage")
@RestController
public class HealthController {

    @ApiOperation("Ping path")
    @RequestMapping(value = "/health", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public void ping(){
    }
}
