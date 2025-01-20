# Soap Config CRUD WEBSERVICE:

POM.xml :

<!-- https://mvnrepository.com/artifact/org.springframework.ws/spring-ws-core -->
<dependency>
	<groupId>org.springframework.ws</groupId>
	<artifactId>spring-ws-core</artifactId>
</dependency>

<dependency>
	<groupId>wsdl4j</groupId>
	<artifactId>wsdl4j</artifactId>
</dependency>

<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
			</plugin>
			<plugin>
				<groupId>org.codehaus.mojo</groupId>
				<artifactId>jaxb2-maven-plugin</artifactId>
				<version>1.6</version>
				<executions>
					<execution>
						<id>xjc</id>
						<goals>
							<goal>xjc</goal>
						</goals>
					</execution>
				</executions>
				<configuration>
					<schemaDirectory>${project.basedir}/src/main/resources/</schemaDirectory>
					<outputDirectory>${project.basedir}/src/main/java</outputDirectory>
					<clearOutputDir>false</clearOutputDir>
				</configuration>
			</plugin>
		</plugins>
	</build>

---------------------------------------------------------------------------------------------------------

@Configuration
@EnableWs
public class SoapConfig {		
		    
	@Bean("articles")
    public DefaultWsdl11Definition articles(XsdSchema xsdSchema) {
        DefaultWsdl11Definition defaultWsdl11Definition = new DefaultWsdl11Definition();
        defaultWsdl11Definition.setPortTypeName("ArticleEndpoint");
        defaultWsdl11Definition.setLocationUri("/ws");
        defaultWsdl11Definition.setTargetNamespace("http://www.example.com/soapwebservice/articles");
        defaultWsdl11Definition.setSchema(articlesSchema());

        return defaultWsdl11Definition;
    }

    @Bean("employees")
    public DefaultWsdl11Definition employees(XsdSchema xsdSchema) {
        DefaultWsdl11Definition defaultWsdl11Definition = new DefaultWsdl11Definition();
        defaultWsdl11Definition.setPortTypeName("EmployeesEndPoint");
        defaultWsdl11Definition.setLocationUri("/ws");
        defaultWsdl11Definition.setTargetNamespace("http://www.example.com/soapwebservice/employees");
        defaultWsdl11Definition.setSchema(employeeSchema());

        return defaultWsdl11Definition;
    }

    @Bean
    public XsdSchema articlesSchema() {
        return new SimpleXsdSchema(new ClassPathResource("articles.xsd"));
    }

    @Bean
    @Primary
    public XsdSchema employeeSchema() {
        return new SimpleXsdSchema(new ClassPathResource("employees.xsd"));
    }
}

---------------------------------------------------------------------------------------------------------

@Endpoint
public class ArticleEndpoint {

    private static final String NAMESPACE = "http://www.example.com/soapwebservice/articles";

    @Autowired
    private ArticleService articleService;

