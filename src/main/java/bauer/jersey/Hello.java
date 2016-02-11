package bauer.jersey;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;

@Component
@Path("/hello")
public class Hello {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getPlainText() {
		return "Hello Jersey";
	}

	@GET
	@Produces(MediaType.TEXT_XML)
	public String getXML() {
		return "<?xml version=\"1.0\"?>" + "<hello> Hello Jersey" + "</hello>";
	}

	@GET
	@Produces(MediaType.TEXT_HTML)
	public String getHtml() {
		StringBuilder builder = new StringBuilder();
		builder.append("<html> ");
		builder.append("<title>Hello Jersey</title>");
		builder.append("<body>");
		builder.append("<h1>Hello Jersey!</h1>");
		builder.append("</body>");
		builder.append("</html> ");
		return builder.toString();
	}

}