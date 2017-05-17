package com.asimio.cxfdemo.rest.v1.impl;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.asimio.cxfdemo.rest.v1.HelloResource;
import com.asimio.cxfdemo.rest.v1.model.Hello;

// No JAX-RS annotation in class, method or method arguments
@Component("helloResourceV1")
public class HelloResourceImpl implements HelloResource {

	private static final Logger LOGGER = LoggerFactory.getLogger(HelloResourceImpl.class);

	@Override
	public Response getHelloVersionInUrl(String name) {
		LOGGER.info("getHelloVersionInUrl() v1");
		return this.getHello(name, "Version 1 - passed in URL");
	}

	@Override
	public Response getHelloVersionInAcceptHeader(String name) {
		LOGGER.info("getHelloVersionInAcceptHeader() v1");
		return this.getHello(name, "Version 1 - passed in Accept Header");
	}

	private Response getHello(String name, String partialMsg) {
		if ("404".equals(name)) {
			return Response.status(Status.NOT_FOUND).build();
		}
		Hello result = new Hello();
		result.setMsg(String.format("Hello %s. %s", name, partialMsg));
		return Response.status(Status.OK).entity(result).build();
	}

}