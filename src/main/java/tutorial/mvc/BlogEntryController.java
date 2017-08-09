package tutorial.mvc;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import tutorial.entities.BlogEntry;

@Controller
public class BlogEntryController {

	// Origin from TestController
/*	@RequestMapping("/test")
	public String test() {
		return "view";
	}*/

	// Make use json mapping by returning Entity
/*	@RequestMapping("/test")
	public ResponseEntity<Object> test() {
		BlogEntry entry = new BlogEntry();
		entry.setTitle("Test Blog Entry");
		return new ResponseEntity<Object>(entry, HttpStatus.OK);
	}*/


	// Make use json mapping by specifying response body
/*	@RequestMapping("/test")
	public @ResponseBody BlogEntry test() {
		BlogEntry entry = new BlogEntry();
		entry.setTitle("Test Blog Entry");
		return entry;
	}*/
	
	// Make use json mapping by specifying response body
	// Plus specifying request body(that I want to receive)
	@RequestMapping(value="/test", method = RequestMethod.POST)
	public @ResponseBody BlogEntry test(@RequestBody BlogEntry entry) {
		
		return entry;
	}
}
