package tutorial.core.repositories;

import tutorial.core.models.entities.Account;
import tutorial.core.models.entities.Blog;

public interface AccountRepo {
	public Account findAccount(Long id);
	public Account createAccount(Account data);
	public Blog createBlog(Long accoundId, Blog data);
}
