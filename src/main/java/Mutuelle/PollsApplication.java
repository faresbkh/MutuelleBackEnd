package Mutuelle;

import Mutuelle.model.LieuTrav;
import Mutuelle.repository.LieuTravRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;
import java.util.TimeZone;

@SpringBootApplication
@EntityScan(basePackageClasses = {
		PollsApplication.class,
		Jsr310JpaConverters.class
})
public class PollsApplication {

	@PostConstruct
	void init() {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	}

	@Autowired
	private LieuTravRepository lieuTravRepository ;

	public static void main(String[] args) {
		SpringApplication.run(PollsApplication.class, args);



	}

}
