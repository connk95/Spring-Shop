package jp.co.sss.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpSession;
import jp.co.sss.shop.form.LoginForm;

@Controller
public class SessionController {
	@GetMapping("/login")
	public String login() {
		return "session/login";
	}

	@GetMapping("/doLogin")
	public String doLoginGet(Integer userId) {
		System.out.println("ユーザ ID:" + userId);
		return "session/login";
	}

	@PostMapping("/login")
	public String doLoginPost(Integer userId) {
		System.out.println("ユーザ ID:" + userId);
		return "session/login";
	}

	@GetMapping("/loginUsingForm")
	public String loginUsingForm() {
		return "session/loginUsingForm";
	}

	@PostMapping("/doLoginUsingForm")
	public String doLoginUsingForm(LoginForm form) {
		System.out.println("ユーザ ID:" + form.getUserId());
		System.out.println("パスワード:" + form.getPassword());
		return "session/loginUsingForm";
	}

	@GetMapping("/loginOnRequest")
	public String loginOnRequest() {
		return "session/loginOnRequest";
	}

	@PostMapping("/doLoginOnRequest")
	public String doLoginOnRequest(LoginForm form, Model model) {
		model.addAttribute("userId", form.getUserId());
		return "session/loginOnRequest";
	}

	@GetMapping("/loginOnSession")
	public String loginOnSession() {
		return "session/loginOnSession";
	}

	@PostMapping("/doLoginOnSession")
	public String doLoginOnSession(LoginForm form, HttpSession session) {
		if (form.getUserId() == 123) {
			//入力したユーザ ID をセッション属性 userId としてセッションスコープに保存
			session.setAttribute("userId", form.getUserId());
			return "redirect:/";
		} else {
			return "session/loginOnSession";
		}
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		//セッションの破棄
		session.invalidate();
		return "redirect:/";
	}

}