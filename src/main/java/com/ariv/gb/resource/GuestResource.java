/**
 * 
 */
package com.ariv.gb.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ariv.gb.dao.GuestRepository;
import com.ariv.gb.model.Guest;
import com.ariv.gb.utils.ResponseData;

/**
 * @author zentere
 *
 */
@RestController
@RequestMapping("/api/")
public class GuestResource {

	@Autowired
	private GuestRepository guestRepository;

	@GetMapping("/guests")
	public ResponseData guests() {
		return new ResponseData(true, "Success", guestRepository.findAll());
	}

	@PostMapping("/guests")
	public ResponseData addGuest(@RequestBody Guest guest) {
		return new ResponseData(true, "Success", guestRepository.save(guest));
	}

	@GetMapping("/guests/{id}")
	public ResponseData getGuest(@PathVariable Integer id) {
		return new ResponseData(true, "Success", guestRepository.findById(id));
	}

	@DeleteMapping("/guests/{id}")
	public ResponseData deleteGuest(@PathVariable Integer id) {
		guestRepository.deleteById(id);
		return new ResponseData(true, "Success", "");
	}
}
