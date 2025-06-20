Centralized log Config:

application.yml 

		<!-- Centralized Log -->
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-aop</artifactId>
		</dependency>
		
--------------------------------------------------------------------------------
		
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAdvice {

    private final Logger logger = LoggerFactory.getLogger(LoggingAdvice.class);

    @Pointcut(value = "execution(* com.example.centralizedlog.*.*.*(..) )")
    public void myPointCut() {}

    @Around("myPointCut()")
    public Object applicationLogInfo(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        ObjectMapper objectMapper = new ObjectMapper();
        String methodName = proceedingJoinPoint.getSignature().getName();
        String className = proceedingJoinPoint.getTarget().getClass().toString();
        Object[] objects = proceedingJoinPoint.getArgs();
        logger.info("method invoked {} : {} () arguments : {}", className, methodName, objectMapper.writeValueAsString(objects));
        Object object = proceedingJoinPoint.proceed();
        logger.info("{} : {} () Response : {}", className, methodName, objectMapper.writeValueAsString(objects));
        return object;
    }
}
