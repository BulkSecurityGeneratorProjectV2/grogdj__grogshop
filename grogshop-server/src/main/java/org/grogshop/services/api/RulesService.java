/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.grogshop.services.api;

/**
 *
 * @author salaboy
 */
public interface RulesService {
    void insert(Object o);
    void retract(Object o);
    void update(Object o);
    void reset();
}
