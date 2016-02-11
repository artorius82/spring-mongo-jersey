package bauer.jersey.customer;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Path("/customer/read")
public class CustomerReader {

	@Autowired
	private CustomerRepository repository;

	@GET
	@Produces(MediaType.TEXT_HTML)
	public String getHtml() {
		// fetch all customers
		StringBuilder builder = new StringBuilder();
		builder.append("Customers found with findAll():<br>");
		builder.append("---------------------------------------------------------------------------------------------------<br>");
		for (Customer customer : repository.findAll()) {
			builder.append(customer + "<br>");
		}
		builder.append("---------------------------------------------------------------------------------------------------<br><br>");

		builder.append("Customer found with findByFirstName('Alice'):<br>");
		builder.append("---------------------------------------------------------------------------------------------------<br>");
		builder.append(repository.findByFirstName("Alice")+"<br>");
		builder.append("---------------------------------------------------------------------------------------------------<br><br>");

		builder.append("Customers found with findByLastName('Smith'):<br>");
		builder.append("---------------------------------------------------------------------------------------------------<br>");
		for (Customer customer : repository.findByLastName("Smith")) {
			builder.append(customer + "<br>");
		}
		
		return builder.toString();
	}

}