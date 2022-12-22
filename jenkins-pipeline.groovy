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
                sh 'apt-get update -y'
                sh 'wget https://downloads.accurics.com/cli/latest/accurics_linux -O tcs-iac-scanner'
                sh 'chmod +x tcs-iac-scanner'
                sh './tcs-iac-scanner init'
                sh './tcs-iac-scanner scan -mode=pipeline -appurl=https://cloud.tenable.com/cns -token=d17ef27a-1e94-443e-a80c-b747dec8585d -fail' 
            }
        }
        stage('Deploy') { 
            steps {
                echo('Stage - Deploy') 
            }
        }
    }
}
