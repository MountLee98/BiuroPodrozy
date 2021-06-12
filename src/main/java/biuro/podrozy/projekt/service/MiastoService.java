package biuro.podrozy.projekt.service;

import java.util.List;

import biuro.podrozy.projekt.model.Miasto;

public interface MiastoService {
	
	List<Miasto> getAll();
	void addMiasto(Long id, Miasto miasto);
	Miasto getById(Long id);
	Miasto getByName(String name);
	void setName(Long id, String name);
	boolean deleteById(Long id);
}
