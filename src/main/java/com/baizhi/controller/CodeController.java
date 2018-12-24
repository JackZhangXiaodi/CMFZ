package com.baizhi.controller;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.baizhi.util.ViewObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.baizhi.util.ValidateImageCodeUtils;
@Controller
@RequestMapping("/codeController")
public class CodeController {
	@RequestMapping("/code")
	public void code(HttpSession session,HttpServletResponse response) throws IOException{
		//获取验证码随机数
				String securityCode = ValidateImageCodeUtils.getSecurityCode();
				//将securityCode存入session作用域
				session.setAttribute("code", securityCode);
				//创建验证码图片，参数为securityCode
				BufferedImage image = ValidateImageCodeUtils.createImage(securityCode);
				//将验证码图片通过输出流响应到客户端，先获取response，再获取输出流
				ServletOutputStream out = response.getOutputStream();
				//调用神奇方法
						/**
						 * 第一个参数： 验证码图片对象
						 * 第二个参数： 图片的格式
						 * 第三个参数： 输出字节流
						 */
				ImageIO.write(image, "png", out);
	}
	@RequestMapping("/fir")
	@ResponseBody
	public ViewObject json(String code, HttpSession session){
		ViewObject viewObject = new ViewObject();
		String code2 = (String) session.getAttribute("code");
		if(code2.equals(code)){
			viewObject.setSuccess(true);
			viewObject.setMessage("验证码正确");
		}else{
			viewObject.setSuccess(false);
			viewObject.setMessage("验证码错误");
		}
		return viewObject;
	}
}
