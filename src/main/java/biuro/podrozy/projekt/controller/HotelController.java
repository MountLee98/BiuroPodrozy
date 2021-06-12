package biuro.podrozy.projekt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import biuro.podrozy.projekt.model.Gwiazdki;
import biuro.podrozy.projekt.model.Hotel;
import biuro.podrozy.projekt.model.Lotnisko;
import biuro.podrozy.projekt.service.HotelService;
import biuro.podrozy.projekt.service.KontynentService;
import biuro.podrozy.projekt.service.KrajService;
import biuro.podrozy.projekt.service.LotniskoService;
import biuro.podrozy.projekt.service.MiastoService;
import biuro.podrozy.projekt.service.UczestnikService;
import biuro.podrozy.projekt.service.WycieczkaService;
import biuro.podrozy.projekt.service.ZakupWycieczkiService;

@RequestMapping("/rest/hotel")
@RestController
public class HotelController {

	@Autowired
	KrajService krajService;
	
	@Autowired
	KontynentService kontynentService;
	
	@Autowired
	MiastoService miastoService;
	
	@Autowired
	HotelService hotelService;
	
	@Autowired
	WycieczkaService wycService;
	
	@Autowired
	LotniskoService lotniskoService;
	
	@Autowired
	ZakupWycieczkiService zakupService;
	
	@Autowired
	UczestnikService uczestnikService;
	
	@GetMapping("/getall")
	List<Hotel> getAllAirport() {
		List<Hotel> list = hotelService.getAll();
		return list;
	}
	
	@PostMapping("/addhotel")
	void addAirport(@RequestParam("cityId")Long id, @RequestParam("name")String name) {		
		hotelService.addHotel(id, new Hotel(name));
	}
	
	@GetMapping("/getbyid")
	Hotel getById(@RequestParam("hotelId")Long id) {
		Hotel hotel = hotelService.getById(id);
		return hotel;
	}
	
	@GetMapping("/getbyname")
	Hotel getByName(@RequestParam("name")String name) {
		Hotel hotel = hotelService.getByName(name);
		return hotel;
	}
	
	@PutMapping("/setname")
	void setName(@RequestParam("hotelId")Long id, @RequestParam("newName")String newName) {
		lotniskoService.setName(id, newName);
	}
	
	@DeleteMapping("/deletehotel")
	boolean deleteAirport(@RequestParam("hotelId")Long id) {
		return hotelService.deleteById(id);
	}
	
	@GetMapping("/getbystandard")
	List<Hotel> getAllByStandard(@RequestParam("standard")Gwiazdki gwiazdki) {
		List<Hotel> list = hotelService.getByStandard(gwiazdki);
		return list;
	}
	
	@PutMapping("/setstandard")
	void setStandard(@RequestParam("hotelId")Long id, @RequestParam("standard")Gwiazdki gwiazdki) {
		hotelService.setStandard(id, gwiazdki);
	}
	
	@PutMapping("/setdescription")
	void setDescription(@RequestParam("hotelId")Long id, @RequestParam("newDescritpion")String newDescription) {
		hotelService.setDescription(id, newDescription);
	}
}