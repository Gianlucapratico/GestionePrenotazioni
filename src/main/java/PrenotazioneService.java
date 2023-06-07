import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import it.epicode.be.prenotazioni.model.Prenotazione;
import it.epicode.be.prenotazioni.repository.PrenotazioneRepository;

@Service
public class PrenotazioneService {
	@Autowired
	private PrenotazioneRepository prenotazioneRepository;

	public Prenotazione createPrenotazione(Prenotazione prenotazione) {
		return prenotazioneRepository.save(prenotazione);
	}

	public Prenotazione getPrenotazioneById(Long id) {
		Optional<Prenotazione> prenotazioneOptional = (Optional<Prenotazione>) prenotazioneRepository.findById(id);
		return prenotazioneOptional
				.orElseThrow(() -> new NoSuchElementException("Prenotazione non trovata con ID: " + id));
	}

	public List<Prenotazione> getAllPrenotazioni() {
		return prenotazioneRepository.findAll();
	}

	public Page<Prenotazione> getPrenotazioniPaginate(int pageNumber, int pageSize, String sortBy, String sortOrder) {
		Sort.Direction direction = sortOrder.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
		PageRequest pageable = PageRequest.of(pageNumber, pageSize, Sort.by(direction, sortBy));
		return prenotazioneRepository.findAll(pageable);
	}

	public void deletePrenotazione(Long id) {
		prenotazioneRepository.deleteById(id);
	}
}
