package web;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.ui.*;
import org.springframework.boot.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
public class MyController {
	
	@RequestMapping("/")
	String index() {
		return "index";
	}
	
	@RequestMapping("/jsp")
	String jsp() {
		return "index-jsp";
	}
        
        @RequestMapping("/vat")
	String vat() {
		return "vat";
	}
        
        @RequestMapping("/calVat")
	String calVat(double vat, Model model) {
		double result = vat * 6.5;
		model.addAttribute("result", result);
                model.addAttribute("vat", vat);
		return "vatResult";
	}
        
        @RequestMapping("/circle")
	String circle() {
		return "circle";
	}
        
        @RequestMapping("/calCircle")
	String calCircle(double radius, Model model) {
                double area = Math.PI * radius * radius;
                double circumference = 2 * Math.PI * radius;
                model.addAttribute("area", area);
                model.addAttribute("circum", circumference);
		return "circleResult";
	}
        
        @RequestMapping("/rectangle")
	String rectangle() {
		return "rectangle";
	}
        
        @RequestMapping("/calRec")
        String calRec(double width, double high, Model model){
                double result = width * high;
                model.addAttribute("area", result);
                return "recResult";
        }
        
        @RequestMapping("/zipCode")
	String zipCode() {
		return "zipCode";
	}
         @RequestMapping("/findZipCode")
	String findZipCode(String district, Model model) {
            String result = "ไม่มี";
            String tmp = district;
            if(tmp.equals("เมืองนนทบุรี")) result = "11000";
            if(tmp.equals("บางบัวทอง"))result = "11110";
            if(tmp.equals("ปากเกร็ด")) result = "11120";
            if(tmp.equals("บางกรวย"))result = "11130";
            if(tmp.equals("บางใหญ่"))  result = "11140";
            if(tmp.equals("ไทรน้อย"))  result = "11150";
            model.addAttribute("code", result);
		return "codeResult";
	}
        
        @RequestMapping("/findIp")
	String findIp() {
		return "findIp";
	}
        
        @RequestMapping("/ipAdd")
	String ipAdd(String web, Model model) {
                String temp = web;
                String numIp = null;
                InetAddress ipAddress = null;            
            try {
                ipAddress = InetAddress.getByName(temp);
                numIp = ipAddress.getCanonicalHostName();
            } catch (UnknownHostException ex) {
                numIp = "unknow";
                
            }
                
                model.addAttribute("ipAddress", numIp);
                model.addAttribute("web", temp);
		return "addResult";
	}
        
        
}
