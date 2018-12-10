/**
 * <html>
 * <body>
 *  <P> Copyright JasonInternational</p>
 *  <p> All rights reserved.</p>
 *  <p> Created on 2018年12月10日 上午11:03:43</p>
 *  <p> Created by Jason </p>
 *  </body>
 * </html>
 */
package cn.ucaner.raspi.jwt.properties;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

/**     
* @Package：cn.ucaner.raspi.jwt.properties   
* @ClassName：JwtPatternUrl   
* @Description：   <p> JwtPatternUrl 需要做鉴权的url</p>
* @Author： - Jason   
* @CreatTime：2018年12月10日 上午11:03:43   
* @Modify By：   
* @ModifyTime：  2018年12月10日
* @Modify marker：   
* @version    V1.0
*/
@ConfigurationProperties(prefix = "jwt.exclude")
@PropertySource("classpath:/jwt/jwt.properties")
public class JwtPatternUrl {

	/**
	 * 需要过滤的url
	 */
	private List<String> urlPatterns;

    public List<String> getUrlPatterns() {
        return urlPatterns;
    }
    
    public void setUrlPatterns(List<String> urlPatterns) {
        this.urlPatterns = urlPatterns;
    }

}
