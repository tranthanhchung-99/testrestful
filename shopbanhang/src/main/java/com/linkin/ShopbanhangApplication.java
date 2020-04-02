package com.linkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ShopbanhangApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopbanhangApplication.class, args);// ơ sao lại viết code trong này làm security, viết file riêng
	}

//	@Autowired
//	private UserDetailsService userDetailsService;
//
//	@Autowired
//	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
//	}
//
//	public void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests().antMatchers("/admin/**").hasAnyAuthority(RoleEnum.ADMIN.getRoleName())
//				.antMatchers("/member/**").authenticated().anyRequest().permitAll().and().formLogin()
//				.loginPage("/login").loginProcessingUrl("/login").defaultSuccessUrl("/member/home")
//				.failureUrl("/login?err").and().logout().logoutUrl("/logout").logoutSuccessUrl("/login")
//				.logoutRequestMatcher(new AntPathRequestMatcher("/logout")).permitAll().and().exceptionHandling()
//				.accessDeniedPage("/login?deny");
//	}
//
//	@Bean
//	public BCryptPasswordEncoder passwordEncoder() { 	
//		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(12);
//		return bCryptPasswordEncoder;
//	}
//
//	@Bean
//	public SpringSecurityDialect springSecurityDialect() {
//		SpringSecurityDialect dialect = new SpringSecurityDialect();
//		return dialect;
//	}

}
