package com.sistema.asesoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.sistema.asesoria.usuario.UsuarioServicio;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SeguridadWeb extends WebSecurityConfigurerAdapter{
    
    @Autowired
    public UsuarioServicio usuarioServicio;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(usuarioServicio)
         .passwordEncoder( new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/css/*", "/js/","/fonts/**","/index","/bundles/**","/scss/**","/vendor/**","/img/**")
                    .permitAll()
            .antMatchers("/agendamientoFecha/**", "/agendamiento/editar/{idAgendamiento}/**" )
                    .hasAnyRole("CLIENTE", "ADMIN") //ruta DE CLIENTES

            .antMatchers("/agendamiento/**", "/agendamiento/costo/{idAgendamiento}/**", "/agendamiento/estado/{idAgendamiento}/**", "/agendamiento/estado/{idAgendamiento}/{estado}/**")
                    .hasAnyRole("ADMIN", "ING") // ruta protegida de clientes

            .antMatchers("/agendamientoconfirmar/**" , "/exportarPDF/**")
                    .hasAnyRole("ADMIN", "ING", "CLIENTE") // Ruta de todos los usuarios    

            .antMatchers("/agendamiento/nuevo/**", "/agendamiento/guardar/**", "/agendamiento/guardar/asesoria/**", "/agendamiento/eliminar/{idAgendamiento}/**", "/usuarios/estado/{id}/**", "/usuarios/eliminar/{id}/**", "/usuarios/guardar/**", "/usuarios/nuevo/**", "/usuarios/**" )
                    .hasAnyRole("ADMIN") //Rutas solo para el rol Administrador
            .and().formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/logincheck")
                .usernameParameter("email")
                .passwordParameter("password")
                .defaultSuccessUrl("/dasboard")
                .permitAll()
            .and().logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/")
                .permitAll()
            .and().csrf()
                .disable();    

    }
}
