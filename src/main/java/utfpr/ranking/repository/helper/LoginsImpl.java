package utfpr.ranking.repository.helper;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import utfpr.ranking.model.Login;

public class LoginsImpl implements LoginsQueries{

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public Optional<Login> porCodigoEAtivo(Long codigo) {
		return manager
				.createQuery("from Login where id = :id and ativo = true", Login.class)
				.setParameter("id", codigo).getResultList().stream().findFirst();
	}

}
