package com.sadiker.MyFormSite;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.sadiker.MyFormSite.models.Konu;
import com.sadiker.MyFormSite.models.User;
import com.sadiker.MyFormSite.models.Yorum;
import com.sadiker.MyFormSite.repository.KonuRepository;
import com.sadiker.MyFormSite.repository.UserRepository;
import com.sadiker.MyFormSite.repository.YorumRepository;

@SpringBootApplication
public class MyFormSiteApplication {

	@Autowired
	KonuRepository konurepo;

	@Autowired
	UserRepository userrepo;

	@Autowired
	YorumRepository yorumrepo;

	public static void main(String[] args) {
		SpringApplication.run(MyFormSiteApplication.class, args);
	}

	@Bean
	CommandLineRunner clr(PasswordEncoder passwordEncoder) {
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				fullfillDatabase(passwordEncoder, yorumrepo, userrepo, konurepo);

			}

			public static void fullfillDatabase(PasswordEncoder passwordEncoder, YorumRepository yorumrepo,
					UserRepository userrepo, KonuRepository konurepo) {

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

				Konu konu1 = new Konu();
				konu1.setName("Sporda bu hafta neler olacak");
				konu1.setUser(user1);
				konu1.setYorumlar(new ArrayList<Yorum>());

				Konu konu2 = new Konu();
				konu2.setName("Araba piyasası nasıl..");
				konu2.setUser(user1);
				konu2.setYorumlar(new ArrayList<Yorum>());


				Konu konu3 = new Konu();
				konu3.setName("Ekonomide ne var?");
				konu3.setUser(user2);
				konu3.setYorumlar(new ArrayList<Yorum>());


				Konu konu4 = new Konu();
				konu4.setName("Magazin dünyasında sürprizler");
				konu4.setUser(user2);
				konu4.setYorumlar(new ArrayList<Yorum>());


				Konu konu5 = new Konu();
				konu5.setName("Dış haberlerde son dakika ");
				konu5.setUser(user1);
				konu5.setYorumlar(new ArrayList<Yorum>());


				Yorum yorum1 = new Yorum();
				yorum1.setText("........yorum1.....");
				yorum1.setUser(user1);
				yorum1.setKonu(konu1);
				konu1.getYorumlar().add(yorum1);

				Yorum yorum2 = new Yorum();
				yorum2.setText("........yorum2.....");
				yorum2.setUser(user2);
				yorum2.setKonu(konu1);
				konu1.getYorumlar().add(yorum2);

				Yorum yorum3 = new Yorum();
				yorum3.setText("........yorum3.....");
				yorum3.setUser(user2);
				yorum3.setKonu(konu2);
				konu2.getYorumlar().add(yorum3);
				
				Yorum yorum4 = new Yorum();
				yorum4.setText("........yorum4.....");
				yorum4.setUser(user1);
				yorum4.setKonu(konu2);
				konu2.getYorumlar().add(yorum4);
				
				Yorum yorum5 = new Yorum();
				yorum5.setText("........yorum5.....");
				yorum5.setUser(user1);
				yorum5.setKonu(konu3);
				konu3.getYorumlar().add(yorum5);
				
				Yorum yorum6 = new Yorum();
				yorum6.setText("........yorum6.....");
				yorum6.setUser(user2);
				yorum6.setKonu(konu3);
				konu3.getYorumlar().add(yorum6);

				Yorum yorum7 = new Yorum();
				yorum7.setText("........yorum7.....");
				yorum7.setUser(user1);
				yorum7.setKonu(konu4);
				konu4.getYorumlar().add(yorum7);
				
				Yorum yorum8 = new Yorum();
				yorum8.setText("........yorum8.....");
				yorum8.setUser(user2);
				yorum8.setKonu(konu4);
				konu4.getYorumlar().add(yorum8);

				Yorum yorum9 = new Yorum();
				yorum9.setText("........yorum9.....");
				yorum9.setUser(user1);
				yorum9.setKonu(konu5);
				konu5.getYorumlar().add(yorum9);

				Yorum yorum10 = new Yorum();
				yorum10.setText("........yorum10.....");
				yorum10.setUser(user2);
				yorum10.setKonu(konu5);
				konu5.getYorumlar().add(yorum10);

				userrepo.save(user1);
				userrepo.save(user2);

				konurepo.save(konu1);
				konurepo.save(konu2);
				konurepo.save(konu3);
				konurepo.save(konu4);
				konurepo.save(konu5);

				yorumrepo.save(yorum1);
				yorumrepo.save(yorum2);
				yorumrepo.save(yorum3);
				yorumrepo.save(yorum4);
				yorumrepo.save(yorum5);
				yorumrepo.save(yorum6);
				yorumrepo.save(yorum7);
				yorumrepo.save(yorum8);
				yorumrepo.save(yorum9);
				yorumrepo.save(yorum10);
			}

		};
	}

}
