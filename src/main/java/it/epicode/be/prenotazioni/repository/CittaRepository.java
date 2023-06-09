package it.epicode.be.prenotazioni.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import it.epicode.be.prenotazioni.model.Citta;

public interface CittaRepository extends PagingAndSortingRepository<Citta, Long> {

	public Page<Citta> findByNome(String nome, Pageable pageable);

	public int count();

	public void save(Citta citta);

	public Optional<Citta> findById(long l);

}
