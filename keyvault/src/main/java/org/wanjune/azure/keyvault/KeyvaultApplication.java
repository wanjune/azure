package org.wanjune.azure.keyvault;

import com.microsoft.azure.PagedList;
import com.microsoft.azure.keyvault.KeyVaultClient;
import com.microsoft.azure.keyvault.models.SecretItem;
import com.microsoft.azure.keyvault.spring.AzureKeyVaultCredential;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.wanjune.azure.keyvault.domain.DemoDomain;
import org.wanjune.azure.keyvault.mapper.DemoMapper;

import java.util.List;

/**
 * @author wanjune
 */
@SpringBootApplication
public class KeyvaultApplication implements CommandLineRunner {

    private final DemoMapper demoMapper;

    /**
     * Key Vault
     */
    @Value("${azure.keyvault.uri}")
    private String KV_URI;
    @Value("${azure.keyvault.client-id}")
    private String KV_ClientId;
    @Value("${azure.keyvault.client-key}")
    private String KV_ClientKey;

    /**
     * Database
     */
    @Value("${spring.datasource.url}")
    private String dbUrl;
    @Value("${spring.datasource.username}")
    private String dbUsername;
    @Value("${spring.datasource.password}")
    private String dbPassword;


    public KeyvaultApplication(DemoMapper demoMapper) {
        this.demoMapper = demoMapper;
    }

    public static void main(String[] args) {
        SpringApplication.run(KeyvaultApplication.class, args);
    }

    @Override
    public void run(String... args) {

        // Check [Key Vault]
        System.out.println(String.format("\nAzure Key Vault[uri]:\n%s", KV_URI));
        System.out.println(String.format("\nAzure Key Vault[client-id]:\n%s", KV_ClientId));
        System.out.println(String.format("\nAzure Key Vault[client-key]:\n%s", KV_ClientKey));

        // All Key by the setting in URI of [Key Vault]
        KeyVaultClient kvClient = new KeyVaultClient(new AzureKeyVaultCredential(KV_ClientId, KV_ClientKey, 60L));
        PagedList<SecretItem> secrets = kvClient.listSecrets(KV_URI);
        System.out.println("\nAzure Key Vault Settings ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓ :");
        for (SecretItem secret : secrets) {
            System.out.println(secret.id().replaceFirst(KV_URI + "secrets/", "").replaceAll("-", "."));
        }

        // Check [Database] for [Key Vault]
        System.out.println(String.format("\nConnection String DB[url]:\n%s", dbUrl));
        System.out.println(String.format("\nConnection String DB[username]:\n%s", dbUsername));
        System.out.println(String.format("\nConnection String DB[password]:\n%s", dbPassword));
        System.out.println("\n");

        // Check DataBase Link and Query Result
        List<DemoDomain> demoDomainList = this.demoMapper.selectAll();
        DemoDomain demoDomainItem = null;
        // Print
        if (demoDomainList.size() > 0) {
            System.out.println(String.format("\n No : Sex \t UserID \t Points "));
        }
        for (int i = 0; i < demoDomainList.size(); i++) {
            demoDomainItem = demoDomainList.get(i);
            System.out.println(String.format("\n %s : %s \t %s \t %s ", i + 1, demoDomainItem.getSex(), demoDomainItem.getUserId(), demoDomainItem.getPoints()));
        }
    }
}
