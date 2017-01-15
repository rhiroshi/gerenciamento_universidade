package utfpr.ranking.repository.helper;

import java.util.Optional;

import utfpr.ranking.model.Login;

public interface LoginsQueries {

	public Optional<Login> porCodigoEAtivo(Long codigo);
	
}
