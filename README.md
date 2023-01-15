# Form Sitesi Web MVC Denemesi
## Kullanıcıların istedikleri konularda yorum yapabilecekleri veya kendi konularını oluşturabilecekleri bir  form sitesidir.
## Java,Spring DataJPA,Spring Security,SpringMVC,Thymeleaf,Maven,H2 Database,Html,Tailwindcss,Hibernate,MySql ile geliştirilmiştir
### Uygulamada bazı seçeneklere herkes tıklayabilir,bazılarına ulaşmak için giriş yapmak gerekebilir,bazılarına ise ADMIN rolünde giriş yapmak gerekir..
### ADMIN rolünde giriş yapmak için:( KullanıcıAdı:Ali Şifre:abc)
### NORMAL rolünde giriş yapmak için:( KullanıcıAdı:Ayşe Şifre:abc)
### veya kendiniz de yeni kullanıcı kaydedip giriş yapabilirsiniz..Ama default olarak NORMAL rolde olacaksınız..

https://user-images.githubusercontent.com/121498198/211168088-f45b1d09-9d14-43ca-88c8-c6a6893fc56e.mp4

1. Projeyi zip olarak indirin..
2. Ayıkladıktan sonra java kodu çalıştırabilen herhangi bir IDE'de açın.
3. MyFormSiteApplication.java sayfasında projeyi çalıştırın...
4. İnternet tarayıcınıza http://localhost:8080/home yazın ve kullanın..
5. Proje H2 inmemory database ile yapılmıştır.User,Issue,Comment kayıtları hazırdır.Dilerseniz application.properties ve pom.xml 'deki mysql kodlarını yorum satırından çıkarıp H2Database kodlarını yorum satırına aldıktan sonra da çalıştırabilirsiniz. Bu şekilde MySql Database'te verilerin nasıl tutulduğunu da görebilirsiniz.(kendi şifre ve kullanıcı adınızı yazmayı ve form adlı bir database oluşturmayı unutmayınız..)
![Ekran Alıntısı](https://user-images.githubusercontent.com/121498198/212563982-9fdc307d-9efb-497e-8a35-b0314c00716e.PNG)
