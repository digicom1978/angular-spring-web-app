package tutorial.rest.resources.asm;


import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import tutorial.core.models.entities.BlogEntry;
import tutorial.rest.mvc.BlogEntryController;
import tutorial.rest.resources.BlogEntryResource;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;


public class BlogEntryResourceAsm extends ResourceAssemblerSupport<BlogEntry, BlogEntryResource> {
	public BlogEntryResourceAsm() {
		super(BlogEntryController.class, BlogEntryResource.class);
	}
	
	@Override
	public BlogEntryResource toResource(BlogEntry blogEntry) {
		BlogEntryResource res = new BlogEntryResource();
		res.setTitle(blogEntry.getTitle());
		Link link = linkTo(methodOn(BlogEntryController.class).getBlogEntry(blogEntry.getId())).withSelfRel();
		res.add(link.withSelfRel());
		return res;
	}

}
