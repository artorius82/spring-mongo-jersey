package bauer.jersey;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import bauer.jersey.customer.CustomerReader;
import bauer.jersey.customer.CustomerWriter;

@Configuration
public class JerseyConfig extends ResourceConfig {
	
	public JerseyConfig() {
        register(Hello.class);
        register(CustomerReader.class);
        register(CustomerWriter.class);
    }

}
