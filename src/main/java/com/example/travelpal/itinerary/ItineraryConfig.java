package com.example.travelpal.itinerary;

import com.example.travelpal.client.Client;
import com.example.travelpal.client.ClientRepository;
import com.example.travelpal.destination.Destination;
import com.example.travelpal.destination.DestinationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

import static java.time.Month.AUGUST;
import static java.time.Month.JULY;

//@Configuration
//@PropertySource({ "classpath:persistence-multiple-db.properties" })
//@EnableJpaRepositories(
//        basePackages = "com.baeldung.multipledb.dao.product",
//        entityManagerFactoryRef = "itineraryEntityManager",
//        transactionManagerRef = "itineraryTransactionManager"
//)
//public class ItineraryConfiguration {
//    @Autowired
//    private Environment env;
//
//    @Bean
//    @ConfigurationProperties(prefix="spring.datasource.itinerary")
//    public LocalContainerEntityManagerFactoryBean itineraryEntityManager() {
//        LocalContainerEntityManagerFactoryBean em
//                = new LocalContainerEntityManagerFactoryBean();
//        em.setDataSource(itineraryDataSource());
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
//    public DataSource itineraryDataSource() {
//
//        DriverManagerDataSource dataSource
//                = new DriverManagerDataSource();
//        dataSource.setDriverClassName(
//                env.getProperty("jdbc.driverClassName"));
//        dataSource.setUrl(env.getProperty("itinerary.jdbc.url"));
//        dataSource.setUsername(env.getProperty("postgres"));
//        dataSource.setPassword(env.getProperty("postgres"));
//
//        return dataSource;
//    }
//
//    @Bean
//    public PlatformTransactionManager itineraryTransactionManager() {
//
//        JpaTransactionManager transactionManager
//                = new JpaTransactionManager();
//        transactionManager.setEntityManagerFactory(
//                itineraryEntityManager().getObject());
//        return transactionManager;
//    }
//}


@Configuration
public class ItineraryConfig {
    @Bean
    CommandLineRunner commandLineRunner(ItineraryRepository itineraryRepository, ClientRepository clientRepository, DestinationRepository destinationRepository) {
        return args -> {
            // Create clients
            Client client1 = clientRepository.save(new Client("Alice", "alice@example.com", LocalDate.of(1990, JULY, 15)));
            Client client2 = clientRepository.save(new Client("Bob", "bob@example.com", LocalDate.of(1985, AUGUST, 25)));

            // Create destinations
            Destination destination1 = destinationRepository.save(new com.example.travelpal.destination.Destination("Paris", "France", "Eiffel Tower, Louvre Museum"));
            Destination destination2 = destinationRepository.save(new com.example.travelpal.destination.Destination("New York", "USA", "Statue of Liberty, Central Park"));

            // Create itineraries
            List<Destination> destinations1 = List.of(destination1, destination2);
            List<Destination> destinations2 = List.of(destination2);
            Itinerary itinerary1 = new Itinerary("Summer Vacation", "Exploring Europe", LocalDate.of(2023, JULY, 1), LocalDate.of(2023, JULY, 15),
                    destinations1, client1);

            Itinerary itinerary2 = new Itinerary("City Break", "Quick getaway", LocalDate.of(2023, AUGUST, 10), LocalDate.of(2023, AUGUST, 15),
                    destinations2, client2);

            itineraryRepository.saveAll(List.of(itinerary1, itinerary2));
        };
    }
}