package bauer.jersey.customer;

import javax.annotation.PostConstruct;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Path("/customer/write")
public class CustomerWriter {

	@Autowired
	private CustomerRepository repository;

	@PostConstruct
	private void doAfterDependencyInjection() {
		repository.deleteAll();

		repository.save(new Customer("Alice", "Smith"));
		repository.save(new Customer("Bob", "Smith"));
	}

	@GET
	@Produces(MediaType.TEXT_HTML)
	public String getHtml(@QueryParam("firstName") String firstName, @QueryParam("lastName") String lastName) {
		if (StringUtils.isEmpty(firstName)) {
			return "ERROR: parameter firstName must be not empty!";
		}
		if (StringUtils.isEmpty(lastName)) {
			return "ERROR: parameter lastName must be not empty!";
		}
		Customer customer = repository.save(new Customer(firstName, lastName));
		return "Successfully saved new customer: " + customer;
	}

}