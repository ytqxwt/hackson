package xin.geek.hackson.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import xin.geek.hackson.enity.User;

public interface UserRepos extends JpaRepository<User, String> {
}
