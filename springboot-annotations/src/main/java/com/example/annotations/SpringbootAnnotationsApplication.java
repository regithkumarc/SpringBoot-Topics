package com.example.annotations;

import com.example.annotations.autowired.AutowiredComponent1;
import com.example.annotations.bean.BeanClass1;
import com.example.annotations.component.ComponentClass1;
import com.example.annotations.environment.EnvironmentClass1;
import com.example.annotations.primary.PrimaryComponent1;
import com.example.annotations.propertySource.PropertySourceClass1;
import com.example.annotations.propertySources.PropertySourcesClass1;
import com.example.annotations.qualifier.QualifierComponent1;
import com.example.annotations.repository.RepositoryInterface1;
import com.example.annotations.restController.RestController1;
import com.example.annotations.scope.PrototypeClass1;
import com.example.annotations.scope.SingletonClass1;
import com.example.annotations.service.ServiceClass1;
import com.example.annotations.springBootApplication.SpringBootComponent;
import com.example.annotations.value.ValueAnnotation1;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootAnnotationsApplication {

	public static void main(String[] args) {
		var context = SpringApplication.run(SpringbootAnnotationsApplication.class, args);

		//Component
		SpringBootComponent springBootComponent = context.getBean(SpringBootComponent.class);
		springBootComponent.printName();

		SpringBootComponent springBootComponent1 = (SpringBootComponent) context.getBean("springbootComp");
		springBootComponent1.printName();

		//Autowired
		AutowiredComponent1 autowiredComponent1 = context.getBean(AutowiredComponent1.class);
		autowiredComponent1.printName();

		//Qualifier
		QualifierComponent1 qualifierComponent1 = context.getBean(QualifierComponent1.class);
		qualifierComponent1.printMessage();

		//Primary
		PrimaryComponent1 primaryComponent1 = context.getBean(PrimaryComponent1.class);
		primaryComponent1.printMessage();

		//Bean
		BeanClass1 beanClass1 = context.getBean(BeanClass1.class);
		beanClass1.printMessage();

		//Rest Controller
		RestController1 restController1 = context.getBean(RestController1.class);
		restController1.printMessage();

		//Service
		ServiceClass1 serviceClass1 = context.getBean(ServiceClass1.class);
		serviceClass1.printMessage();

		//Repository
		RepositoryInterface1 repositoryInterface1 = context.getBean(RepositoryInterface1.class);
		repositoryInterface1.printMessage();

		//Lazy
		//LazyClass1 lazyClass1 = context.getBean(LazyClass1.class);
		//lazyClass1.printMessage();

		//Eager
		//EagerClass1 eagerClass1 = context.getBean(EagerClass1.class);
		//eagerClass1.printMessage();

		//Scope
		SingletonClass1 singletonClass1 = context.getBean(SingletonClass1.class);
		System.out.println(singletonClass1.hashCode());

		SingletonClass1 singletonClass2 = context.getBean(SingletonClass1.class);
		System.out.println(singletonClass2.hashCode());

		SingletonClass1 singletonClass3 = context.getBean(SingletonClass1.class);
		System.out.println(singletonClass3.hashCode());

		PrototypeClass1 prototypeClass1 = context.getBean(PrototypeClass1.class);
		System.out.println(prototypeClass1.hashCode());

		PrototypeClass1 prototypeClass2 = context.getBean(PrototypeClass1.class);
		System.out.println(prototypeClass2.hashCode());

		PrototypeClass1 prototypeClass3 = context.getBean(PrototypeClass1.class);
		System.out.println(prototypeClass3.hashCode());

		//Value
		ValueAnnotation1 valueAnnotation1 = context.getBean(ValueAnnotation1.class);
		valueAnnotation1.printMessage();

		//PropertySource
		PropertySourceClass1 propertySourceClass1 = context.getBean(PropertySourceClass1.class);
		propertySourceClass1.printMessage();

		//PropertySources
		PropertySourcesClass1 propertySourcesClass1 = context.getBean(PropertySourcesClass1.class);
		propertySourcesClass1.printMessage();

		//Environment
		EnvironmentClass1 environmentClass1 = context.getBean(EnvironmentClass1.class);
		environmentClass1.printMessage();

		//Component
		ComponentClass1 componentClass1 = context.getBean(ComponentClass1.class);
		componentClass1.printMessage();
	}

}
