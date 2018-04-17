package com.zking.hr.view.contorl.action.checkMa;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zking.hr.utils.checkMa.ImageUtil;
public class  ImageDemoAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
//	private Logger loger = Logger.getLogger(ImageDemoAction.class);	
	//stream result只能输出InputStream类型
    private InputStream imageStream;

    public InputStream getImageStream() {
        return imageStream;
    }

    public void setImageStream(InputStream imageStream) {
        this.imageStream = imageStream;
    }
    
    public void getImgCode() throws IOException{
    	HttpServletResponse response = ServletActionContext.getResponse();
    	HttpServletRequest request = ServletActionContext.getRequest();
        //生成验证码
        Map<String, BufferedImage> map = ImageUtil.createImage();
        String key = map.keySet().iterator().next();
        HttpSession session = request.getSession();
        session.removeAttribute("key");
        session.setAttribute("key", key);
        BufferedImage image = map.get(key);
        try{
            imageStream = ImageUtil.getInputStream(image);
            OutputStream outputStream = response.getOutputStream();  
            ImageIO.write(image, "jpeg", outputStream);  
            outputStream.close();
        }catch(IOException e){
//        	logger.error("生成验证码失败:"+e.getMessage());
        	e.printStackTrace();
        }
    }
}