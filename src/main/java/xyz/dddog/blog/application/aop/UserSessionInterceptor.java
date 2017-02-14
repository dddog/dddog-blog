package xyz.dddog.blog.application.aop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionData;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import xyz.dddog.blog.domain.model.UserSession;

public class UserSessionInterceptor extends HandlerInterceptorAdapter {

	private static final Logger logger = LoggerFactory.getLogger(UserSessionInterceptor.class);
			
	private ConnectionRepository connectionRepository;

	public UserSessionInterceptor(ConnectionRepository connectionRepository) {
		this.connectionRepository = connectionRepository;
	}

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		logger.debug("preHandle::{}",request);
		Connection<Facebook> connection;

		try {
			connection = connectionRepository.findPrimaryConnection(Facebook.class);
		} catch (Exception e) {
			connection = null;
		}

		if (connection != null) {
			ConnectionData data = connection.createData();
			UserSession userSession = new UserSession(data.getProviderUserId(), data.getImageUrl(), data.getDisplayName());
			logger.debug("UserSession : {}", userSession);
			request.setAttribute("_USER", userSession);
		}

		return true;
	}
}
