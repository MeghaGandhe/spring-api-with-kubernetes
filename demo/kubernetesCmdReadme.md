---First install kubectl in your local machine, which will create minikube cluster in local machine---
##set minikube to use local docker registry using minikube docker deamon as your registry
minikube start --driver=docker
eval $(minikube -p minikube docker-env)
minikube start (To start the minikube)

##No need to apply pod if you are using deployment for the pods.
kubectl apply -f pod.yaml
kubectl get pods
kubectl get pods --all-namespaces

kubectl apply -f service.yaml
kubectl get service
kubectl get service --all-namespaces
kubectl explain service (To explain the service detail)

kubectl apply -f deployment.yaml
kubectl get deployment
kubectl explain deployment (To explain the deployment details.)

##To get the URL to access the pod
minikube service <service_name> -n <namespace>
 minikube addons enable ingress (To install ingress controller)
 
##Ingress commands
kubectl apply -f ingress.yaml
kubectl get ingress --all-namespace
kubectl get ingress -n <namespace_name>

##Delete
kubectl delete -f <file_name>

##Describe command for describing pod, service, deployment and ingress detail. 
##All command are similar just update the name as per requirement
kubectl describe ingress <ingress_name> -n <namespace_name>
kubectl describe deployment <deployment_name> -n <namespace_name>

##Checking Dns in kubectl
 kubectl run -i --tty --rm dns-test --image=busybox --restart=Never -- sh (It will open terminal)
 ##Run below command to check if DNS resolution is happening or not
 nslookup spring-api-service.learning.svc.cluster.local

## For checking logs
kubectl logs -n <namespace> <Ingress_controller_name>

###############Issues##############################
####If your ingress is in different namespace then you service, it can not access the service. For that either you place
ingress in same namespace as your service or create a ExternalNameService as created in externalService.yml file by providing
fully qualified name of the service.###########

###################Troubleshooting Commands#####################
kubectl get endpoints -n <namespace_name> <service_name>
kubectl logs -n kube-system -l k8s-app=kube-dns