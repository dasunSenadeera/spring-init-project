pipeline {
    agent any
        stages {
            stage ('Compile Stage') {

                steps {
                     withEnv(["JAVA_HOME=${ tool name: 'java8', type: 'jdk' }") {

                         withMaven(maven : 'apache-maven-3.6.3') {
                            bat'mvn clean compile'
                         }
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
              steps {
                 bat 'docker build -t dcedannoruwa/test-app .'
              }
            }
            stage('Push Docker Image'){
              steps {
                 withCredentials([string(credentialsId: 'docker-pw', variable: 'docker-pwd')]) {
                    bat "docker login -u dcedannoruwa -p ${docker}"
                    bat 'docker PUSH dcedannoruwa/test-app .'
                 }
               }
            }
        }
}
