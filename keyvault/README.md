## Development with Key-Vault 
#### Run or Debug, 设置环境变量
**①编辑运行参数IDEA**
>`RUN` -> `Editors Configurations...`
>`Configuration` -> `Environment` -> `variables`
>`User environment variables:`

**②添加以下内容IDEA**
```textmate
BASE_URI=https://实际地址
CLIENT_ID=实际CLIENT_ID
CLIENT_SECRET=实际CLIENT_KEY
```

## Docker image with Key-Vault
**设置Docker image运行参数**
```textmate
docker run -dit --env BASE_URI=https://实际地址 --env CLIENT_ID=实际CLIENT_ID --env CLIENT_SECRET=实际CLIENT_KEY --name 项目名称 -p 80:8080 项目名称:指定TAG
```

