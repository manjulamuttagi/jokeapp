package guru.springframework.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import guru.springframework.services.JokeService;

@Controller
public class JokeController {
	private JokeService jokeService;
	
	@Autowired
	public JokeController (JokeService jokeService) {
		this.jokeService = jokeService;
	}
	
	@RequestMapping({"/",""})
	public String getJoke(Model model) {
		String joke = jokeService.getJoke();
		model.addAttribute("joke", joke);
		return "chucknorris";
	}
}
