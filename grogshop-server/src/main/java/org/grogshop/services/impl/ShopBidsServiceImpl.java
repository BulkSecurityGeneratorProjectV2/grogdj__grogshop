/*
 * JBoss, Home of Professional Open Source
 * Copyright 2014, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.grogshop.services.impl;

import com.grogdj.grogshop.core.model.Bid;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.grogshop.services.api.BidsService;
import org.grogshop.services.api.NotificationsService;

@Path("/bids")
public class ShopBidsServiceImpl {

    @Inject
    BidsService bidsService;
    
    @Inject
    NotificationsService notificationService;
    
    @Inject
    MatchingServiceImpl matchingService;

    public ShopBidsServiceImpl() {

    }

    @POST
    @Path("/new")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.TEXT_PLAIN})
    public Response newBid(Bid bid) {
        bidsService.newBid(bid);
        matchingService.insert(bid);
        return Response.ok().build();
    }

    @GET
    @Path("/all")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Bid> getAllBids() {
        return bidsService.getBids();
    }
    
    @GET
    @Path("/clear")
    public void clearBids() {
        bidsService.clearBids();
    }
    
    

}
