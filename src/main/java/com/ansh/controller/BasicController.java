package com.ansh.controller;

import com.ansh.model.Order;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@Api(description = "This module is built to showcase swagger usage")
@Slf4j
@RestController
public class BasicController {

    @ApiOperation("Get order request")
    @RequestMapping(value = "/get", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    @ResponseBody
    public Order getRequest(){
        log.info("Get request without body/path-param");
        return new Order(1);
    }

    @ApiOperation("Get order request with body")
    @RequestMapping(value = "/get/order", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    @ResponseBody
    public Order getRequestRequestBody(@RequestBody @Valid Order order){
        log.info("Get request with body");
        return new Order(order.getOrderId());
    }

    @ApiOperation("Get order request with path param")
    @RequestMapping(value = "/get/{orderId}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    @ResponseBody
    public Order getRequestPathParam(@PathVariable("orderId") int orderId){
        log.info("Get request with path-param");
        return new Order(orderId);
    }

    @ApiOperation("Post order request")
    @RequestMapping(value = "/post", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    @ResponseBody
    public Order postRequest(@RequestBody @Valid Order order){
        log.info("Post request");
        return new Order(order.getOrderId());
    }

    @ApiOperation("Put order request")
    @RequestMapping(value = "/put", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
    @ResponseBody
    public Order putRequest(@RequestBody @Valid Order order){
        log.info("Put request");
        return new Order(order.getOrderId());
    }

    @ApiOperation("Delete order request")
    @RequestMapping(value = "/delete/{orderId}", method = RequestMethod.DELETE)
    @ResponseBody
    public Order deleteRequest(@PathVariable("orderId") int orderId){
        log.info("Delete request");
        return new Order(orderId);
    }
}
