package cn.ucaner.raspi.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.baidu.aip.speech.AipSpeech;
import com.baidu.aip.speech.TtsResponse;
import com.baidu.aip.util.Util;

import cn.ucaner.raspi.service.AlarmClockService;
import javazoom.jl.player.Player;

/**
* @Package：cn.ucaner.raspi.service.impl   
* @ClassName：AlarmClockServiceImpl   
* @Description：   <p> 闹钟服务</p>
* @Author： - Jason   
* @CreatTime：2018年12月10日 下午12:26:41   
* @Modify By：   
* @ModifyTime：  2018年12月10日
* @Modify marker：   
* @version    V1.0
 */
@Service("alarmClockService")
public class AlarmClockServiceImpl implements AlarmClockService{

	public static final String APP_ID = "10750488";
    public static final String API_KEY = "pxp2chcjRxbX2YWrQuRffjw0";
    public static final String SECRET_KEY = "761b306676f5861a1aa4aa0eb0c6aed2";
    
    public static final String filePath = "D:\\Users\\Jason\\Videos\\music\\";
    
    public static final String musicPath = "D:\\tempMusic\\";
    
    /**
     * 树莓派的音乐目录
     */
    //public static final String filePath = "/home/pi/java/tempSound/";
    //public static final String musicPath = "/home/pi/java/tempMusic/";
    
	
	@Override
	public String findAllInfo() {
		return "HelloWorld!";
	}

	@Override
	public void playSound(String text) {
		AipSpeech client = new AipSpeech(APP_ID, API_KEY, SECRET_KEY);
		
		String filename = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())+".mp3";
       
		// 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);
        
//        参数	类型	描述	是否必须
//        tex	String	合成的文本，使用UTF-8编码，请注意文本长度必须小于1024字节	是
//        lang	String	语言选择,填写zh	是
//        ctp	String	客户端类型选择，web端填写1	是
//        cuid	String	用户唯一标识，用来区分用户，填写机器 MAC 地址或 IMEI 码，长度为60以内	否
//        spd	String	语速，取值0-9，默认为5中语速	否
//        pit	String	音调，取值0-9，默认为5中语调	否
//        vol	String	音量，取值0-15，默认为5中音量	否
//        per	String	发音人选择, 0为女声，1为男声，3为情感合成-度逍遥，4为情感合成-度丫丫，默认为普通女	否
        
        HashMap<String, Object> options = new HashMap<String, Object>();
        options.put("per", "4");
        options.put("spd", "3");
        options.put("vol", "10");
        // 调用接口
        TtsResponse res = client.synthesis(text, "zh", 1, options);
        
        byte[] data = res.getData();
        if (data != null) {
            try {
                Util.writeBytesToFileSystem(data, filePath+filename);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        this.playRandomMusic();
        this.play(filePath+filename);
	}

	private void playRandomMusic() {
		File file = new File(musicPath);
		java.util.Random random=new java.util.Random();// 定义随机类
		int result=random.nextInt(1000);// 返回[0,1000)集合中的整数
		if (file.exists()) {
			File[] files = file.listFiles();
			result %= files.length;
			this.play(files[result].getAbsolutePath());
		}
	}

	/**
	 * 新线程异步播放文件
	 */
	@Override
	public void play(String fileName) {
		new Thread(){
			public void run(){
				try {
					InputStream input = new FileInputStream(fileName);
					Player player = new Player(input);
					//播放音乐
					player.play();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}.start();	
	}

}
