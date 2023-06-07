import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.epicode.be.prenotazioni.model.Prenotazione;

@RestController
@RequestMapping("/prenotazioni")
public class PrenotazioneController {
	@Autowired
	private PrenotazioneService prenotazioneService;

	@PostMapping
	public ResponseEntity<Prenotazione> createPrenotazione(@RequestBody Prenotazione prenotazione) {
		Prenotazione createdPrenotazione = prenotazioneService.createPrenotazione(prenotazione);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdPrenotazione);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Prenotazione> getPrenotazioneById(@PathVariable("id") Long id) {
		Prenotazione prenotazione = prenotazioneService.getPrenotazioneById(id);
		return ResponseEntity.ok(prenotazione);
	}

	@GetMapping
	public ResponseEntity<List<Prenotazione>> getAllPrenotazioni() {
		List<Prenotazione> prenotazioni = prenotazioneService.getAllPrenotazioni();
		return ResponseEntity.ok(prenotazioni);
	}

	@GetMapping("/paginate")
	public ResponseEntity<Page<Prenotazione>> getPrenotazioniPaginate(@RequestParam(defaultValue = "0") int pageNumber,
			@RequestParam(defaultValue = "10") int pageSize, @RequestParam(defaultValue = "id") String sortBy,
			@RequestParam(defaultValue = "asc") String sortOrder) {
		Page<Prenotazione> prenotazioni = prenotazioneService.getPrenotazioniPaginate(pageNumber, pageSize, sortBy,
				sortOrder);
		return ResponseEntity.ok(prenotazioni);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletePrenotazione(@PathVariable("id") Long id) {
		prenotazioneService.deletePrenotazione(id);
		return ResponseEntity.noContent().build();
	}
}
