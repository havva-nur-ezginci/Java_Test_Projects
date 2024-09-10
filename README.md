# Test Otomasyon Projesi

Bu proje, iki ana kısımdan oluşmaktadır:

1. **Web Test Projesi:** Selenium WebDriver kullanarak web uygulamalarının otomasyonu uygulanmıştır.
2. **API Test Projesi:** API'lerin otomatik test edilmesi için Postman ve RestAssured kullanılmıştır.

Aşağıda her iki test projesine dair detaylar ve kurulum adımları yer almaktadır.

## Table of Contents
- [Web Test Projesi](#web-test-projesi)
- [API Test Projesi](#api-test-projesi)

# Web Test Projesi
- [Web Test Projesi (Selenium, JUnit, TestNG ve Maven)](https://github.com/havva-nur-ezginci/Java_Test_Projects/tree/master/com.MavenSelenium/src/test/java)

## Proje İçeriği

- **Selenium WebDriver:** Web tarayıcılarını otomatikleştirmek için kullanılır.
- **JUnit:** Unit test yazmak için kullanılan popüler bir test framework'üdür.
- **TestNG:** TestNG, JUnit gibi diğer test framework'üyle benzer bir kullanım sunar, ancak birçok ek özellik barındırır.

## Kurulum

Proje, Maven tabanlıdır. Aşağıdaki adımları izleyerek projeyi kurabilirsiniz.

### 1.JDK & Java Install
 **https://www.oracle.com/java/technologies/downloads/**

### 2.Maven Repository
 **https://mvnrepository.com/**

### 3.Install Maven Dependencies

Projedeki gerekli bağımlılıklar `pom.xml` dosyasına eklenmiştir:

```xml
<dependencies>
    <!-- Selenium WebDriver -->
    <dependency>
        <groupId>org.seleniumhq.selenium</groupId>
        <artifactId>selenium-java</artifactId>
        <version>4.14.0</version>
    </dependency>

    <!-- JUnit Test Framework -->
    <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
        <version>4.13.2</version>
        <scope>test</scope>
    </dependency>

    <!-- TestNG Test Framework -->
    <dependency>
        <groupId>org.testng</groupId>
        <artifactId>testng</artifactId>
        <version>7.8.0</version>
        <scope>test</scope>
    </dependency>
</dependencies>
```
**Maven Proje Yapılandırması:** IDE içinde Maven bağımlılıklarını indirmek için `pom.xml` dosyasını güncelleyin (`mvn install`).

# API Test Projesi
- [API Test Projesi (Postman, RestAssured, Map, Pojo)](https://github.com/havva-nur-ezginci/Java_Test_Projects/tree/master/API_Testing/src/test/java)
  
Bu proje, REST API'lerin otomatik test edilmesi için aşağıdaki kütüphaneleri ve araçları kullanır:
## Proje İçeriği

- **RestAssured:** REST API'lerin test edilmesi için Java tabanlı bir kütüphanedir.
- **JUnit:** Test senaryolarını yazmak ve çalıştırmak için kullanılan popüler bir unit test framework'üdür.
- **JSONPath:** JSON veri yapılarını test etmek ve doğrulamak için kullanılır.
- **Gson:** JSON verileri üzerinde işlem yapabilmek için kullanılan bir kütüphanedir.
- **Lombok:** POJO sınıflarını daha kolay ve hızlı oluşturmak için kullanılır.

## Kurulum

Proje, Maven tabanlıdır. Aşağıdaki adımları izleyerek projeyi kurabilirsiniz.

### 1.JDK & Java Install
 **https://www.oracle.com/java/technologies/downloads/**

### 2.Maven Repository
 **https://mvnrepository.com/**

### 3.Install Maven Dependencies

Projenin API test kısmı için gerekli bağımlılıklar `pom.xml` dosyasına şu şekilde eklenmiştir:

```xml
<dependencies>
    <!-- API TEST ; RestAssured for REST API, JUnit for testing, JSON format support -->

    <!-- RestAssured for REST API Testing -->
    <dependency>
        <groupId>io.rest-assured</groupId>
        <artifactId>rest-assured</artifactId>
        <version>5.3.2</version>
        <scope>test</scope>
    </dependency>

    <!-- JSONPath for working with JSON data -->
    <dependency>
        <groupId>com.jayway.jsonpath</groupId>
        <artifactId>json-path</artifactId>
        <version>2.8.0</version>
    </dependency>

    <!-- JUnit for testing -->
    <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
        <version>4.13.2</version>
        <scope>test</scope>
    </dependency>

    <!-- Gson for JSON processing -->
    <dependency>
        <groupId>com.google.code.gson</groupId>
        <artifactId>gson</artifactId>
        <version>2.10.1</version>
    </dependency>

    <!-- Lombok for POJO classes -->
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <version>1.18.30</version>
        <scope>provided</scope>
    </dependency>
</dependencies>
```

# Contributing 🚀

To contribute to this project:

1. 🍴 **Fork** the repository.
2. 🌱 **Create** your own branch for changes (`git checkout -b feature/new-feature`).
3. 💾 **Commit** your changes (`git commit -m 'Added a new feature'`).
4. 📤 **Push** your branch (`git push origin feature/new-feature`).
5. 🔁 **Open** a Pull Request.

🎉 **Thanks a ton for checking out this project! Every step you take helps us grow. Keep pushing boundaries, and together, let's create something amazing!** 🚀💪

