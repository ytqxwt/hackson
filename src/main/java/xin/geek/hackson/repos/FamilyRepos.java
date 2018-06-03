package xin.geek.hackson.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import xin.geek.hackson.enity.Family;

import java.util.List;

public interface FamilyRepos extends JpaRepository<Family, String> {

    @Query(value = "select openid from user where family_id =?1"
            , nativeQuery = true)
    List<String> getFamilyMember(String familyId);


}