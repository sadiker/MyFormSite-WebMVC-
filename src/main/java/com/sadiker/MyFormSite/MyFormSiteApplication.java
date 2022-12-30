package com.sadiker.MyFormSite;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.sadiker.MyFormSite.models.Issue;
import com.sadiker.MyFormSite.models.User;
import com.sadiker.MyFormSite.models.Comment;
import com.sadiker.MyFormSite.repository.IssueRepository;
import com.sadiker.MyFormSite.repository.UserRepository;
import com.sadiker.MyFormSite.repository.CommentRepository;

@SpringBootApplication
public class MyFormSiteApplication {

	@Autowired
	IssueRepository issuerepo;

	@Autowired
	UserRepository userrepo;

	@Autowired
	CommentRepository commentrepo;

	public static void main(String[] args) {
		SpringApplication.run(MyFormSiteApplication.class, args);
	}

	@Bean
	CommandLineRunner clr(PasswordEncoder passwordEncoder) {
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				fullfillDatabase(passwordEncoder, commentrepo, userrepo, issuerepo);

			}

			public static void fullfillDatabase(PasswordEncoder passwordEncoder, CommentRepository commentrepo,
					UserRepository userrepo, IssueRepository issuerepo) {

				User user1 = new User();
				user1.setEmail("ali@gmail.com");
				user1.setGender("Erkek");
				user1.setRole("ADMIN");
				user1.setUsername("Ali");
				user1.setPassword(passwordEncoder.encode("abc"));
				user1.setLocalDate(LocalDate.of(2000, 1, 1));
				

				User user2 = new User();
				user2.setEmail("ayse@gmail.com");
				user2.setGender("Kadın");
				user2.setRole("NORMAL");
				user2.setUsername("Ayşe");
				user2.setPassword(passwordEncoder.encode("abc"));
				user2.setLocalDate(LocalDate.of(2001, 2, 2));

				Issue issue1 = new Issue();
				issue1.setName("Sporda bu hafta neler olacak");
				issue1.setUser(user1);
				issue1.setComments(new ArrayList<Comment>());

				Issue issue2 = new Issue();
				issue2.setName("Araba piyasası nasıl..");
				issue2.setUser(user1);
				issue2.setComments(new ArrayList<Comment>());


				Issue issue3 = new Issue();
				issue3.setName("Ekonomide ne var?");
				issue3.setUser(user2);
				issue3.setComments(new ArrayList<Comment>());


				Issue issue4 = new Issue();
				issue4.setName("Magazin dünyasında sürprizler");
				issue4.setUser(user2);
				issue4.setComments(new ArrayList<Comment>());


				Issue issue5 = new Issue();
				issue5.setName("Dış haberlerde son dakika ");
				issue5.setUser(user1);
				issue5.setComments(new ArrayList<Comment>());


				Comment comment1 = new Comment();
				comment1.setText("........yorum1.....");
				comment1.setUser(user1);
				comment1.setIssue(issue1);
				issue1.getComments().add(comment1);

				Comment comment2 = new Comment();
				comment2.setText("........yorum2.....");
				comment2.setUser(user2);
				comment2.setIssue(issue1);
				issue1.getComments().add(comment2);

				Comment comment3 = new Comment();
				comment3.setText("........yorum3.....");
				comment3.setUser(user2);
				comment3.setIssue(issue2);
				issue2.getComments().add(comment3);
				
				Comment comment4 = new Comment();
				comment4.setText("........yorum4.....");
				comment4.setUser(user1);
				comment4.setIssue(issue2);
				issue2.getComments().add(comment4);
				
				Comment comment5 = new Comment();
				comment5.setText("........yorum5.....");
				comment5.setUser(user1);
				comment5.setIssue(issue3);
				issue3.getComments().add(comment5);
				
				Comment comment6 = new Comment();
				comment6.setText("........yorum6.....");
				comment6.setUser(user2);
				comment6.setIssue(issue3);
				issue3.getComments().add(comment6);

				Comment comment7 = new Comment();
				comment7.setText("........yorum7.....");
				comment7.setUser(user1);
				comment7.setIssue(issue4);
				issue4.getComments().add(comment7);
				
				Comment comment8 = new Comment();
				comment8.setText("........yorum8.....");
				comment8.setUser(user2);
				comment8.setIssue(issue4);
				issue4.getComments().add(comment8);

				Comment comment9 = new Comment();
				comment9.setText("........yorum9.....");
				comment9.setUser(user1);
				comment9.setIssue(issue5);
				issue5.getComments().add(comment9);

				Comment comment10 = new Comment();
				comment10.setText("........yorum10.....");
				comment10.setUser(user2);
				comment10.setIssue(issue5);
				issue5.getComments().add(comment10);

				userrepo.save(user1);
				userrepo.save(user2);

				issuerepo.save(issue1);
				issuerepo.save(issue2);
				issuerepo.save(issue3);
				issuerepo.save(issue4);
				issuerepo.save(issue5);

				commentrepo.save(comment1);
				commentrepo.save(comment2);
				commentrepo.save(comment3);
				commentrepo.save(comment4);
				commentrepo.save(comment5);
				commentrepo.save(comment6);
				commentrepo.save(comment7);
				commentrepo.save(comment8);
				commentrepo.save(comment9);
				commentrepo.save(comment10);
			}

		};
	}

}
