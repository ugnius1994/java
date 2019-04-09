package testai_main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

@SpringBootApplication
public class Spring1Application {

	public static void main(String[] args) {
		SpringApplication.run(Spring1Application.class, args); }

		@Bean
public Counter cnt (){
		return new Counter();
}
@Bean
public Integer intValue(){
		return 100;
}

}

class Counter{

	@Autowired
	Integer  a;

	private AtomicInteger count=new AtomicInteger();
	int getCount(){
		return count.addAndGet(1);
	}
}


@RestController
class Hello{

	final  private Counter counter;

	public Hello(Counter counter) {
		this.counter = counter;
	}

	@GetMapping("/")
	public String Hi(){
		return "hello tu"+counter.getCount();
	}
}
@RestController
class Labas{

	final  private Counter counter;

	public Labas(Counter counter) {
		this.counter = counter;
	}

	@GetMapping("/labas")
	public String Hi(){
		return "labas"+counter.getCount();
	}
}