package br.com.team.management.services.config;

import javax.ws.rs.ApplicationPath;

import br.com.team.management.services.resource.ProfessionalAllocationResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.wadl.internal.WadlResource;
import org.springframework.stereotype.Component;

import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;

@ApplicationPath("/team/management/v1")
@Component
public class JerseyConfig extends ResourceConfig {

	public JerseyConfig() {
		register(ProfessionalAllocationResource.class);
		register(WadlResource.class);
		register(ApiListingResource.class);
		register(SwaggerSerializers.class);

		BeanConfig conf = new BeanConfig();
		conf.setTitle("TEAM MANAGEMENT");
		conf.setDescription(
				"API to integrate services with team management relationship.");
		conf.setContact("Vitor Tadashi - Development Team");
		conf.setLicense("Vitor Tadashi - Copyright © 2017 todos os direitos reservados");
		conf.setVersion("v1");
		conf.setSchemes(new String[] { "http", "https" });
		conf.setResourcePackage("br.com.team.management.services");
		conf.setScan(true);
	}

}
