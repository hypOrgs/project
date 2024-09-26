#!/bin/bash
# 此脚本可用来本地打包并构建镜像
cd ..
mvn clean package -Dmaven.test.skip=true
image=ypan-project
namespace=ypan25
#月度版本分支
version=1.0.0

alispace=registry.cn-shanghai.aliyuncs.com

sudo docker buildx inspect --bootstrap
sudo docker buildx build -t $alispace/$namespace/$image:$version --platform linux/amd64 -o type=docker -f ./deploy/Dockerfile .

password=Ab123456
# 按需是否登陆harbor，是否推送镜像
docker login $alispace --username hyp2411 --password $password
docker push $alispace/$namespace/$image:$version

