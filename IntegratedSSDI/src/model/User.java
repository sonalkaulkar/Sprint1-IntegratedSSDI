package model;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

public interface User {
	RequestDispatcher directUser(HttpServletRequest request);
}
