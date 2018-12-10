/**
 * <html>
 * <body>
 *  <P> Copyright JasonInternational</p>
 *  <p> All rights reserved.</p>
 *  <p> Created on 2018年12月10日 上午10:58:47</p>
 *  <p> Created by Jason </p>
 *  </body>
 * </html>
 */
package cn.ucaner.raspi.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cn.ucaner.raspi.jwt.filter.JWTFilter;

/**     
* @Package：cn.ucaner.raspi.config   
* @ClassName：JwtConfig   
* @Description：   <p> jwt 过滤器配置</p>
* @Author： - Jason   
* @CreatTime：2018年12月10日 上午10:58:47   
* @Modify By：   
* @ModifyTime：  2018年12月10日
* @Modify marker：   
* @version    V1.0
*/
@Configuration
public class JwtConfig {
	
	/**
	 * @Description: Jwt 过滤器
	 * @return FilterRegistrationBean<JWTFilter>
	 * @Autor: Jason
	 */
    @Bean
    public FilterRegistrationBean<JWTFilter> basicFilterRegistrationBean(){
        FilterRegistrationBean<JWTFilter> registrationBean = new FilterRegistrationBean<JWTFilter>();
        JWTFilter filter = new JWTFilter();
        registrationBean.setFilter(filter);
        List<String> urlPatterns = new ArrayList<>();
        urlPatterns.add("/*");
        registrationBean.setUrlPatterns(urlPatterns);
        return registrationBean;
    }

}
