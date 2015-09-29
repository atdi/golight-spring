package com.github.atdi.golight.spring.resources;

import com.github.atdi.golight.spring.services.DummyService;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * Created by aurelavramescu on 29/09/15.
 */
@Path("/")
public class DemoResource {

    private final DummyService dummyService;

    @Inject
    public DemoResource(DummyService dummyService) {
        this.dummyService = dummyService;
    }

    @GET
    @Path("dummy")
    public Response dummyEndPoint() {
        return Response.ok(dummyService.sayHello()).build();
    }
}
