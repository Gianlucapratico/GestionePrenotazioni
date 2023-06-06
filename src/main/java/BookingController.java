
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingController {
	@Value("${booking.rules.italian}")
	private String italianRules;

	@Value("${booking.rules.english}")
	private String englishRules;

	@GetMapping("/booking-rules")
	public ResponseEntity<String> getBookingRules(@RequestParam("lingua") String language) {
		String response;
		if (language.equalsIgnoreCase("italiano")) {
			response = italianRules;
		} else if (language.equalsIgnoreCase("english")) {
			response = englishRules;
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Lingua non supportata.");
		}
		return ResponseEntity.ok(response);
	}
}
