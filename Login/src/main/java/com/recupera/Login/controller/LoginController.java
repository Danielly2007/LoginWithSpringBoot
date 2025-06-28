package com.recupera.Login.controller;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.recupera.Login.controller.repositories.UsuarioRepository;
import com.recupera.Login.model.Usuario;
import com.recupera.Login.service.CookieService;

import org.springframework.ui.Model;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;

@Controller
public class LoginController {
	
	@Autowired
    private UsuarioRepository ur;

	@GetMapping("/login")
	public String login() {
	return "login";
	}
	
	 @GetMapping("/index")
	    public String dashboard(Model model, HttpServletRequest request) {
	       try {
			model.addAttribute("nome", CookieService.getCookie(request, "nomeUsuario" ));
		   } catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		   }
		   return "index";
	    }
	
	
	 @PostMapping("/logar")
	    public String loginUsuario(Usuario usuario, Model model, HttpServletResponse response) throws UnsupportedEncodingException {
	        Usuario usuarioLogado = this.ur.login(usuario.getEmail(), usuario.getSenha());
	        if (usuarioLogado != null) {
	            CookieService.setCookie(response, "usuarioId", String.valueOf(usuarioLogado.getId()), 3000);
 	            CookieService.setCookie(response, "usuarioNome", usuarioLogado.getNome(), 3000);
	            return "redirect:/index";
	        }
	        model.addAttribute("erro", "Usuário Inválido!");
	        return "/login";
	    }
	
	 
	 @GetMapping("/cadastroUser")
	    public String cadastro() {
	        return "cadastro";
	    }
	 
	 
	 @RequestMapping(value = "/cadastroUser", method = RequestMethod.POST)
	    public String cadastroUser(@Valid Usuario usuario, BindingResult result) {
		 
	        if (result.hasErrors()) {
	            return "redirect:/cadastroUser";  
		        
		        }
	        
	        ur.save(usuario);
	        return "redirect:/login";
	 		}
	}

	 