    @PayloadRoot(namespace = NAMESPACE, localPart = "getArticlesByIdRequest")
    @ResponsePayload
    public GetArticlesByIdResponse getArticlesByIdRequest(@RequestPayload GetArticlesByIdRequest getArticlesByIdRequest) {
        GetArticlesByIdResponse response = new GetArticlesByIdResponse();
        ArticlesInfo articleInfo = new ArticlesInfo();
        Articles articles = articleService.getArticleById(getArticlesByIdRequest.getArticleId());
        System.out.println("Articles : " + articles);
        if (articles != null) {
            BeanUtils.copyProperties(articles, articleInfo);
            response.setArtricleInfo(articleInfo);
        }

        System.out.println("Get Articles By ID Response : " + response);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE, localPart = "getAllArticlesRequest")
    @ResponsePayload
    public GetAllArticlesResponse getAllArticlesRequest(@RequestPayload GetAllArticlesRequest getAllArticlesRequest) {
        GetAllArticlesResponse response = new GetAllArticlesResponse();
        List<ArticlesInfo> articleInfoList = new ArrayList<>();

        List<Articles> articlesList = articleService.getAllArticles();
        ArticlesInfo articleInfo = null;
        for(int i=0; i<articlesList.size(); i++) {
            articleInfo = new ArticlesInfo();
            BeanUtils.copyProperties(articlesList.get(i), articleInfo);
            articleInfoList.add(articleInfo);
        }

        response.getArticleInfo().addAll(articleInfoList);
        System.out.println("Get All Articles Response : " + response);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE, localPart = "addArticlesRequest")
    @ResponsePayload
    public AddArticlesResponse addArticlesRequest(@RequestPayload AddArticlesRequest addArticleRequest) {
        AddArticlesResponse response = new AddArticlesResponse();
        ServiceStatus serviceStatus = new ServiceStatus();

        Articles articles = new Articles();
        articles.setTitle(addArticleRequest.getTitle());
        articles.setCategory(addArticleRequest.getCategory());

        Articles addedArticle = articleService.addArticle(articles);
        System.out.println("addedArticle : " + addedArticle);
        if (addedArticle != null) {
            ArticlesInfo articleInfo = new ArticlesInfo();
            BeanUtils.copyProperties(articles, articleInfo);
            response.setArticleInfo(articleInfo);
            serviceStatus.setStatusCode("SUCCESS");
            serviceStatus.setMessage("Data Added Successfully");
        } else {
            serviceStatus.setStatusCode("CONFLICT");
            serviceStatus.setMessage("Data Already Available");
        }

        response.setServiceStatus(serviceStatus);
        System.out.println("Added Articles Response : " + response);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE, localPart = "updateArticlesRequest")
    @ResponsePayload
    public UpdateArticlesResponse updateArticlesRequest(@RequestPayload UpdateArticlesRequest request) {
        UpdateArticlesResponse response = new UpdateArticlesResponse();
        ServiceStatus serviceStatus = new ServiceStatus();
        Articles articles = articleService.getArticleById(request.getArticleId());
        if (articles != null) {
            Articles updateArticles = new Articles();
            updateArticles.setArticleId(request.getArticleId());
            updateArticles.setTitle(request.getTitle());
            updateArticles.setCategory(request.getCategory());
            articleService.updateArticle(updateArticles);

            ArticlesInfo articleInfo = new ArticlesInfo();
            BeanUtils.copyProperties(updateArticles, articleInfo);
            response.setArticleInfo(articleInfo);
            serviceStatus.setStatusCode("SUCCESS");
            serviceStatus.setMessage("Data Updated Successfully");
        } else {
            serviceStatus.setStatusCode("NO DATA");
            serviceStatus.setMessage("No Data Available");
        }

        response.setServiceStatus(serviceStatus);
        System.out.println("Updated Articles Response : " + response);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE, localPart = "deleteArticlesRequest")
    @ResponsePayload
    public DeleteArticlesResponse deleteArticlesRequest(@RequestPayload DeleteArticlesRequest request) {
        DeleteArticlesResponse response = new DeleteArticlesResponse();
        Articles articles = articleService.getArticleById(request.getArticleId());
        ServiceStatus serviceStatus = new ServiceStatus();
        if (articles != null) {
            ArticlesInfo articleInfo = new ArticlesInfo();
            BeanUtils.copyProperties(articles, articleInfo);
            response.setArticleInfo(articleInfo);
            articleService.deleteArticle(articles);
            serviceStatus.setStatusCode("SUCCESS");
            serviceStatus.setMessage("Data Deleted Successfully");
        } else {
            serviceStatus.setStatusCode("NO DATA");
            serviceStatus.setMessage("No Data Available");
        }

        response.setServiceStatus(serviceStatus);
        System.out.println("Deleted Articles Response : " + response);
        return response;
    }

}

---------------------------------------------------------------------------------------------------------

@Service
public class ArticleService implements IArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public List<Articles> getAllArticles() {
        return articleRepository.findAll();
    }

    @Override
    public Articles getArticleById(long articleId) {
        Optional<Articles> optional = articleRepository.findById(articleId);
        return optional.orElse(null);
    }

    @Override
    public Articles addArticle(Articles articles) {
        articleRepository.save(articles);
        Optional<Articles> optional = articleRepository.findById(articles.getArticleId());
        return optional.orElse(null);
    }

    @Override
    public void updateArticle(Articles articles) {
        Optional<Articles> optional = articleRepository.findById(articles.getArticleId());
        if (optional.isPresent()) {
            articleRepository.save(articles);
        }
    }

    @Override
    public void deleteArticle(Articles articles) {
        Optional<Articles> optional = articleRepository.findById(articles.getArticleId());
        if (optional.isPresent()) {
            articleRepository.deleteById(articles.getArticleId());
        }
    }
}

---------------------------------------------------------------------------------------------------------
