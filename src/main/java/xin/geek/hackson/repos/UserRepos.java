package xin.geek.hackson.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import xin.geek.hackson.enity.User;

import java.util.List;

public interface UserRepos extends JpaRepository<User, String> {

    List<User> findByFamilyId(String familyId);
}
