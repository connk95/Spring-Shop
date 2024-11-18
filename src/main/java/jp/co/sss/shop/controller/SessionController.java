package jp.co.sss.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import jp.co.sss.shop.form.LoginForm;
import jp.co.sss.shop.form.LoginFormWithAnnotation;
import jp.co.sss.shop.form.LoginFormWithValidation;

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

	@GetMapping("/loginWithValidation")
	public String loginWithValidation(@ModelAttribute LoginFormWithValidation form) {
		return "session/loginWithValidation";
	}

	@PostMapping("/loginWithValidation")
	public String doLoginWithValidation(@Valid @ModelAttribute LoginFormWithValidation form, BindingResult result,
			HttpSession session) {
		if (result.hasErrors()) {
			return "session/loginWithValidation";
		}
		if (form.getUserId() == 123) {
			//入力したユーザ ID をセッション属性 userId としてセッションスコープに保存
			session.setAttribute("userId", form.getUserId());
			return "redirect:/";
		} else {
			return "session/loginWithValidation";
		}
	}

	@GetMapping("/loginWithAnnotation")
	public String loginWithAnnotation(@ModelAttribute LoginFormWithAnnotation form) {
		return "session/loginWithAnnotation";
	}
	
	@PostMapping("/loginWithAnnotation")
	public String doLoginWithAnnotation(@Valid @ModelAttribute LoginFormWithAnnotation form,
			BindingResult result, HttpSession session) {
		if (result.hasErrors()) {
			return "session/loginWithAnnotation";
		}
		if (form.getUserId() == 123) {
			//入力したユーザ ID をセッション属性 userId としてセッションスコープに保存
			session.setAttribute("userId", form.getUserId());
			return "redirect:/";
		} else {
			return "session/loginWithAnnotation";
		}
	}

}