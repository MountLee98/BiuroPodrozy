package biuro.podrozy.projekt.service;

import java.io.File;
import java.time.LocalDate;
import java.util.List;

import biuro.podrozy.projekt.model.Hotel;
import biuro.podrozy.projekt.model.Typ;
import biuro.podrozy.projekt.model.Wycieczka;

public interface WycieczkaService {

	List<Wycieczka> getAll();
	void addWycieczka(Long idFrom, Long idTo, Long idHotel, Wycieczka wyc);
	List<Wycieczka> getByHotel(Hotel hotel);
	void addHotel(Long idWyc, Long idHotel);
	void addFrom(Long idWyc, Long idLotn);
	void addTo(Long idWyc, Long idLotn);
	List<Wycieczka> getByDepartureDate(LocalDate date);
	void addDepartureDate(Long id, LocalDate date);
	List<Wycieczka> getByReturnDate(LocalDate date);
	void addReturnDate(Long id, LocalDate date);
	void setDuration(Long id, LocalDate departureDate, int days);
	List<Wycieczka> getByType(Typ type);
	void addType(Long id, Typ type);
	List<Wycieczka> getByAdultPrice(float price);
	void addAdultPrice(Long id, float price);
	List<Wycieczka> getByKidPrice(float price);
	void addKidPrice(Long id, float price);
	List<Wycieczka> getByAdultSeats(int seatsAmount);
	void addAdultSeats(Long id, int seatsAmount);
	List<Wycieczka> getByKidSeats(int seatsAmount);
	void addKidSeats(Long id, int seatsAmount);
	List<Wycieczka> getByIsPromoted(boolean isPromoted);
	void addIsPromoted(Long id, boolean isPromoted);
	void addPicture(Long id, File picture);
	Wycieczka getById(Long id);
	boolean deleteById(Long id);
	
}
