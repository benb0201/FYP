package com.example.travelpal.client;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import javax.swing.text.html.parser.Entity;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

import static java.time.Month.JANUARY;
import static java.time.Month.OCTOBER;

//@Configuration
//@EnableTransactionManagement
//@EnableJpaRepositories(
//        basePackages = "com.example.travelpal.client",
//        entityManagerFactoryRef = "clientEntityManager",
//        transactionManagerRef = "clientTransactionManager"
//)
//public class ClientConfiguration {
//
//    @Autowired
//    private Environment env;
//
//    @Primary
//    @Bean (name = "clientDataSource")
//    public DataSource dataSource() {
//
//        DriverManagerDataSource ds = new DriverManagerDataSource();
////        dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
//        ds.setUrl(env.getProperty("spring.datasource.client.url"));
//        ds.setUsername(env.getProperty("spring.datasource.client.username"));
//        ds.setPassword(env.getProperty("spring.datasource.client.password"));
//
//        return ds;
//    }
//
//    @Bean (name = "clientEntityManagerFactory")
//    @Primary
//    @ConfigurationProperties(prefix="spring.datasource.client")
//    public LocalContainerEntityManagerFactoryBean entityManager() {
//        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
//        em.setDataSource(dataSource());
//        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//        em.setJpaVendorAdapter(vendorAdapter);
//        HashMap<String, Object> properties = new HashMap<>();
//        properties.put("hibernate.hbm2ddl.auto", "create-drop");
//        properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
//        em.setJpaPropertyMap(properties);
//        em.setPackagesToScan("com.example.travelpal.client");
//
//        return em;
//    }
//
//    @Primary
//    @Bean (name = "clientTransactionManager")
//    public PlatformTransactionManager clientTransactionManager(@Qualifier("clientEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
//        return new JpaTransactionManager(entityManagerFactory);
//    }
//}

@Configuration
public class ClientConfig {

    @Bean
    CommandLineRunner commandLineRunner(ClientRepository repository){
        return args -> {
            Client angel = new Client(
                    "Angel",
                    "angel.a@tmail.com",
                    LocalDate.of(2003, OCTOBER, 2)
            );

            Client ben = new Client(
                    "Ben",
                    "ben.b@tmail.com",
                    LocalDate.of(2002, JANUARY, 15)
            );

            repository.saveAll(
                    List.of(angel ,ben)
            );
        };
    }
}
