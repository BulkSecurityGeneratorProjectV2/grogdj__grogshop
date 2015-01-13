/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.grogshop.services.api;

import com.grogdj.grogshop.core.model.Item;
import java.math.BigDecimal;
import java.util.List;
import org.grogshop.services.exceptions.ServiceException;

/**
 *
 * @author grogdj
 */
public interface ItemsService {

    List<Item> getAllItems();
    
    List<Item> getAllItemsByClub(Long clubId);

    Long newItem(Long userId, Long clubId, String name, String description,  List<String> interests, BigDecimal price) throws ServiceException;

    Item getById(Long item_id);

}
