/**
 * <html>
 * <body>
 *  <P> Copyright JasonInternational</p>
 *  <p> All rights reserved.</p>
 *  <p> Created on 2018年12月10日 上午10:54:09</p>
 *  <p> Created by Jason </p>
 *  </body>
 * </html>
 */
package cn.ucaner.raspi.jwt.filter;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import cn.ucaner.raspi.jwt.properties.JwtPatternUrl;
import cn.ucaner.raspi.jwt.properties.JwtProperty;

/**     
* @Package：cn.ucaner.raspi.jwt.filter   
* @ClassName：JWTFilter   
* @Description：   <p> JWTFilter 接口鉴权过滤器</p>
* @Author： - Jason   
* @CreatTime：2018年12月10日 上午10:54:09   
* @Modify By：   
* @ModifyTime：  2018年12月10日
* @Modify marker：   
* @version    V1.0
*/
public class JWTFilter implements  Filter{

    @Autowired
    private JwtProperty jwtProperty;

    /**
     * jwt需要做处理的连接
     */
    @Autowired
    private JwtPatternUrl jwtPatternUrl;
    
    
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("init");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest)request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        if("OPTIONS".equals(httpRequest.getMethod())) {
            chain.doFilter(httpRequest, httpResponse);
            return;
        }
        String url = httpRequest.getRequestURI().substring(httpRequest.getContextPath().length());
		if (isInclude(url)) {
            chain.doFilter(httpRequest, httpResponse);
            System.out.println("UUURRRLLLdoFilter");
            return;
		}
		System.out.println(jwtProperty.getAuthorFlag());
	}

	@Override
	public void destroy() {
		System.out.println("destroy");
	}
	
	 /**
     * 是否需要过滤
     * @param url
     * @return
     */
    private boolean isInclude(String url) {
    	if (jwtPatternUrl!=null) {
    		for (String patternUrl : jwtPatternUrl.getUrlPatterns()) {
                Pattern p = Pattern.compile(patternUrl);
                 Matcher m = p.matcher(url);
                if (m.find()) {
                    return true;
                }
            }
		}else {
			return true;
		}
    	return false;
        
    }

}
