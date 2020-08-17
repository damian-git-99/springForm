package com.bolsadeideas.springboot.form.app.interceptors;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;





@Component
public class TiempoTranscurridoInterceptor implements HandlerInterceptor{
	
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TiempoTranscurridoInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		logger.info("TiempoTranscurridoInterceptor: preHandle() entrando...");
		Long timpoInicio = System.currentTimeMillis();
		request.setAttribute("timpoInicio", timpoInicio);
		Random random = new Random();
		Integer demora = random.nextInt(500);
		Thread.sleep(demora);
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		Long timpoInicio = (Long)request.getAttribute("timpoInicio");
		Long timpoFin = System.currentTimeMillis();
		long tiempoTranscurrido = timpoFin - timpoInicio;
		if (modelAndView!=null) {
			modelAndView.addObject("tiempoTranscurrido",tiempoTranscurrido);
		}
		logger.info("Tiempo Transcurrido: "+tiempoTranscurrido+" milisegundos");
		logger.info("TiempoTranscurridoInterceptor: postHandle() saliendo...");
	}
	
}
