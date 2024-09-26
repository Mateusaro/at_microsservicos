# Assessment Microsserviços

A aplicação consiste em um sistema de gerenciamento de tarefas para usuários

## Pré-requisitos

Antes de começar, você precisará ter instalado:
- [Docker](https://www.docker.com/)
- [Minikube](https://minikube.sigs.k8s.io/docs/start/)

## Clonando o Projeto

Clone este repositório em sua máquina local:

```bash
git clone <URL-do-repositorio>
cd <nome-do-repositorio>
```
## Executando o Docker Compose
O projeto inclui um arquivo docker-compose.yml localizado na pasta ***banco***.

Para executar o Docker Compose, siga os passos abaixo:

- Navegue até a pasta do banco:
```cd banco ```
- Execute o Docker Compose com o seguinte comando: ```docker-compose up```

## Deploy no Kubernetes

### Executando o Minikube:

Execute o comando: ```minikube start```

Após executar o Docker Compose, você pode aplicar os arquivos de configuração do Kubernetes que estão localizados na pasta ***kubernetes*** na raiz do projeto.

### Comandos para aplicar as configurações:
```
kubectl apply -f tarefas-deployment.yaml
kubectl apply -f banco-deployment.yaml
kubectl apply -f atribuicao-deployment.yaml
kubectl apply -f tarefas.yaml
kubectl apply -f banco.yaml
kubectl apply -f atribuicao.yaml
```
### Port Forwarding

Após aplicar os arquivos, você pode usar os seguintes comandos para expor os serviços nas portas desejadas:
```
kubectl port-forward deployment/banco-deployment 8080:8080
kubectl port-forward deployment/tarefas-deployment 8081:8081
kubectl port-forward deployment/atribuicao-deployment 8082:8082
```

### Caso ocorra problemas com ImagePullBackOff
- Utilize o comando para parar o Minikube: ```minikube stop```
- Use o comando do login do docker: ```docker login```
- Faça a tag da imagem: ```docker tag banco-banco:latest {Seu Usuario Docker}/{Nome da Imagem}:{Tag da Imagem}```
- Depois faça o Push da imagem: ```docker push {Seu Usuario Docker}/{Nome da Imagem}:{Tag da Imagem}```
- Delete o Minikube: ```minikube delete```
- Inicie novamente o Minikube ```minikube start```

## Utilização no Postman

### Criar Tarefa
***POST***
- http://localhost:8081/tarefas

````
{
  "titulo": "Tarefa",
  "descricao": "Descrição Tarefa",
  "prazo": "2024-10-01",
  "prioridade": "ALTA"
}
````

### Criar Atribuição para Tarefa
***POST***
- http://localhost:8082/atribuicoes
```
{
    "idTarefa": {ID da Tarefa},
    "usuarioAtribuido": {Email do usuário}
}
```

### Consulta Tarefas
***GET***
- http://localhost:8081/tarefas

### Consulta Atribuições
***GET***
- http://localhost:8082/atribuicoes
