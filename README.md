<p align=center>
  <a href="https://github.com/Jasonandy/Raspi-X.git">
    <img src="https://raw.githubusercontent.com/Jasonandy/Note-X/master/Media/gif/logo.gif" width="680" height="120" alt="Raspi-X" >
  </a>
</p>

<p align=center>
    You are what you want to be. -wb
</p>

<p align="center">
	<a href="https://github.com/Jasonandy/Note-X.git"><img src="https://img.shields.io/badge/Build-Passing-green.svg?style=for-the-badge" alt=""></a>
	<a href="https://github.com/Jasonandy/Note-X.git"><img src="https://img.shields.io/badge/Author-Jason-orange.svg?style=for-the-badge" alt=""></a>
	<a href="https://github.com/Jasonandy/Note-X.git"><img src="https://img.shields.io/badge/Version-V1.0.0-blue.svg?style=for-the-badge" alt=""></a>
</p>

[Home Page](https://github.com/Jasonandy/Raspi-X.git) | [英文说明](https://github.com/Jasonandy/Raspi-X/blob/master/Media/docs/README-EN.md) | [相关文档](https://github.com/Jasonandy/Note-X/blob/master/docs/) | [历史版本](https://github.com/Jasonandy/Raspi-X.git)

# Raspi-X 
* Project：Raspi-X
* OfficialWebsite：http://raspi.ucaner.cn
* Describe： 树莓派平台 


## 一、Raspi-X 简介

	Raspi-X 这个项目是基于Spring-boot搭建的JavaWeb后台控制项目!
旨在通过Springboot搭建web服务端,通过内网穿透的方式,web端远程控制树莓派执行相关的操作。

> 树莓派2B
> USB线
> LED
> 路由器
> 树莓派Raspbain
> 数字电路基础
> 单片机基础
> C51 汇编


## 二、进度安排

> 技术清单
- [X] Spring-boot2.0
- [X] Pi4j
- [X] GPIO
- [X] JWT鉴权
- [X] JavaWeb后台



[RaspiX](https://github.com/Jasonandy/Cloud-X)


## 三、部署相关

> You are what you want to be.

* 1.树莓派Linux环境的搭建

* 2.PI4J环境的搭建

* 3.spring-boot部署

``` xml
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	
	<!-- raspi  -->
	<groupId>cn.ucaner.raspi</groupId>
	<artifactId>raspi</artifactId>
	<version>1.0.0-SNAPSHOT</version>
	<packaging>jar</packaging>
	<name>Raspiberry 2b+</name>
	<description>This  is  a RaspiRaspiberry 2b+   </description>
	
	<!--  spring-boot-starter-parent  -->
	<parent>
	    <groupId>org.springframework.boot</groupId>
	    <artifactId>spring-boot-starter-parent</artifactId>
	    <version>2.0.0.RELEASE</version>
	    <relativePath/>
	</parent>

	<!--  PROPERTIES -->
    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
        <java.version>1.8</java.version>
        
        <!-- pi4j 树莓派  -->
        <!--  
	        Unable to determine hardware version. I see: Hardware	: BCM2835
			 - expecting BCM2708 or BCM2709.
			If this is a genuine Raspberry Pi then please report this
			to projects@drogon.net. If this is not a Raspberry Pi then you
			are on your own as wiringPi is designed to support the
			Raspberry Pi ONLY.    变更版本 兼容问题 1.2-SNAPSHOT
        -->
        
        <pi4j.version>1.2-SNAPSHOT</pi4j.version>
        <!-- 百度语音模块 -->
        <baidu.api.version>4.7.0</baidu.api.version>
        
        <jwt.version>3.3.0</jwt.version>
    </properties>

	<!-- DEPENDENCIES  -->
    <dependencies>
    
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
        
        <!-- start web 默认引入 jackson-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>

        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
        </dependency>

        <!--自动编译 热部署-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
            <optional>true</optional>
        </dependency>

        <!-- commons-lang3 -->
        <dependency>
            <groupId>org.apache.commons</groupId>
            <artifactId>commons-lang3</artifactId>
        </dependency>

        <!--  commons-codec -->
        <dependency>
            <groupId>commons-codec</groupId>
            <artifactId>commons-codec</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-context-support</artifactId>
        </dependency>
        
        <!-- 操作树莓派GPIO的模块 -->
        <dependency>
            <groupId>com.pi4j</groupId>
            <artifactId>pi4j-core</artifactId>
            <version>${pi4j.version}</version>
        </dependency>
        
        <!-- 百度语音  -->
        <dependency>
            <groupId>com.baidu.aip</groupId>
            <artifactId>java-sdk</artifactId>
            <version>${baidu.api.version}</version>
        </dependency>
        
        <!-- 语音相关 -->
        <dependency>
            <groupId>com.googlecode.soundlibs</groupId>
            <artifactId>mp3spi</artifactId>
            <version>1.9.5-1</version>
        </dependency>
        <dependency>
            <groupId>org.json</groupId>
            <artifactId>json</artifactId>
            <version>20160810</version>
        </dependency>
        <dependency>
            <groupId>javazoom</groupId>
            <artifactId>jlayer</artifactId>
            <version>1.0.1</version>
        </dependency>
        
        <!-- https://mvnrepository.com/artifact/com.alibaba/fastjson -->
		<dependency>
		    <groupId>com.alibaba</groupId>
		    <artifactId>fastjson</artifactId>
		    <version>1.2.54</version>
		</dependency>
        
        
        <!-- jwt https://github.com/jwtk/jjwt  -->
        <!-- jwt 树莓派接口鉴权  -->
		<dependency>
		   <groupId>com.auth0</groupId>
		   <artifactId>java-jwt</artifactId>
		   <version>${jwt.version}</version> 
		</dependency>	
        
	</dependencies>
	
	<repositories>
		<repository>
			<id>oss-snapshots-repo</id>
			<name>Sonatype OSS Maven Repository</name>
			<url>https://oss.sonatype.org/content/groups/public</url>
			<snapshots>
				<enabled>true</enabled>
				<updatePolicy>always</updatePolicy>
			</snapshots>
		</repository>
	</repositories>
        
	<!-- maven-plugin -->
	<build>
		<resources>
	        <resource>
	        	<directory>src/main/resources</directory>
	        </resource>
	        <resource>
	            <directory>src/main/java</directory>
	             <includes>
	                 <include>**/*.properties</include>
	                 <include>**/*.xml</include>
	             </includes>
	            <filtering>false</filtering>
	        </resource>
        </resources>
	    <plugins>
	        <plugin>
	                <groupId>org.springframework.boot</groupId>
	                <artifactId>spring-boot-maven-plugin</artifactId>
	                <configuration>
	                    <executable>true</executable>
	                </configuration>
	                <executions>
	                    <execution>
	                        <goals>
	                            <goal>repackage</goal>
	                        </goals>
	                        <configuration>
	                            <classifier>exec</classifier>
	                        </configuration>
	                    </execution>
	                </executions>
	            </plugin>
	    </plugins>
	</build>
</project>
```

* 4.example-api
```java
/**
 * <html>
 * <body>
 *  <P> Copyright JasonInternational</p>
 *  <p> All rights reserved.</p>
 *  <p> Created on 2018年12月10日 下午12:38:47</p>
 *  <p> Created by Jason </p>
 *  </body>
 * </html>
 */
package cn.ucaner.raspi.controller.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.GpioPinPwmOutput;
import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

import cn.ucaner.raspi.listener.GpioListener;
import cn.ucaner.raspi.service.PinService;
import cn.ucaner.raspi.vo.RespBody;

/**     
* @Package：cn.ucaner.raspi.controller.api   
* @ClassName：GpioController   
* @Description：   <p> GpioController </p>
* @Author： - Jason   
* @CreatTime：2018年12月10日 下午12:38:47   
* @Modify By：   
* @ModifyTime：  2018年12月10日
* @Modify marker：   
* @version    V1.0
*/
@RestController
@RequestMapping(value = "/gpio/v1")
public class GpioController {
	
	private static final Logger logger = LoggerFactory.getLogger(GpioController.class);
	
	@Autowired
	private PinService pinService;
	
	@RequestMapping("/test")
    public RespBody gpioTest() throws InterruptedException {
		RespBody respBody = new RespBody();
		int num = 1;
		Pin pinByNum = pinService.getPinByNum(num);
		String raspiData = JSON.toJSONString(pinByNum);
		if (raspiData!=null) {
			respBody.addOK(JSON.toJSONString(raspiData));
		}else {
			respBody.addFail("调用错误");
		}
		
		for (int i = 0; i < 10; i++) {
			if (i%2 == 0) {
				pinService.provisionGpio(RaspiPin.GPIO_05, "LED", PinState.HIGH);
				logger.info("LED亮起来!");
				Thread.sleep(1000);
//				gpio.shutdown();
//				gpio.unProvisionPin(pin);
			}else {
				//RaspiPin.GPIO_00
				pinService.provisionGpio(RaspiPin.GPIO_05, "LED", PinState.LOW);
				logger.info("LED关掉!");
				Thread.sleep(1000);
			}
		}
		return respBody;
    }
	
	/**
	 * @Description: gpioDemo  gpio demo演示
	 * @return
	 * @throws InterruptedException RespBody
	 * @Autor: Jason
	 */
	@RequestMapping("/demo")
    public RespBody gpioDemo() throws InterruptedException {
		RespBody respBody = new RespBody();
		int num = 1;
		Pin pinByNum = pinService.getPinByNum(num);
		String raspiData = JSON.toJSONString(pinByNum);
		if (raspiData!=null) {
			respBody.addOK(JSON.toJSONString(raspiData));
		}else {
			respBody.addFail("调用错误");
		}
		return respBody;
    }
	
	
	/**
	 * @Description: gpioGood 
	 * @return  RespBody
	 * @throws InterruptedException 
	 * @Autor: Jason
	 */
	@RequestMapping("/good")
    public void gpioGood() throws InterruptedException {
		final com.pi4j.io.gpio.GpioController gpio = GpioFactory.getInstance();
		final GpioPinPwmOutput pin = gpio.provisionPwmOutputPin(RaspiPin.GPIO_26, "MyLED", 100);
		pin.setShutdownOptions(true, PinState.LOW);
		int sleep_time = 10;
	    int sleep_time2 = 7;
	    while(true) {
          // lighting....
          for (int i=0; i<=100; i++) {
              pin.setPwm(i);           
              Thread.sleep(sleep_time);
              System.out.println("第"+i+"次");
          }
          // darking...
          for (int i=100; i>0; i--) {
              pin.setPwm(i);     
              Thread.sleep(sleep_time2);
              System.out.println("第"+i+"次");
          }
          Thread.sleep(1000); // break 1 second
      }
    }
	
	
	/**
	 * @Description: gpioLed
	 * @throws InterruptedException 
	 * @Autor: Jason
	 */
	@RequestMapping("/led")
    public void gpioLed() throws InterruptedException {
		final com.pi4j.io.gpio.GpioController gpio = GpioFactory.getInstance();
	    /**
		 * 定义编号为0的引脚为数字输出引脚,初始化为低电平
		 */
	    GpioPinDigitalOutput ledBlink = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_00, "01" ,PinState.LOW);
	    int i = 100;
	    while(i <= 150){
	    	ledBlink.high();
	    	logger.info("LED亮起来!");
	        Thread.sleep(500);
	        ledBlink.low();
	        logger.info("LED被灭掉!");
	        Thread.sleep(500);
	        i++;
	    }
	    GpioListener.startUp();
    }
	/**
	 * @Description: 启动监听器
	 * @Autor: Jason
	 */
	@RequestMapping("/listen")
    public void gpioStartUp(){
	    GpioListener.startUp();
    }

}

```

```java
@RestController
@RequestMapping(value = "/api/v1")
public class ApiController {
	
	@RequestMapping("/test")
    public RespBody jwtToken() {
		HashMap<Object, Object> hashMap = new HashMap<>();
		hashMap.put("name", "jwt");
		hashMap.put("value", "pass");
		return new RespBody(Status.OK,hashMap);
    }

}
```

## Contact
- **Below is my personal contact information. Welcome to exchange and study.**
<p align="center">
    <img src="https://raw.githubusercontent.com/Jasonandy/Note-X/master/Media/contact/WXQRCode.jpg" width="280" height="280" alt="WX" align="left" />
</p>

- CNblog: https://www.cnblogs.com/jasonandy
- E-Mail: jasonandy@hotmail.com 
- Instagram: xxx
- Facebook: xxx
- Twitter: xxx 
- Skype: xxx
- Line: xxx
- QQ: 603043194




#### License
**开源协议** [Apache License, Version 2.0](http://www.apache.org/licenses/LICENSE-2.0.html)