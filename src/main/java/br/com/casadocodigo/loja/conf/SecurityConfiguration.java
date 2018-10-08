package br.com.casadocodigo.loja.conf;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/*
 * Responsibly for configuration security.
 */
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/resources/**").permitAll()
		.antMatchers("/carrinho").permitAll()
		.antMatchers("/pagamento/**").permitAll()
		.antMatchers(HttpMethod.POST, "/produtos").hasAnyRole("ADMIN")
		.antMatchers(HttpMethod.GET,"/produtos").hasAnyRole("ADMIN")
		.antMatchers("/produtos/**").permitAll()
		.antMatchers("/").permitAll()
		.anyRequest().authenticated().and().formLogin();
		super.configure(http);
	}
}
