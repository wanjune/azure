## Development with Key-Vault 
#### Run or Debug, 设置环境变量
**①编辑运行参数IDEA**
>`RUN` -> `Editors Configurations...`
>`Configuration` -> `Environment` -> `variables`
>`User environment variables:`

**②添加以下内容IDEA**
```textmate
AZURE_KEYVAULT_URI=[https://实际地址]
AZURE_KEYVAULT_CLIENT_ID=[实际CLIENT_ID]
AZURE_KEYVAULT_CLIENT_KEY=[实际CLIENT_KEY]
JASYPT_ENCRYPTOR_SALT=[实际SALT(盐)]
```

## Docker image with Key-Vault
**设置Docker image运行参数**
```textmate
docker run -dit --env BASE_URI=[https://实际地址] --env CLIENT_ID=[实际CLIENT_ID] --env CLIENT_SECRET=[实际CLIENT_KEY] --env ENCRYPT_SALT=[实际SALT(盐)] --name [项目名称] -p 80:8080 [项目名称]:[指定TAG]
```
