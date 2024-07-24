pipeline {
    agent any
    environment {
        DOCKER_IMAGE = 'your-docker-repo/your-docker-image-name'
        KUBE_CONTEXT = 'your-kube-context'
        REGISTRY_CREDENTIALS_ID = 'docker-registry-credentials'
    }
    stages {
        stage('Checkout') {
            steps {
                git 'https://your-repo-url.git'
            }
        }
        stage('Build') {
            steps {
                sh './mvnw clean package'
            }
        }
        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('SonarQube') {
                    sh './mvnw sonar:sonar'
                }
            }
        }
        stage('Security Scan') {
            steps {
                sh 'trivy fs .'
            }
        }
        stage('Docker Build & Push') {
            steps {
                script {
                    docker.withRegistry('https://index.docker.io/v1/', REGISTRY_CREDENTIALS_ID) {
                        def app = docker.build(DOCKER_IMAGE)
                        app.push('latest')
                    }
                }
            }
        }
        stage('Deploy to Kubernetes') {
            steps {
                withKubeConfig([credentialsId: 'your-kube-config-id', contextName: KUBE_CONTEXT]) {
                    sh 'kubectl apply -f k8s/deployment.yaml'
                }
            }
        }
    }
    post {
        always {
            cleanWs()
        }
    }
}
