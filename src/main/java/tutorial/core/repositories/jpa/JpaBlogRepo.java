package tutorial.core.repositories.jpa;

import org.springframework.stereotype.Repository;
import tutorial.core.models.entities.Blog;
import tutorial.core.repositories.BlogRepo;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;




@Repository
public class JpaBlogRepo implements BlogRepo {
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Blog createBlog(Blog data) {
System.out.println("blog 1 data.id: "+data.getId());
		em.persist(data);
System.out.println("blog 2 data.id: "+data.getId());
		return data;
	}
	
	@Override
	public List<Blog> findAllBlogs() {
		Query query = em.createQuery("SELECT b FROM Blog b");
		return query.getResultList();
	}
	
	@Override
	public Blog findBlog(Long id) {
		return em.find(Blog.class, id);
	}
	
	@Override
	public Blog findBlogByTitle(String title) {
		Query query = em.createQuery("SELECT b FROM Blog b WHERE b.title=?1");
		query.setParameter(1, title);
		List<Blog> blogs = query.getResultList();
		if(blogs.isEmpty()) {
			return null;
		} else {
			return blogs.get(0);
		}
	}
	
	@Override
	public List<Blog> findBlogsByAccount(Long accoundId) {
		Query query = em.createQuery("SELECT b FROM Blog b WHERE b.owner.id=?1");
		query.setParameter(1, accoundId);
		return query.getResultList();
	}
}