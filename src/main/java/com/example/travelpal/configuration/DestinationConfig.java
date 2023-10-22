package com.example.travelpal.configuration;

import com.example.travelpal.repository.DestinationRepository;
import com.example.travelpal.models.Destination;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

//@Configuration
//@PropertySource({ "classpath:persistence-multiple-db.properties" })
//@EnableJpaRepositories(
//        basePackages = "com.baeldung.multipledb.dao.product",
//        entityManagerFactoryRef = "destinationEntityManager",
//        transactionManagerRef = "destinationTransactionManager"
//)
//public class DestinationConfiguration {
//    @Autowired
//    private Environment env;
//
//    @Bean
//    @ConfigurationProperties(prefix="spring.datasource.destination")
//    public LocalContainerEntityManagerFactoryBean destinationEntityManager() {
//        LocalContainerEntityManagerFactoryBean em
//                = new LocalContainerEntityManagerFactoryBean();
//        em.setDataSource(destinationDataSource());
//        em.setPackagesToScan(
//                new String[] { "com.baeldung.multipledb.model.product" });
//
//        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//        em.setJpaVendorAdapter(vendorAdapter);
//        HashMap<String, Object> properties = new HashMap<>();
//        properties.put("hibernate.hbm2ddl.auto",
//                env.getProperty("hibernate.hbm2ddl.auto"));
//        properties.put("hibernate.dialect",
//                env.getProperty("hibernate.dialect"));
//        em.setJpaPropertyMap(properties);
//
//        return em;
//    }
//
//    @Bean
//    public DataSource destinationDataSource() {
//
//        DriverManagerDataSource dataSource
//                = new DriverManagerDataSource();
//        dataSource.setDriverClassName(
//                env.getProperty("jdbc.driverClassName"));
//        dataSource.setUrl(env.getProperty("destination.jdbc.url"));
//        dataSource.setUsername(env.getProperty("postgres"));
//        dataSource.setPassword(env.getProperty("postgres"));
//
//        return dataSource;
//    }
//
//    @Bean
//    public PlatformTransactionManager destinationTransactionManager() {
//
//        JpaTransactionManager transactionManager
//                = new JpaTransactionManager();
//        transactionManager.setEntityManagerFactory(
//                destinationEntityManager().getObject());
//        return transactionManager;
//    }
//}


@Configuration
public class DestinationConfig {

    @Bean
    CommandLineRunner commandLineRunner(DestinationRepository repository){
        return args -> {
            Destination destination1 = new Destination(
                    "Paris",
                    "Paris, France",
                    "The City of Love"
            );

            Destination destination2 = new Destination(
                    "New York City",
                    "New York, USA",
                    "The Big Apple"
            );

            repository.saveAll(
                    List.of(destination1 ,destination2)
            );
        };
    }
}
