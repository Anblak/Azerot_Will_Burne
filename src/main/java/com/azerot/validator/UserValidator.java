package com.azerot.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.azerot.dao.UserDao;
import com.azerot.entity.User;
@Component("userValidator")
public class UserValidator implements Validator{


	@Autowired
	private UserDao userDao;

	public void validate(Object object) throws Exception {
		User user = (User) object;
		
		if(user.getName().isEmpty()){
			throw new UserValidationException(UserValidationMessages.EMPTY_USERNAME_FIELD);
		}
		if(userDao.findByName(user.getName()) != null){
			throw new UserValidationException(UserValidationMessages.NAME_ALREADY_EXIST);
		}
		if(userDao.userExistsByEmail(user.getEmail())){
			throw new UserValidationException(UserValidationMessages.EMAIL_ALREADY_EXIST);
		}
		if(user.getEmail().isEmpty()){
			throw new UserValidationException(UserValidationMessages.EMPTY_EMAIl_FIELD);
		}
		if(user.getPassword().isEmpty()){
			throw new UserValidationException(UserValidationMessages.EMPTY_PASSWORD_FIELD);
		}
	
	}
	
}
