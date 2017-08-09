package tutorial.core.services;

import tutorial.core.models.entities.Account;
import tutorial.core.models.entities.Blog;

public interface AccountService {
	public Account findAccount(Long id);
	public Account createAccount(Account data);
	public Blog createBlog(Long accountId, Blog data);
}
