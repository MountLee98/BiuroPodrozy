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

import biuro.podrozy.projekt.model.Kraj;
import biuro.podrozy.projekt.model.Miasto;
import biuro.podrozy.projekt.service.HotelService;
import biuro.podrozy.projekt.service.KontynentService;
import biuro.podrozy.projekt.service.KrajService;
import biuro.podrozy.projekt.service.LotniskoService;
import biuro.podrozy.projekt.service.MiastoService;
import biuro.podrozy.projekt.service.UczestnikService;
import biuro.podrozy.projekt.service.WycieczkaService;
import biuro.podrozy.projekt.service.ZakupWycieczkiService;

@RequestMapping("/rest/miasto")
@RestController
public class MiastoController {

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
	List<Miasto> getAllCity() {
		List<Miasto> list = miastoService.getAll();
		return list;
	}
	
	@PostMapping("/addmiasto")
	void addCity(@RequestParam("countryId")Long id, @RequestParam("name")String name) {		
		miastoService.addMiasto(id, new Miasto(name));
	}
	
	@GetMapping("/getbyid")
	Miasto getById(@RequestParam("cityId")Long id) {
		Miasto miasto = miastoService.getById(id);
		return miasto;
	}
	
	@GetMapping("/getbyname")
	Miasto getByName(@RequestParam("name")String name) {
		Miasto miasto = miastoService.getByName(name);
		return miasto;
	}
	
	@PutMapping("/setname")
	void setName(@RequestParam("cityId")Long id, @RequestParam("newName")String newName) {
		miastoService.setName(id, newName);
	}
	
	@DeleteMapping("/deletecity")
	boolean deleteCity(@RequestParam("cityId")Long id) {
		return miastoService.deleteById(id);
	}
}
