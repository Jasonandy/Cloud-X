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
* Describe： Based on spring-boot & raspiberry2b+  


## 一、Raspi-X

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



## 二、实施方案

> 技术清单
- [X] Spring-boot2.0
- [X] Pi4j
- [X] GPIO
- [X] JWT鉴权
- [X] JavaWeb后台


[RaspiX](https://github.com/Jasonandy/Cloud-X)


## 三、ACR122U-A9
Mifare One非接触式IC卡（M1）基础知识
* 一、主要指标
	容量为8K位EEPROM
	分为16个扇区，每个扇区为4块，每块16个字节,以块为存取单位
	每个扇区有独立的一组密码及访问控制
	每张卡有唯一序列号，为32位
	具有防冲突机制，支持多卡操作
	无电源，自带天线，内含加密控制逻辑和通讯逻辑电路
	数据保存期为10年，可改写10万次，读无限次
	工作温度：-20℃~50℃(温度为90%)
	工作频率：13.56MHZ
	通信速率：106KBPS
	读写距离：10mm以内（与读写器有关）

* 二、存储结构
	1、	M1卡分为16个扇区，每个扇区由4块（块0、块1、块2、块3）组成，（我们也将16个扇区的64个块按绝对地址编号为0~63，存贮结构如下图所示：
				  	
	块0	     	数据块	0
	扇区0  	块1		数据块	1
	块2		数据块	2
	块3	密码A   存取控制   密码B	控制块	3
           块0		数据块	4
	扇区1	块1		数据块	5
	块2		数据块	6
	块3	密码A   存取控制   密码B	控制块	7
	0		数据块	60
	扇区15  	  1		数据块	61
	2		数据块	62
	3	密码A    存取控制   密码B	控制块	63
	
2、	第0扇区的块0（即绝对地址0块），它用于存放厂商代码，已经固化，不可更改。

3、	每个扇区的块0、块1、块2为数据块，可用于存贮数据。
   数据块可作两种应用：
★	用作一般的数据保存，可以进行读、写操作。
★	用作数据值，可以进行初始化值、加值、减值、读值操作。

4、	每个扇区的块3为控制块，包括了密码A、存取控制、密码B。具体结构如下：

            密码A（6字节）  存取控制（4字节） 密码B（6字节）  

5、	每个扇区的密码和存取控制都是独立的，可以根据实际需要设定各自的密码及存取控制。存取控制为4个字节，共32位，扇区中的每个块（包括数据块和控制块）的存取条件是由密码和存取控制共同决定的，在存取控制中每个块都有相应的三个控制位,定义如下：
    
          块0：   C10   C20   C30
          块1：   C11   C21   C31
          块2：   C12   C22   C32
          块3：   C13   C23   C33

  三个控制位以正和反两种形式存在于存取控制字节中，决定了该块的访问权限（如  
  进行减值操作必须验证KEY A，进行加值操作必须验证KEY B，等等）。三个控制
  位在存取控制字节中的位置，以块0为例：
 
   对块0的控制：
         bit  7    6     5       4     3      2      1      0
		字节6				C20_b				C10_b
		字节7				C10				C30_b
		字节8				C30				C20
		字节9								
                ( 注： C10_b表示C10取反 )

      存取控制（4字节，其中字节9为备用字节）结构如下所示：
          bit  7    6      5       4     3      2      1      0
字节6	C23_b	C22_b	C21_b	C20_b	C13_b	C12_b	C11_b	C10_b
字节7	C13	C12	C11	C10	C33_b	C32_b	C31_b	C30_b
字节8	C33	C32	C31	C30	C23	C22	C21	C20
字节9								
                     ( 注： _b表示取反 )

    6、数据块（块0、块1、块2）的存取控制如下：

  控制位（X=0.1.2）
  	         访 问 条 件 （对数据块 0、1、2）
C1X	C2X	C3X	 Read	 Write 	Increment	Decrement, transfer,
Restore
0	0	0	KeyA|B	KeyA|B	KeyA|B	KeyA|B
0	1	0	KeyA|B	Never	Never	Never
1	0	0	KeyA|B	KeyB	Never	Never
1	1	0	KeyA|B	KeyB	KeyB	KeyA|B
0	0	1	KeyA|B	Never	Never	KeyA|B
0	1	1	KeyB	KeyB	Never	Never
1	0	1	KeyB	Never	Never	Never
1	1	1	Never	Never	Never	Never
     （KeyA|B 表示密码A或密码B，Never表示任何条件下不能实现）

  例如：当块0的存取控制位C10 C20 C30=1 0 0时，验证密码A或密码B正确后可读；
        验证密码B正确后可写；不能进行加值、减值操作。

    7、控制块块3的存取控制与数据块（块0、1、2）不同，它的存取控制如下：

			密码A	存取控制	密码B
C13	C23	C33	Read	Write 	Read	Write	Read	Write
0	0	0	Never	KeyA|B	KeyA|B	Never	KeyA|B	KeyA|B
0	1	0	Never	Never	KeyA|B	Never	KeyA|B	Never
1	0	0	Never	KeyB	KeyA|B	Never	Never	KeyB
1	1	0	Never	Never	KeyA|B	Never	Never	Never
0	0	1	Never	KeyA|B	KeyA|B	KeyA|B	KeyA|B	KeyA|B
0	1	1	Never	KeyB	KeyA|B	KeyB	Never	KeyB
1	0	1	Never	Never	KeyA|B	KeyB	Never	Never
1	1	1	Never	Never	KeyA|B	Never	Never	Never
   例如：当块3的存取控制位C13 C23 C33=1 0 0时，表示：
           密码A：不可读，验证KEYA或KEYB正确后，可写（更改）。
         存取控制：验证KEYA或KEYB正确后，可读、可写。
           密码B：验证KEYA或KEYB正确后，可读、可写。


三、	工作原理
卡片的电气部分只由一个天线和ASIC组成。
天线：卡片的天线是只有几组绕线的线圈，很适于封装到IS0卡片中。
ASIC：卡片的ASIC由一个高速（106KB波特率）的RF接口，一个控制单元和一个
      8K位EEPROM组成。
工作原理：读写器向M1卡发一组固定频率的电磁波，卡片内有一个LC串联谐振电路，其频率与读写器发射的频率相同，在电磁波的激励下，LC谐振电路产生共振，从而使电容内有了电荷，在这个电容的另一端，接有一个单向导通的电子泵，将电容内的电荷送到另一个电容内储存，当所积累的电荷达到2V时，此电容可做为电源为其它电路提供工作电压，将卡内数据发射出去或接取读写器的数据。

四、	M1射频卡与读写器的通讯
                                             
          改变扇区

         不改变扇区

复位应答（Answer to request）
M1射频卡的通讯协议和通讯波特率是定义好的，当有卡片进入读写器的操作范围时，读写器以特定的协议与它通讯，从而确定该卡是否为M1射频卡，即验证卡片的卡型。

防冲突机制 (Anticollision Loop)
当有多张卡进入读写器操作范围时，防冲突机制会从其中选择一张进行操作，未选中的则处于空闲模式等待下一次选卡，该过程会返回被选卡的序列号。

选择卡片(Select Tag)
选择被选中的卡的序列号，并同时返回卡的容量代码。

三次互相确认(3 Pass Authentication)
选定要处理的卡片之后，读写器就确定要访问的扇区号，并对该扇区密码进行密码校验，在三次相互认证之后就可以通过加密流进行通讯。（在选择另一扇区时，则必须进行另一扇区密码校验。）

	对数据块的操作 
	读 (Read)：读一个块；
	写 (Write）：写一个块；
	加（Increment）：对数值块进行加值；
	减（Decrement）：对数值块进行减值；
	存储（Restore）：将块中的内容存到数据寄存器中；
	传输（Transfer）：将数据寄存器中的内容写入块中；
	中止（Halt）：将卡置于暂停工作状态；

## 四、部署相关

> You are what you want to be.

* 1.树莓派Linux环境的搭建

```properties


```

* 2.PI4J环境的搭建
![](http://upload-images.jianshu.io/upload_images/7802425-5d6b679ecdac9f47.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

* 3.spring-boot部署

``` xml
<project xmlns="http://maven.apache.org/POM/4.0.0" 
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 	
	http://maven.apache.org/xsd/maven-4.0.0.xsd">
	
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
* @Description：   <p> GpioController   GPIO 控制器</p>
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