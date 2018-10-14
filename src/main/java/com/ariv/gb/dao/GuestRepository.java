/**
 * 
 */
package com.ariv.gb.dao;

import org.springframework.data.repository.CrudRepository;

import com.ariv.gb.model.Guest;

/**
 * @author zentere
 *
 */
public interface GuestRepository extends CrudRepository<Guest, Integer> {

}
