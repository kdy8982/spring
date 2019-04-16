
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
	
	/*글 목록*/
	/**
	 * 게시글 전체 조회(목록)
	 * @param model
	 * @param curPage
	 * @return
	 */
	@RequestMapping("list")
	public String list(Model model, @RequestParam(value="pid", defaultValue="1") int curPage ) {
		model.addAttribute("postList", postService.list(curPage));
		model.addAttribute("pageIndex",postService.pageIndex(curPage));
		System.out.println("zzzzzzzzzz");
		return "post/list";
	}
	
	
	/**
	 * 게시글 하나 조회
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping("/detail/{id}")
	public String get(Model model, @PathVariable int id ) {
		model.addAttribute("post", postService.get(id));
		return "post/detail";
	}
	
	
	/**
	 * 게시글 쓰기 페이지 
	 * @param model
	 * @return
	 */
	@RequestMapping("/form")
	public String form(Model model) {
		model.addAttribute("post", new Post());
		return "post/form";
	}
	
	/**
	 * 게시글 쓰기 submit 요청
	 * @param post
	 * @param result
	 * @return
	 */
	@RequestMapping("/post")
	public String formSubmit(@Valid Post post, BindingResult result) {
		if(result.hasErrors()) {
			return "post/form";
		} else {
			postService.add(post);
			return "redirect:list.do";
		}
	}
	
	
	/**
	 * 게시글 하나 삭제
	 * @param post
	 */
	@RequestMapping("/delete")
	public void delete(Post post) {
		postService.delete(post); 
	}

}
