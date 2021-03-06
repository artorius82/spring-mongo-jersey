package bauer.jersey;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

@Configuration
@EnableMongoRepositories
public class MongoConfiguration extends AbstractMongoConfiguration {

	@Override
	protected String getDatabaseName() {
		return "test1";
	}

	@Override
	public Mongo mongo() throws Exception {
		return new MongoClient();
	}
	
	@Override
	  protected String getMappingBasePackage() {
	    return "bauer.jersey";
	}

}
