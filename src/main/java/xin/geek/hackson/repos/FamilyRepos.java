package xin.geek.hackson.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import xin.geek.hackson.enity.Family;

public interface FamilyRepos extends JpaRepository<Family, Long> {
}