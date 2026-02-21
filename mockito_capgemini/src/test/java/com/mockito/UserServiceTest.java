package com.mockito;

import mockito.User;
import mockito.UserDao;

public class UserServiceTest {	
	public void typeOfUser() {
		UserDao daomock=mock(UserDao.class);
		User fakeObject=new User();
		fakeObject.setId(1);
		fakeObject.setBalance(2000);
		fakeObject.setName("Allen");
		
		
		
		wheb(daomock.findById(1)).thenReturn(fakeObject);
		
	}
	
	
}
