pipeline {
    agent any
        stages {
            stage ('Compile Stage') {

                steps {
                    withMaven(maven : 'apache-maven-3.6.3') {
                        bat'mvn clean compile'
                    }
                }
            }
            stage ('Testing Stage') {
                steps {
                    withMaven(maven : 'apache-maven-3.6.3') {
                        bat'mvn test'
                    }
                }
            }
            stage ('Install Stage') {
                steps {
                    withMaven(maven : 'apache-maven-3.6.3') {
                        bat'mvn install'
                     }
                }
            }
            stage('Build Docker Image'){
                bat 'docker build -t dcedannoruwa/test-app .'
            }
            stage('Push Docker Image'){
                bat 'docker PUSH -t dcedannoruwa/test-app .'
            }
        }
}