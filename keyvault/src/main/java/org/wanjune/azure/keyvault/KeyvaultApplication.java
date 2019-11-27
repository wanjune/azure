package org.wanjune.azure.keyvault;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.wanjune.azure.keyvault.domain.DemoDomain;
import org.wanjune.azure.keyvault.mapper.DemoMapper;

import java.util.List;

@SpringBootApplication
public class KeyvaultApplication implements CommandLineRunner {

    private final DemoMapper demoMapper;

    @Value("${azure.keyvault.uri}")
    private String KV_URI;

    @Value("${azure.keyvault.client-id}")
    private String KV_ClientId;

    @Value("${azure.keyvault.client-key}")
    private String KV_ClientKey;

    public KeyvaultApplication(DemoMapper demoMapper) {
        this.demoMapper = demoMapper;
    }

    public static void main(String[] args) {
        SpringApplication.run(KeyvaultApplication.class, args);
    }

    @Override
    public void run(String... args) {
        // Check [Key Vault]
        System.out.println(String.format("\nConnection String stored in Azure Key Vault[uri]:\n%s", KV_URI));
        System.out.println(String.format("\nConnection String stored in Azure Key Vault[client-id]:\n%s", KV_ClientId));
        System.out.println(String.format("\nConnection String stored in Azure Key Vault[client-key]:\n%s", KV_ClientKey));
        System.out.println("\n");

        // Check DataBase Link and Query Result
        List<DemoDomain> demoDomainList = this.demoMapper.selectAll();
        DemoDomain demoDomainItem = null;
        // Print
        if(demoDomainList.size() > 0) {
            System.out.println(String.format("\n No : Sex \t UserID \t Points "));
        }
        for (int i = 0; i < demoDomainList.size(); i++) {
            demoDomainItem = demoDomainList.get(i);
            System.out.println(String.format("\n %s : %s \t %s \t %s ", i+1, demoDomainItem.getSex(), demoDomainItem.getUserId(), demoDomainItem.getPoints()));
        }
    }
}
