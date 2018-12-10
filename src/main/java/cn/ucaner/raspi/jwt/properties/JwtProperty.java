/**
 * <html>
 * <body>
 *  <P> Copyright JasonInternational</p>
 *  <p> All rights reserved.</p>
 *  <p> Created on 2018年12月10日 上午11:02:30</p>
 *  <p> Created by Jason </p>
 *  </body>
 * </html>
 */
package cn.ucaner.raspi.jwt.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

/**     
* @Package：cn.ucaner.raspi.jwt.properties   
* @ClassName：JwtProperty   
* @Description：   <p> JwtProperty </p>
* @Author： - Jason   
* @CreatTime：2018年12月10日 上午11:02:30   
* @Modify By：   
* @ModifyTime：  2018年12月10日
* @Modify marker：   
* @version    V1.0
*/
@ConfigurationProperties(prefix = "jwt.info")
@PropertySource("classpath:/jwt/jwt.properties")
public class JwtProperty {

	/**
	 * 用户登录flag标志
	 */
	private String authorFlag;
	
    /**
     * 用户名
     */
    private String username;
    
    /**
	 * 密钥
	 */
    private String secret;
    
    
    /**
     * 过期时间
     */
    private int expireTime;

	public String getAuthorFlag() {
		return authorFlag;
	}

	public void setAuthorFlag(String authorFlag) {
		this.authorFlag = authorFlag;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	public int getExpireTime() {
		return expireTime;
	}

	public void setExpireTime(int expireTime) {
		this.expireTime = expireTime;
	}
    
}
