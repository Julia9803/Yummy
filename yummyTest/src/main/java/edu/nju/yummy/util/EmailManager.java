package edu.nju.yummy.util;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class EmailManager {
    @Value("${edu.nju.yummy.myAddress}")
    private String myAddress;
    @Value("${edu.nju.yummy.authCode}")
    private String authCode;

    public String sendEmail(String userEmail) throws EmailException {
        HtmlEmail email = new HtmlEmail();
        email.setHostName("smtp.163.com");
        email.setCharset("utf-8");
        email.addTo(userEmail);
        email.setFrom(myAddress,"Yummy!");
        email.setAuthentication(myAddress,authCode);
        email.setSubject("Yummy！注册邮箱验证");
        String code = generateCode();
        email.setMsg(code);
        email.send();
        return code;
    }

    private String generateCode() {
        return String.valueOf((int) (Math.random()*10000));
    }
}
