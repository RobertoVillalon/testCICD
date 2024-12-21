pipeline {
    agent any

    environment {
        DOCKER_IMAGE = "mi-springboot-app:latest"
        CONTAINER_NAME = "springboot-app"
        APP_PORT = "8080"
    }

    triggers {
        // Dispara el pipeline automáticamente cuando se realiza un push a la rama "main"
        pollSCM('H/5 * * * *')
    }

    stages {
        stage('Clonar Repositorio') {
            steps {
                git branch: 'main', url: 'https://github.com/RobertoVillalon/testCICD.git'
            }
        }

        stage('Construir Aplicación') {
            steps {
                bat './mvnw clean package -DskipTests=true'
            }
        }

        stage('Construir Imagen Docker') {
            steps {
                bat 'docker build -t ${DOCKER_IMAGE} .'
            }
        }

        stage('Desplegar en Docker Local') {
            steps {
                script {
                    bat """
                    # Detener y eliminar el contenedor existente si está en ejecución
                    docker stop ${CONTAINER_NAME} || true
                    docker rm ${CONTAINER_NAME} || true

                    # Ejecutar un nuevo contenedor con la última versión de la imagen
                    docker run -d --name ${CONTAINER_NAME} -p ${APP_PORT}:8080 ${DOCKER_IMAGE}
                    """
                }
            }
        }
    }

    post {
        success {
            echo 'Despliegue completado exitosamente.'
        }
        failure {
            echo 'El despliegue falló. Revisa los errores.'
        }
    }
}
