pipeline {
    agent any 
    stages {
        stage('Build') { 
            steps {
                echo('Stage - Build') 
            }
        }
        stage('Test') { 
            steps {
                echo('Stage - Test') 
                sh 'echo downloading Tenable CS CLI'
                sh 'wget --auth-no-challenge https://downloads.accurics.com/cli/latest/accurics_linux -O tcs-iac-scanner'
            }
        }
        stage('Deploy') { 
            steps {
                echo('Stage - Deploy') 
            }
        }
    }
}
