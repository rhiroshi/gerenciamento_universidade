package utfpr.ranking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import utfpr.ranking.model.Login;
import utfpr.ranking.repository.helper.LoginsQueries;

@Repository
public interface Logins extends JpaRepository<Login, Long>, LoginsQueries{

}
