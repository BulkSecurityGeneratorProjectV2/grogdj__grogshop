/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.grogshop.services.api;

import com.grogdj.grogshop.core.model.Listing;
import java.util.List;

/**
 *
 * @author salaboy
 */
public interface ListingsService {
    
    Listing getListing(Long listingId);

    List<Listing> getAllListings();

    Long newListing(Listing listing);

    void clearListings();

    void removeListing(Long listingId);

}
