
package com.sample.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/post")
public class PostController {
	
	@Autowired
	PostService postService;
	
	@RequestMapping("list")
	public String list(Model model) {
		model.addAttribute("postList", postService.list());
		return "post/list";
	}
	
	
	@RequestMapping("/detail/{id}")
	public String get(Model model, @PathVariable int id ) {
		model.addAttribute("post", postService.get(id));
		return "post/detail";
	}

}
