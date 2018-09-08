package com.app.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionCheckFilter implements Filter{

	List<String> uris=null;

	@Override
	public void init(FilterConfig cfg) throws ServletException {
		
		String s=cfg.getInitParameter("NoCheckUris");
		StringTokenizer st=new StringTokenizer(s,",");
		
		uris=new ArrayList<String>();
		
		while (st.hasMoreElements()) {
			String sf=st.nextToken();
			uris.add(sf);
		}
				
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain fc) throws IOException, ServletException {
		HttpServletRequest hreq=(HttpServletRequest)req;
		HttpServletResponse hres=(HttpServletResponse)res;
		
		/*cache clear on logout*/
		hres.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); 
		hres.setHeader("Pragma", "no-cache");	
		hres.setDateHeader("Expires", 0);
		
		String uri=hreq.getRequestURI();
		
		boolean b=uris.contains(uri);
		

		
		try {
			if(!b){
				HttpSession ses=hreq.getSession(false);
				if(ses==null || ses.getAttribute("userName")==null){
					hres.sendRedirect(hreq.getContextPath()+"/mvc/showLogin");
				}
			}
		} catch (Exception e) {
		}
		fc.doFilter(req, res);

	}

	@Override
	public void destroy() {
		uris=null;
	}

}