Cloud Vault :

https://www.youtube.com/watch?v=n0kmSftlesE

1) download Vault from below path

https://developer.hashicorp.com/vault/install#windows

2) run the below comment :

E:\Software\vault_1.19.5_windows_amd64>vault.exe

3) Add this path in environment variable

E:\Software\vault_1.19.5_windows_amd64

4) open new terminal and run the below comment

C:\Users\welcome>vault server --dev --dev-root-token-id="00000000-0000-0000-0000-000000000000"

Administrative Namespace:
             Api Address: http://127.0.0.1:8200
                     Cgo: disabled
         Cluster Address: https://127.0.0.1:8201

2025-06-19T21:48:47.009+0530 [INFO]  core: post-unseal setup complete

5) open new terminal and run below comments 

C:\Users\welcome>set VAULT_ADDR=http://127.0.0.1:8200

-------------------------------------------------------------------------------------

6) run below comments for set secret userName and password

C:\Users\welcome>vault kv put secret/vault-configuration credentials.userName=Admin credentials.password=admin

======= Metadata =======
Key                Value
---                -----
created_time       2025-06-19T17:23:15.2741782Z
custom_metadata    <nil>
deletion_time      n/a
destroyed          false
version            1

-------------------------------------------------------------------------------------

6) run below comments for get secret userName and password

C:\Users\welcome>vault kv get secret/vault-configuration
========= Secret Path =========
secret/data/vault-configuration

======= Metadata =======
Key                Value
---                -----
created_time       2025-06-19T17:23:15.2741782Z
custom_metadata    <nil>
deletion_time      n/a
destroyed          false
version            1

============ Data ============
Key                     Value
---                     -----
credentials.password    admin
credentials.userName    Admin

-------------------------------------------------------------------------------------

7) run below comments for delete secret userName and password

C:\Users\welcome>vault kv delete secret/vault-configuration
Success! Data deleted (if it existed) at: secret/data/vault-configuration

8) After delete the secret and check the vaulues

C:\Users\welcome>vault kv get secret/vault-configuration
========= Secret Path =========
secret/data/vault-configuration

======= Metadata =======
Key                Value
---                -----
created_time       2025-06-19T17:23:15.2741782Z
custom_metadata    <nil>
deletion_time      2025-06-19T17:27:40.9346646Z
destroyed          false
version            1

-------------------------------------------------------------------------------------

9) run below comments for set secret userName and password

C:\Users\welcome>vault kv put secret/vault-configuration credentials.userName=Admin credentials.password=admin
========= Secret Path =========
secret/data/vault-configuration

======= Metadata =======
Key                Value
---                -----
created_time       2025-06-19T17:30:06.908156Z
custom_metadata    <nil>
deletion_time      n/a
destroyed          false
version            2


10) After delete the secret and check the vaulues

C:\Users\welcome>vault kv get secret/vault-configuration
========= Secret Path =========
secret/data/vault-configuration

======= Metadata =======
Key                Value
---                -----
created_time       2025-06-19T17:30:06.908156Z
custom_metadata    <nil>
deletion_time      n/a
destroyed          false
version            2

============ Data ============
Key                     Value
---                     -----
credentials.password    admin
credentials.userName    Admin

-------------------------------------------------------------------------------------

pom.xml


		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-vault-config</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-bootstrap</artifactId>
		</dependency>

-------------------------------------------------------------------------------------

@Data
@ConfigurationProperties("credentials")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Credentials {

    private String userName;
    private String password;
}


-------------------------------------------------------------------------------------


@SpringBootApplication
@EnableDiscoveryClient
@EnableConfigurationProperties(Credentials.class)
@Slf4j
public class VaultConfigurationApplication implements CommandLineRunner {

	private final Credentials credentials;

	public VaultConfigurationApplication(Credentials credentials) {
		this.credentials = credentials;
	}

	public static void main(String[] args) {
		SpringApplication.run(VaultConfigurationApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("UserName : {} " ,credentials.getUserName());
		log.info("Password : {} " ,credentials.getPassword());
	}
}

-------------------------------------------------------------------------------------

bootsrap.yml

spring:
  application:
    name: vault-configuration
  cloud:
   config:
     enabled: true
     backend: secret
     uri: http://localhost:8084
   vault:
     uri: http://localhost:8200/
     host: development
     port: 8200
     scheme: https
     kv:
       enabled: true
       application-name: vault-configuration
     token: 00000000-0000-0000-0000-000000000000