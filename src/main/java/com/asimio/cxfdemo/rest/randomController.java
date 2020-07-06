package com.asimio.cxfdemo.rest.v1.impl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

@Path("/random")
@Api(value = "Hello Endpoint Version 1", consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
public class randomController {

    @GET
    @Path("/hello")
    @ApiOperation(value = "Gets a String resource. Version 1 - (version in URL)")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "getRandom Endpoint found", response = String.class),
            @ApiResponse(code = 404, message = "getRandom Endpoint not found")
    })
    public String getRandom(){
        System.out.println("Inside the random controller ->");
        return "Hi from random controller -> ";
    }
}
