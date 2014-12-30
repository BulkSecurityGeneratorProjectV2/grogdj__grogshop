/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.grogshop.services.api;

import com.grogdj.grogshop.core.model.Matching;
import java.util.Set;
import javax.websocket.Session;

/**
 *
 * @author grogdj
 */
public interface NotificationsService {

    void notifyUser(String userId, String message, String type);

    void notifyMatching(String listingUserId, String bidUserId, Matching matching);

    void setActiveSessions(Set<Session> activeSessions);
}