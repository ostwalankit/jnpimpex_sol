package com.ornet.jnpimpex.core.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SendEmailServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		System.out.println("in send email servlet");
		String name = req.getParameter("name");
		String senderEmail = req.getParameter("email");
		String phone = req.getParameter("phone");
		String message = req.getParameter("message");

		System.out.println(name+"-->"+senderEmail+"-->"+phone+"-->"+message);
		
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com"); // smtp.gmail.com
		// below mentioned mail.smtp.port is optional //587 for gmail
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");

		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication("info.jnpimpex@gmail.com", "info.jnp");
					}
				});
		try {

			/*
			 * Create an instance of MimeMessage, it accept MIME types and
			 * headers
			 */

			MimeMessage msg = new MimeMessage(session);

			msg.setHeader(senderEmail, name);
			msg.setRecipient(Message.RecipientType.TO, new InternetAddress("jnpimpex@gmail.com"));
			msg.setSubject("Email :: "+senderEmail +" Name :: "+name + " Phone no. :: " + phone);
			msg.setText(message);
			/* Transport class is used to deliver the message to the recipients */
			Transport.send(msg);
			PrintWriter out = resp.getWriter();
			System.out.println("Email send successfully.");
			out.print("Email send successfully.");
		} catch (Exception e) {
			PrintWriter out = resp.getWriter();
			out.print("There was some problem sending email.Please try again.");
			System.out.println("There was some problem sending email.Please try again.");
			e.printStackTrace();
		}
	}
}
