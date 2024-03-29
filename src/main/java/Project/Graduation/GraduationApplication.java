package Project.Graduation;

import Project.Graduation.service.TopicFileService;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

import javax.annotation.Resource;

@SpringBootApplication
public class GraduationApplication implements CommandLineRunner {
    @Resource
	TopicFileService topicFileService;
	public static void main(String[] args) {
		SpringApplication.run(GraduationApplication.class, args);
	}

	@Bean
	public OpenAPI customOpenAPI(@Value("${application-description}") String description,
								 @Value("${application-version}") String version){
		return new OpenAPI()
						.info(new Info()
						.title("LANGUAGE API")
						.version(version)
						.description(description)
						.license(new License().name("Language Apı Licence")));
	}
	@Override
	public void run(String... arg) throws Exception {
		topicFileService.init();
	}



}
