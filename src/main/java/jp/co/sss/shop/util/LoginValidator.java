package jp.co.sss.shop.util;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class LoginValidator implements ConstraintValidator<Login, Object> {
	private String userId;
	private String password;

	@Override
	public void initialize(Login annotation) {
		this.userId = annotation.fieldUserId();
		this.password = annotation.fieldPassword();
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		BeanWrapper beanWrapper = new BeanWrapperImpl(value);
		Integer userId = (Integer) beanWrapper.getPropertyValue(this.userId);
		String password = (String) beanWrapper.getPropertyValue(this.password);
		if (userId != null && userId == 123 && "test123".equals(password)) {
			return true;
		} else {
			return false;
		}
	}
}