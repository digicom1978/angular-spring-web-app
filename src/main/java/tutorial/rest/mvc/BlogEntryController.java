package tutorial.rest.mvc;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import tutorial.core.models.entities.BlogEntry;
import tutorial.core.services.BlogEntryService;
import tutorial.rest.resources.BlogEntryResource;
import tutorial.rest.resources.asm.BlogEntryResourceAsm;

@Controller
public class BlogEntryController {
	private BlogEntryService service;
	
	public BlogEntryController(BlogEntryService service) {
		this.service = service;
	}
	
	@RequestMapping(value="/rest/blog-entries/{blogEntryId}", 
			method = RequestMethod.GET)
	public ResponseEntity<BlogEntryResource> getBlogEntry(@PathVariable Long blogEntryId) {
		BlogEntry entry = service.findBlogEntry(blogEntryId);
		if( entry != null ) {
			BlogEntryResource res = new BlogEntryResourceAsm().toResource(entry);	
			return new ResponseEntity<BlogEntryResource>(res, HttpStatus.OK);
		} else {
			return new ResponseEntity<BlogEntryResource>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value="/rest/blog-entries/{blogEntryId}", 
			method = RequestMethod.DELETE)
	public ResponseEntity<BlogEntryResource> deleteBlogEntry(@PathVariable Long blogEntryId) {
		BlogEntry entry = service.deleteBlogEntry(blogEntryId);
		if( entry != null ) {
			BlogEntryResource res = new BlogEntryResourceAsm().toResource(entry);	
			return new ResponseEntity<BlogEntryResource>(res, HttpStatus.OK);
		} else {
			return new ResponseEntity<BlogEntryResource>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value="/rest/blog-entries/{blogEntryId}", 
			method = RequestMethod.PUT)
	public ResponseEntity<BlogEntryResource> updateBlogEntry(@PathVariable Long blogEntryId, 
															@RequestBody BlogEntryResource sentBlogEntry) {
		BlogEntry updateEntry = service.updateBlogEntry(blogEntryId, sentBlogEntry.toBlogEntry());
		if( updateEntry != null ) {
			BlogEntryResource res = new BlogEntryResourceAsm().toResource(updateEntry);	
			return new ResponseEntity<BlogEntryResource>(res, HttpStatus.OK);
		} else {
			return new ResponseEntity<BlogEntryResource>(HttpStatus.NOT_FOUND);
		}
	}
	
	
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

/**
-- Request mapping at method level
@Controller
public class BlogEntryController {
	...
	
	@RequestMapping(value="/rest/blog-entries/{blogEntryId}", 
			method = RequestMethod.GET)
	public ResponseEntity<BlogEntryResource> getBlogEntry(@PathVariable Long blogEntryId) {

...
BlogEntryResourceAsm
@Override
	public BlogEntryResource toResource(BlogEntry blogEntry) {
		BlogEntryResource res = new BlogEntryResource();
		res.setTitle(blogEntry.getTitle());
		Link link = linkTo(methodOn(BlogEntryController.class).getBlogEntry(blogEntry.getId())).withSelfRel();


-- Request mapping at class level
@Controller
@RequestMapping(value="/rest/blog-entries")
public class BlogEntryController {
	...
	
	@RequestMapping(value="/{blogEntryId}", 
			method = RequestMethod.GET)
	public ResponseEntity<BlogEntryResource> getBlogEntry(@PathVariable Long blogEntryId) {

...
BlogEntryResourceAsm
@Override
	public BlogEntryResource toResource(BlogEntry blogEntry) {
		BlogEntryResource res = new BlogEntryResource();
		res.setTitle(blogEntry.getTitle());
		Link link = linkTo(BlogEntryController.class).slash(blogEntry.getId()).withSelfRel();

 */
