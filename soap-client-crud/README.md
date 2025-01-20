# Soap Config CRUD CLIENT:

POM.xml :

<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
<!--				<configuration>
					<source>1.8</source>
					<target>1.8</target>
				</configuration>-->
			</plugin>
			<plugin>
				<groupId>org.jvnet.jaxb2.maven2</groupId>
				<artifactId>maven-jaxb2-plugin</artifactId>
				<version>0.13.2</version>
				<executions>
					<execution>
						<goals>
							<goal>generate</goal>
						</goals>
					</execution>
				</executions>
				<configuration>
					<!--<generatePackage>com.example.soapwebservice.articles</generatePackage>-->
					<generateDirectory>${project.basedir}/src/main/java</generateDirectory>
					<schemaDirectory>${project.basedir}/src/main/resources/wsdl</schemaDirectory>
					<schemaIncludes>
						<include>*.wsdl</include>
					</schemaIncludes>
				</configuration>
			</plugin>
		</plugins>
	</build>

---------------------------------------------------------------------------------------------------------

@Configuration
public class SoapConfig {

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setPackagesToScan("com.example.soapwebservice.articles","com.example.soapwebservice.employees");

        return marshaller;
    }
}

---------------------------------------------------------------------------------------------------------

@RestController
public class ArticlesController {

    @Autowired
    private SoapArticlesClient soapArticlesClient;

    @GetMapping("/getNameArticlesController")
    public String getNameArticlesController() {
        return "Getting the ArticlesController";
    }

    @GetMapping("/getArticlesById/{articleId}")
    public GetArticlesByIdResponse getArticlesById(@PathVariable Long articleId) {
        return soapArticlesClient.getArticlesById(articleId);
    }

    @GetMapping("/getAllArticles")
    public GetAllArticlesResponse getAllArticles() {
        return soapArticlesClient.getAllArticles();
    }

    @PostMapping("/addArticles")
    public AddArticlesResponse addArticles(@RequestBody AddArticlesRequest request) {
        return soapArticlesClient.addArticles(request);
    }

    @PutMapping("/updateArticles")
    public UpdateArticlesResponse updateArticles(@RequestBody UpdateArticlesRequest request) {
        return soapArticlesClient.updateArticles(request);
    }

    @DeleteMapping("/deleteArticlesById/{articleId}")
    public DeleteArticlesResponse deleteArticlesById(@PathVariable Long articleId) {
        return soapArticlesClient.deleteArticlesById(articleId);
    }
}

---------------------------------------------------------------------------------------------------------

@Service
public class SoapArticlesClient {

    @Autowired
    private Jaxb2Marshaller jaxb2Marshaller;

    private WebServiceTemplate webServiceTemplate;

    public static final String URL = "http://localhost:8086/ws";

    public GetArticlesByIdResponse getArticlesById(Long articleId) {
        GetArticlesByIdRequest request = new GetArticlesByIdRequest();
        request.setArticleId(articleId);
        return (GetArticlesByIdResponse) getWebServiceTemplate().marshalSendAndReceive(URL, request);
    }

    public GetAllArticlesResponse getAllArticles() {
        GetAllArticlesRequest request = new GetAllArticlesRequest();
        return (GetAllArticlesResponse) getWebServiceTemplate().marshalSendAndReceive(URL,request);
    }

    public AddArticlesResponse addArticles(AddArticlesRequest request) {
        return (AddArticlesResponse) getWebServiceTemplate().marshalSendAndReceive(URL, request);
    }

    public UpdateArticlesResponse updateArticles(UpdateArticlesRequest request) {
        return (UpdateArticlesResponse) getWebServiceTemplate().marshalSendAndReceive(URL, request);
    }

    public DeleteArticlesResponse deleteArticlesById(Long articleId) {
        DeleteArticlesRequest request = new DeleteArticlesRequest();
        request.setArticleId(articleId);
        return (DeleteArticlesResponse) getWebServiceTemplate().marshalSendAndReceive(URL, request);
    }

    private WebServiceTemplate getWebServiceTemplate() {
        webServiceTemplate = new WebServiceTemplate(jaxb2Marshaller);
        return webServiceTemplate;
    }
}

---------------------------------------------------------------------------------------------------------
