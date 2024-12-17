package fr.mb.auth;

import java.io.IOException;
import javax.sql.DataSource;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import io.zonky.test.db.postgres.embedded.EmbeddedPostgres;

@TestConfiguration
public class EmbeddedPostgresConfig {
    
     @Bean
    DataSource dataSource() throws IOException {
	        EmbeddedPostgres embeddedPostgres = EmbeddedPostgres.builder().start();
	        return embeddedPostgres.getPostgresDatabase();
	    }
}