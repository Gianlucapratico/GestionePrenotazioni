/*
 * import static org.mockito.Mockito.when;
 * 
 * import org.junit.jupiter.api.Test; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest; import
 * org.springframework.boot.test.mock.mockito.MockBean; import
 * org.springframework.http.MediaType; import
 * org.springframework.test.web.servlet.MockMvc; import
 * org.springframework.test.web.servlet.request.MockMvcRequestBuilders; import
 * org.springframework.test.web.servlet.result.MockMvcResultMatchers;
 * 
 * @WebMvcTest(BookingController.class) public class
 * BookingControllerTest<BookingService> {
 * 
 * @Autowired private MockMvc mockMvc;
 * 
 * @MockBean private BookingService bookingService;
 * 
 * @Test public void testGetBookingRulesItalian() throws Exception {
 * when(bookingService.getBookingRules(toString())).
 * thenReturn("Regole di prenotazione in italiano.");
 * 
 * mockMvc.perform(MockMvcRequestBuilders.get("/booking-rules") .param("lingua",
 * "italiano") .accept(MediaType.TEXT_PLAIN))
 * .andExpect(MockMvcResultMatchers.status().isOk())
 * .andExpect(MockMvcResultMatchers.content().
 * string("Regole di prenotazione in italiano.")); }
 * 
 * @Test public void testGetBookingRulesEnglish() throws Exception {
 * when(bookingService.getBookingRules(toString())).
 * thenReturn("Booking rules in English.");
 * 
 * mockMvc.perform(MockMvcRequestBuilders.get("/booking-rules") .param("lingua",
 * "english") .accept(MediaType.TEXT_PLAIN))
 * .andExpect(MockMvcResultMatchers.status().isOk())
 * .andExpect(MockMvcResultMatchers.content().string("Booking rules in English."
 * )); }
 * 
 * @Test public void testGetBookingRulesUnsupportedLanguage() throws Exception {
 * when(((BookingController)
 * bookingService).getBookingRules(toString())).thenThrow(new
 * UnsupportedLanguageException("Unsupported language."));
 * 
 * mockMvc.perform(MockMvcRequestBuilders.get("/booking-rules") .param("lingua",
 * "french") .accept(MediaType.TEXT_PLAIN))
 * .andExpect(MockMvcResultMatchers.status().isBadRequest()); } }
 */