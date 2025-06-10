Annotations :

1) @Autowired
2) @Controller
3) @RestController
4) @RequestMapping
5) @GetMapping
6) @PostMapping
7) @PutMapping
8) @DeleteMapping
9) @Service
10) @Component
11) @Repository
12) @Bean
13) @Qualifier
14) @Primary
15) @Value
16) @PropertySource
17) @PropertySources
18) @ControllerAdvice
19) @ExceptionHandler
20) @Lazy
21) @Scope
22) @RequestParam
23) @PathVariable
24) @PostConstruct
25) @AllArgsConstructor
26) @NoArgsConstructor
27) @Getter
28) @Setter
29) @Builder
30) @ToString
31) @Configuration

@Bean

1) Bean annotation indicates that method produce the bean to be managed by Spring Container
2) Bean annotation declared in Configuration class to create Spring bean

@Autowired

1) Qualifier annotation is used in conjuction with Autowired to avoid confusion when we have two or more beans configured for same type

@Primary

1) We use @Primary annotation to give higher preference to bean when there are multiple beans of same type

Stereotype meta Annotation:

1) @RestController / @Controller
2) @Service
3) @Component
4) @Repository


Spring Bean Scope :

1) singleton - only one instance of the bean created andshared across the entire application
2) prototype - new instance of the bean created every time
3) request - available web app
4) session - available web app
5) application - available web app
6) websocket - available web app

@Value :

1) Used to assign default values to variable and method arguments
2) Used to get the values for specific property key from the properties file
3) Read spring environment variable as well as system variable


@PropertySource / @PropertySources :

1) @PropertySource annotation is used to provide properties file to Spring environment
2) @PropertySources annotation is used to provide multiple properties file to Spring environment
3) These annotation is used with @Configuration
4) @PropertySource is repeatable we can have multiple @PropertySources on a configuration
5) we can use @Value annotation to read value from properties file
 
 