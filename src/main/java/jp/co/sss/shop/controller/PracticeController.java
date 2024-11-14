package jp.co.sss.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jp.co.sss.shop.practice.Practice;

@Controller
public class PracticeController {
	@GetMapping("/practice")
	public String practice() {
		return "practice/get";
	}

	@PostMapping("/doRegisterForm")
	public String doRegisterForm(Practice form) {
		System.out.println("氏名:" + form.getName());
		System.out.println("年齢:" + form.getAge());
		System.out.println("住所:" + form.getAddress());
		return "practice/post";
	}

}