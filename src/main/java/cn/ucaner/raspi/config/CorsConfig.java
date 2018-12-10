/**
 * <html>
 * <body>
 *  <P> Copyright JasonInternational</p>
 *  <p> All rights reserved.</p>
 *  <p> Created on 2018年12月10日 上午10:08:59 https://github.com/Jasonandy </p>
 *  <p> Created by Jason </p>
 *  </body>
 * </html>
 */
package cn.ucaner.raspi.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**     
* @Package：cn.ucaner.raspi.config   
* @ClassName：CorsConfig   
* @Description：   <p> 跨域配置 </p>
* @Author： - Jason   
* @CreatTime：2018年12月10日 上午10:08:59   
* @Modify By：   
* @ModifyTime：  2018年12月10日
* @Modify marker：   
* @version    V1.0
*/
@Configuration
public class CorsConfig {
	
	private static final Logger logger = LoggerFactory.getLogger(CorsConfig.class);
	
	
	private CorsConfiguration buildConfig() {
	    CorsConfiguration corsConfiguration = new CorsConfiguration();
	    corsConfiguration.setAllowCredentials(true);
	    //corsConfiguration.addAllowedOrigin("http://ucaner.cn/");
	    corsConfiguration.addAllowedOrigin(CorsConfiguration.ALL); // 1. 设置访问源地址 [支持All]
	    corsConfiguration.addAllowedHeader(CorsConfiguration.ALL); // 2. 设置访问源请求头 [支持All]
	    corsConfiguration.addAllowedMethod(CorsConfiguration.ALL); // 3. 设置访问源请求方法 [支持All]
	    return corsConfiguration;
	}

	    
	/**
	 * @Description: corsFilter  CorsConfiguration 和 UrlBasedCorsConfigurationSource。
	 * @return CorsFilter
	 * @Autor: jasonandy@hotmail.com
	 */
	public CorsFilter bulidFilter() {
	    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	    source.registerCorsConfiguration("/**", buildConfig()); // 4 对接口配置跨域设置
	    return new CorsFilter(source);
	}
	    
	    
	/**
	 * @Description: FilterRegistrationBean   Integer.MIN_VALUE 过滤器的优先级  最高 
	 * @return FilterRegistrationBean
	 * @Autor: jasonandy@hotmail.com
	 */
	@SuppressWarnings("rawtypes")
	@Bean
	public FilterRegistrationBean corsFilter() {
		@SuppressWarnings("unchecked")
		FilterRegistrationBean bean = new FilterRegistrationBean(bulidFilter());
		bean.setOrder(Ordered.HIGHEST_PRECEDENCE); //Integer.MIN_VALUE 过滤器的优先级  最高
		logger.info(">>> corsFilter 跨域Fliter成功加入 >>>");
		return bean;
	}
}
