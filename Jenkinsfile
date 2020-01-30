pipeline {
    agent any
        stages {
            stage ('Compile Stage') {

                steps {
                     withEnv(["JAVA_HOME=${ tool name: 'java8', type: 'jdk' }"]) {

                         withMaven(maven : 'apache-maven-3.6.3') {
                            bat'mvn clean compile'
                         }
                    }
                }
            }
            stage ('Testing Stage') {
                steps {
                        withEnv(["JAVA_HOME=${ tool name: 'java8', type: 'jdk' }"]) {
                            withMaven(maven : 'apache-maven-3.6.3') {
                                bat'mvn test'
                            }
                         }
                }
            }
            stage ('Install Stage') {
                steps {
                        withEnv(["JAVA_HOME=${ tool name: 'java8', type: 'jdk' }"]) {
                            withMaven(maven : 'apache-maven-3.6.3') {
                                bat'mvn install'
                             }
                        }
                }
            }
            stage('Build Docker Image'){
              steps {
                // bat 'docker build -t dcedannoruwa/test-app .'
                 bat 'docker build -f Dockerfile -t dcedannoruwa/test-app .'


              }
            }
            stage('view Docker Images'){
              steps {

                    bat 'docker images'

               }
            }
            stage('Push Docker Image'){
               steps {

                  bat 'docker run -p 8089:8089 test-app'
               }
            }
        }
}
