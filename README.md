Spring DataJPA,Spring Security,SpringWeb,Thymeleaf ile geliştirilmiş form sitesi web  uygulaması denemesidir...(Java,Html,Css kullanılmıştır..)
Projeyi zip olarak indirin
Herhangi bir IDE'de açın..
MyFormSiteApplication.java  sayfasında projeyi çalıştırın...
İnternet tarayıcınıza http://localhost:8080/home yazın ve kullanın..
Proje H2 inmemory database ile yapılmıştır...
Dilerseniz application.properties ve pom.xml 'deki mysql kodlarını yorum satırından çıkarıp H2Database kodlarını yorum satırına aldıktan sonra da  çalıştırabilirsiniz..
Bu şekilde MySql Database'te verilerin nasıl tutulduğunu da görebilirsiniz...(kendi şifre ve kullanıcı adınızı yazmayı ve form adlı bir database oluşturmayı unutmayınız..)
User,Konu,Yorum kayıtları hazırdır...
Uygulamada bazı seçeneklere herkes tıklayabilir,bazılarına ulşamak için giriş yapmak gerekebilir,bazılarına ise ADMIN rolünde giriş yapmak gerekir..
ADMIN rolünde giriş yapmak için: Username:Ali  Password:abc
NORMAL rolünde  giriş yapmak için: Username:Ayşe Password:abc
veya kendiniz de yeni kullanıcı kaydedip giriş yapabilirsiniz..Ama default olarak NORMAL rolde olacaksınız..
