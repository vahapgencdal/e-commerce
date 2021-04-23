# Spring Cloud Access Microservice 

## Settings
1. we added config-client as dependency so it will automaticly finding by config-server
2. but firstly config-server should be in run mode
3. goto Application.yml file and code below
    ```
		spring:
		  application:
		    name: access-service

		server:
		  port: ${port:8100}
    ```
    *  here we specify application name have to be same with folder name
    * then we specify port for config server. port parameter can be taken from environment variables.
4. then we added PropertyAccessBean, PropertyAccessValue and Controller for see environment-variable repo properties
	```
	@Component
	@ConfigurationProperties(prefix="property-file")
	public class PropertyAccessBean {

	    private String name;
	    private String description;
	}
	
	public class PropertyAccessValue {

	    private String name;
	    private String description;

    }


    @RequestMapping("/access")
	public class PropertyFileAccessController {
		
		@Autowired
		private PropertyAccessBean propertyAccessBean;

		@GetMapping("/accessPropertyFile")
	    public PropertyAccessValue accesPropertyFile(){

	        return new PropertyAccessValue(propertyAccessBean.getName(),
	                propertyAccessBean.getDescription());
	    }
	}    

    ```

then you are going to just run.
### Benefit
here we can see beatiful way of spring cloud it take environment-variables from repo automatically.
1. if you will not specify active profile it will take default properties.
2. go application properties and put ```spring.active.profile:DEV``` then it will read access-service-dev.properties for example.
3. The Problem when we try to refresh our properties file we will get old values. because of that we need actuator
**Actuator**: Spring Boot includes a number of additional features to help you monitor and manage your application when you push it to production. You can choose to manage and monitor your application by using HTTP endpoints or with JMX. Auditing, health, and metrics gathering can also be automatically applied to your application.
```
management:
  endpoints:
    web:
      exposure:
        include: refresh
````
and you need to add that yaml file.
still if you try to take new value you will get old value. if you want to resolve that you need actuator refresh. so before each call you need to
post actuator refresh
```
