#Schedule Project

##Technologies used

##J2EE
* servlet-api 3.1.0 - Allows **DefferedResult** and **return Callable** for spring (multithreading long polling)
* tomcat-catalina 7.0.57

###Model
* hibernate 4.3.8.Final
  * LocalSessionFactoryBean - Allows **dataSource** and **packagesToScan**
  * HibernateTransactionManager - Allows auto managing for transactions with **@Transactional** annotation
* hibernate-jpa-2.1-api 1.0.0.Final - Allows **@Entity**, **@ManyToOne** and others
* hibernate-validator 5.1.3.Final - Allows **@Valid**, **@NotEmpty**, ConstraintValidator and others

###Business Logic

* spring mvc 4.1.4.RELEASE
  * spring beans
  * mvc:annotation driven
    * conversionService -> Does the magic behind been auto binding
    * formatters
  * mvc:resources -> Allows mapping for static resources
  * tx:annotation-driven
  * context:annotation-config
  * context:component-scan -> Scan **@Component** and **@Service** for autowiring candidates
* i18n
  * messageSource - ReloadableResourceBundleMessageSource
  * localeResolver - SessionLocaleResolver
  * mvc:interceptors
    * SessionLocaleResolver Allows **?locale=fr** in URL
* log4j 1.2.17

###Database
* MySQL
* MySQL Workbench

###Front End and Templating
* Thymeleaf 2.1.4.RELEASE
  * thymeleaf-layout-dialect 1.2.1
* jstl 1.2
