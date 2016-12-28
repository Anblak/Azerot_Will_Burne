package com.azerot.service;

import java.security.Principal;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.azerot.entity.User;



public interface UserService {
	void save(User user)throws Exception ;
	List<User> findAll();
	User findOne(int id);
	void delete(int id);
	
	
    User findByUUID(String uuid);

    void update(User user);

    public void saveImage(Principal principal, MultipartFile multipartFile);
}
