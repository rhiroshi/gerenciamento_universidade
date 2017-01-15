package utfpr.ranking.security;

import java.util.HashSet;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import utfpr.ranking.model.Login;
import utfpr.ranking.repository.Logins;

@Service
public class AppUserDetailsService implements UserDetailsService{

	@Autowired
	private Logins logins;
	
	@Override
	public UserDetails loadUserByUsername(String codigo) throws UsernameNotFoundException {
		Optional<Login> loginOptional = logins.porCodigoEAtivo(Long.parseLong(codigo));
		Login login = loginOptional.orElseThrow(() -> new UsernameNotFoundException("Login e/ou Senha incorretos"));
		return new User(login.getId().toString(), login.getSenha(), new HashSet<>());
	}
	
}
