package com.github.ipetruk.dolphin_orchestra.server.rest;

import com.github.ipetruk.dolphin_orchestra.server.data.DatabaseFactory;
import com.sleepycat.bind.serial.StoredClassCatalog;
import com.sleepycat.collections.StoredMap;
import com.sleepycat.je.Database;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/")
public class RestService {
    @Inject
    private DatabaseFactory databaseFactory;

    @GET
    public Response get() {
        Database database = databaseFactory.provideDatabase("a");
        StoredClassCatalog storedClassCatalog = new StoredClassCatalog(database);
        return Response.status(200).entity("ss").build();
    }

    @GET
    @Path("{any}")
    public Response catchAll() {
        return this.get();
    }
}
