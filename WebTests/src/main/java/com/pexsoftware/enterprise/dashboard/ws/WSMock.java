package com.pexsoftware.enterprise.dashboard.ws;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.*;

/**
 *
 * @author bastiaanlos
 */
@Path("/dailyOccupancyReport")
@Produces({"application/json"})
@Consumes({"application/json"})
public class WSMock {

    @GET
    @Path("{landlordId}/{dateString}/{arrayBookingStatus}")
    public MockClass getData(@PathParam("landlordId") String landlordId, @PathParam("dateString") String dateString, @PathParam("arrayBookingStatus") String arrayBookingStatus) {
        try {
            System.out.println("Calling report data [" + landlordId + "][" + dateString + "][" + arrayBookingStatus + "]");
            
            return new MockClass("Hola Javi", "Adios Javi");            
        } catch (Exception ex) {
            Logger.getLogger(WSMock.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException(ex);
        }
    }
}