# Spring Cloud Product Microservice 

## Settings
1. we added config-client as dependency so it will automaticly finding by config-server
2. but firstly config-server should be in run mode
3. goto Application.yml file and code below
    ```
		spring:
		  application:
		    name: product-service

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