/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.grogshop.services.endpoints.impl;

import com.grogdj.grogshop.core.model.Interest;
import com.grogdj.grogshop.core.model.User;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import org.grogshop.services.api.MembershipsService;
import org.grogshop.services.api.ClubsService;
import org.grogshop.services.api.InterestsService;
import org.grogshop.services.api.ItemsService;
import org.grogshop.services.api.ProfilesService;
import org.grogshop.services.api.UsersService;
import org.grogshop.services.endpoints.api.PublicShopInitService;
import org.grogshop.services.exceptions.ServiceException;
import org.grogshop.services.impl.InterestsServiceImpl;

//http://localhost:8080/grogshop-server/rest/public/app/init
@Stateless
public class PublicShopInitServiceImpl implements PublicShopInitService {

    @Inject
    private ClubsService clubsService;

    @Inject
    private UsersService usersService;

    @Inject
    private InterestsService interestsService;

    @Inject
    private ProfilesService profilesService;

    @Inject
    private ItemsService itemsService;

    @Inject
    private MembershipsService membershipsService;

    public Response initApplication() throws ServiceException {
        try {
            Long grogdjId = usersService.newUser(new User("grogdj@gmail.com", "asdasd"));
            Long ezeId = usersService.newUser(new User("eze@asd.asd", "123123"));
            interestsService.newInterest("cooking", "cooking.jpg");
            interestsService.newInterest("music", "music.jpg");
            interestsService.newInterest("art", "art.jpg");
            interestsService.newInterest("science", "science.jpg");
            interestsService.newInterest("sports", "sports.jpg");
            interestsService.newInterest("cars", "cars.jpg");
            interestsService.newInterest("design", "design.jpg");
            interestsService.newInterest("health", "health.jpg");
            interestsService.newInterest("antiques", "antiques.jpg");
            interestsService.newInterest("clothes", "clothes.jpg");
            interestsService.newInterest("astronomy", "astrology.jpg");
            interestsService.newInterest("gardening", "gardening.jpg");
            interestsService.newInterest("infusions", "infusions.jpg");
            interestsService.newInterest("old cars", "oldcars.jpg");
            interestsService.newInterest("pets", "pets.jpg");
            interestsService.newInterest("photography", "photography.jpg");
            interestsService.newInterest("radio", "radio.jpg");
            interestsService.newInterest("sailing", "sailing.jpg");
            interestsService.newInterest("video games", "videogames.jpg");
            interestsService.newInterest("writing", "writing.jpg");

            profilesService.create(grogdjId);
            List<Interest> interests = new ArrayList<Interest>();
            interests.add(interestsService.get("cooking"));
            interests.add(interestsService.get("antiques"));
            profilesService.setInterests(grogdjId, interests);
            
            profilesService.create(ezeId);
            interests = new ArrayList<Interest>();
            interests.add(interestsService.get("cooking"));
            interests.add(interestsService.get("antiques"));
            interests.add(interestsService.get("infusions"));
            profilesService.setInterests(ezeId, interests);

            List<String> tags = new ArrayList<String>();
            tags.add("food");
            tags.add("fun");
            tags.add("healty");
            Long cookingId = clubsService.newClub("cooking club", "this is a new cooking club", "cooking", tags, grogdjId, "cooking.jpg");
            tags = new ArrayList<String>();
            tags.add("stars");
            tags.add("galaxy");
            tags.add("apollo");
            Long astronomyId = clubsService.newClub("astronomy for everyone", "astronomy club for everybody", "astronomy", tags, grogdjId, "astrology.jpg");
            tags = new ArrayList<String>();
            tags.add("old");
            tags.add("classic");
            tags.add("cars");
            Long oldCarsId = clubsService.newClub("My good old cars", "about classic cars and stuff", "old cars", tags, grogdjId, "oldcars.jpg");
            tags = new ArrayList<String>();
            tags.add("puppies");
            tags.add("dogs");
            tags.add("cats");
            Long petsId = clubsService.newClub("My small pets", "all pets allowed", "pets", tags, grogdjId, "pets.jpg");
            tags = new ArrayList<String>();
            tags.add("arcade");
            tags.add("play");
            tags.add("games");
            Long videogamesId = clubsService.newClub("Pacman & cia", "for all the gamers", "video games", tags, ezeId, "videogames.jpg");
            tags = new ArrayList<String>();
            tags.add("graphic");
            tags.add("visual");
            tags.add("design");
            Long designId = clubsService.newClub("Designers United", "let the style be with you", "design", tags, ezeId, "design.jpg");
            tags = new ArrayList<String>();
            tags.add("old");
            tags.add("fashion");
            tags.add("furniture");
            Long antiquesId = clubsService.newClub("Antiques", "more than 100 year old items", "antiques", tags, ezeId, "antiques.jpg");
            tags = new ArrayList<String>();
            tags.add("old");
            tags.add("fashion");
            tags.add("furniture");
            Long antiques2Id = clubsService.newClub("Old Stuff", "more than 100 year old items", "antiques", tags, ezeId, "antiques.jpg");
            tags = new ArrayList<String>();
            tags.add("old");
            tags.add("cars");
            tags.add("classics");
            Long oldCars2Id = clubsService.newClub("antiques", "more than 100 year old items", "old cars", tags, ezeId, "oldcars.jpg");

            membershipsService.createMembership(cookingId, grogdjId);
            membershipsService.createMembership(antiquesId, grogdjId);

        } catch (Exception ex) {
            Logger.getLogger(InterestsServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Response.ok().build();
    }

}