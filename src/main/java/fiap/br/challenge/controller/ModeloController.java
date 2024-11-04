package fiap.br.challenge.controller;

import org.springframework.ai.image.ImageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fiap.br.challenge.service.ImageGenerationService;

@Controller
@RequestMapping("/modelos")
public class ModeloController {
    
    @Autowired
    private ImageGenerationService imageGenerationService;

    @GetMapping("/gerarmodelo")
    public String carregaTemplateGerarModelo() {
        return "gerarmodelo"; 
    }

    @PostMapping("/gerarmodelo")
    public String gerarModelo(@RequestParam("prompt") String prompt, Model model) {

    	 String imageUrl = imageGenerationService.generateImage(prompt);

         model.addAttribute("prompt", prompt);
         model.addAttribute("imageUrl", imageUrl);

        return "gerarmodelo";
    }
}
