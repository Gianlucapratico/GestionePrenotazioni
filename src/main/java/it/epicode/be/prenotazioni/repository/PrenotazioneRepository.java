package it.epicode.be.prenotazioni.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import it.epicode.be.prenotazioni.model.Prenotazione;
import it.epicode.be.prenotazioni.model.User;

public interface PrenotazioneRepository extends PagingAndSortingRepository<Prenotazione, Long> {

	public Page<Prenotazione> findByUserAndDataPrenotata(User user, LocalDate dataPrenotata, Pageable pageable);

	public Page<Prenotazione> findByUser(User user, Pageable pageable);

	public Prenotazione save(Prenotazione prenotazione);

	public Object findById(Long id);

	public List<Prenotazione> findAll();

	public void deleteById(Long id);

	public Page<Prenotazione> findAll(java.awt.print.Pageable pageable);

}
