# Sales Tracking API

Sales Tracking API, satış verilerini yönetmek ve takip etmek amacıyla geliştirilmiş bir backend uygulamasıdır. Bu proje, **Spring Boot**, **PostgreSQL**, **JPA**, ve **Hibernate** kullanılarak oluşturulmuştur. Aşağıdaki açıklamalar, kullanılan teknolojiler ve Swagger dökümantasyonunun detaylarını içermektedir.

---

## Teknolojik Altyapı

Bu proje, aşağıdaki teknolojiler ve araçlar kullanılarak geliştirilmiştir:

### **Java 17+**
Proje, **Java 17** sürümünü kullanarak geliştirilmiştir. Java'nın en güncel özelliklerinden faydalanarak verimli bir backend çözümü sunulmuştur.

### **Spring Boot**
Proje, **Spring Boot** ile geliştirilmiştir. Spring Boot, Java tabanlı uygulamalar için hızlı ve kolay bir başlangıç noktası sağlar, yapılandırmayı minimize eder ve uygulamanın çalıştırılmasını basitleştirir.

### **Spring Data JPA ve Hibernate**
Veritabanı yönetimi için **Spring Data JPA** kullanılmıştır. Bu, veritabanı ile etkileşimi kolaylaştırırken, **Hibernate** ORM (Object Relational Mapping) kullanarak nesnelerle veritabanı arasındaki ilişkileri yönetir.

### **PostgreSQL**
Veritabanı olarak **PostgreSQL** kullanılmıştır. PostgreSQL, güçlü ve açık kaynaklı bir ilişkisel veritabanıdır.

### **Lombok**
Proje, **Lombok** kütüphanesini kullanarak daha temiz ve okunabilir bir kod yazmayı sağlar. Lombok, getter, setter, toString gibi metodları otomatik olarak oluşturur.

### **Maven**
Proje, bağımlılıkları yönetmek ve proje yapısını oluşturmak için **Maven** kullanmaktadır. Maven, projenin derlenmesini ve bağımlılıkların yönetilmesini kolaylaştırır.

### **Swagger**
Projenin RESTful API'lerinin belgelendirilmesi için **Swagger** kullanılmıştır. Swagger, API'lerinizi açık ve kolay anlaşılır bir şekilde dökümante eder ve test etmeyi kolaylaştırır.

---

## Swagger Dökümantasyonu Görselleri

### **Customer API (Müşteri API)**
Müşteri API'si, müşteri verilerinin yönetilmesini sağlar. Bu API ile müşterilerin listelenmesi, eklenmesi, güncellenmesi ve silinmesi mümkündür.

- ![Customer API Swagger Görünümü](https://github.com/ynskrc23/sales-tracking/blob/master/image/customer.png)

### **Invoice API (Fatura API)**
Fatura API'si, satışlara ait faturaların yönetilmesini sağlar. Faturaların oluşturulması, görüntülenmesi ve düzenlenmesi bu API ile yapılabilir.

- ![Invoice API Swagger Görünümü](https://github.com/ynskrc23/sales-tracking/blob/master/image/inovice.png)

### **Product API (Ürün API)**
Ürün API'si, satışa sunulan ürünlerin yönetilmesini sağlar. Ürünlerin listelenmesi, eklenmesi, düzenlenmesi ve silinmesi işlemleri yapılabilir.

- ![Product API Swagger Görünümü](https://github.com/ynskrc23/sales-tracking/blob/master/image/product.png)

### **Sale API (Satış API)**
Satış API'si, satış işlemlerinin yönetilmesini sağlar. Satışların kaydedilmesi ve sorgulanması için kullanılır.

- ![Sale API Swagger Görünümü](https://github.com/ynskrc23/sales-tracking/blob/master/image/sale.png)

### **Sales Representative API (Satış Temsilcisi API)**
Satış Temsilcisi API'si, satış temsilcilerinin yönetilmesini sağlar. Temsilcilerin listelenmesi, eklenmesi, düzenlenmesi ve silinmesi işlemleri yapılabilir.

- ![Sales Representative API Swagger Görünümü](https://github.com/ynskrc23/sales-tracking/blob/master/image/sales-rep.png)

---

## Proje Yapısı

Proje aşağıdaki temel bileşenlerden oluşmaktadır:

### 1. **Entities (Varlıklar)**
Projede yer alan her bir varlık (Customer, Product, Sale, Invoice, Sales Representative) veritabanı tablolarına karşılık gelir. JPA ve Hibernate kullanılarak bu varlıklar arasındaki ilişkiler yönetilmektedir.

### 2. **Repositories (Depolar)**
JPA ile veritabanı işlemleri yapılır. Her varlık için bir repository arayüzü bulunur ve bu arayüzler ile veritabanı üzerinde CRUD (Create, Read, Update, Delete) işlemleri yapılır.

### 3. **Services (Servisler)**
Her varlık için ilgili servisler bulunur. Servisler, iş mantığını içerir ve repository'ler üzerinden veri çekilip işlendikten sonra, controller'lara iletilir.

### 4. **Controllers (Denetleyiciler)**
API'lerin istemciler tarafından erişilmesini sağlayan denetleyicilerdir. Swagger dökümantasyonunda her bir endpoint (API) burada tanımlanır ve kullanıcılara sunulur.

### 5. **Security (Güvenlik)**
Proje, **Spring Security** ile güvenlik sağlanır. Kullanıcı kimlik doğrulaması ve yetkilendirme işlemleri JWT (JSON Web Token) ile yapılır.

---

## Kullanım Rehberi

Proje başlatıldıktan sonra, aşağıdaki adımlar izlenerek API'ler kullanılabilir:

1. **Projeyi Başlatma**: 
   - Projeyi başlatmak için `mvn spring-boot:run` komutunu kullanabilirsiniz.
   
2. **API'leri Kullanma**:
   - API'lere erişim Swagger üzerinden sağlanabilir. Swagger dökümantasyonu, API endpoint'lerinin nasıl kullanılacağını ve parametrelerin nasıl iletileceğini açıkça gösterir.

3. **Güvenlik**:
   - API'lere erişmeden önce kullanıcıların giriş yapması gerekmektedir. JWT token alındıktan sonra, API'lere yetkilendirilmiş bir şekilde erişilebilir.

---

## Projeyi Çalıştırma Adımları

1. **Bağımlılıkları Yükleme**:
   - Maven kullanarak proje bağımlılıklarını yüklemek için şu komutu çalıştırın:
     ```
     mvn clean install
     ```

2. **Veritabanı Yapılandırması**:
   - **PostgreSQL** veritabanı bağlantı bilgilerini `application.properties` dosyasına ekleyin:
     ```properties
     spring.datasource.url=jdbc:postgresql://localhost:5432/sales_tracking
     spring.datasource.username=your_username
     spring.datasource.password=your_password
     spring.jpa.hibernate.ddl-auto=update
     ```

3. **Uygulamayı Başlatma**:
   - Uygulamayı başlatmak için:
     ```
     mvn spring-boot:run
     ```

---

## Kullanılan Teknolojiler

- `Java 17+`
- `Spring Boot`
- `Spring Data JPA`
- `Hibernate`
- `PostgreSQL`
- `Lombok`
- `Maven`
- `Swagger`

---

Bu proje, **Sales Tracking** sistemini kurmak ve yönetmek için modern ve güçlü teknolojiler kullanılarak geliştirilmiştir. API dökümantasyonu, geliştiricilerin ve kullanıcıların uygulamanın işlevlerini hızlıca anlamalarına ve kullanmalarına olanak tanır.
