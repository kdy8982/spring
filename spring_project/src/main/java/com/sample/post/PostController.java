
package com.sample.post;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sample.domain.Post;

@Controller
@RequestMapping("/post")
public class PostController {
	
	@Autowired
	PostService postService;
	
	@RequestMapping("list")
	public String list(Model model, @RequestParam(value="pid", defaultValue="1") int curPage ) {
		model.addAttribute("postList", postService.list(curPage));
		model.addAttribute("pageIndex",postService.pageIndex(curPage));
		return "post/list";
	}
	
	
	@RequestMapping("/detail/{id}")
	public String get(Model model, @PathVariable int id ) {
		model.addAttribute("post", postService.get(id));
		return "post/detail";
	}
	
	@RequestMapping("/form")
	public String form(Model model) {
		model.addAttribute("post", new Post());
		return "post/form";
	}
	
	@RequestMapping("/post")
	public String formSubmit(@Valid Post post, BindingResult result) {
		if(result.hasErrors()) {
			return "post/form";
		} else {
			postService.add(post);
			return "redirect:list.do";
		}
		
	}

}
