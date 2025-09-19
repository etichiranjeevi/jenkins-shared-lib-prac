@Library('jenkins-shared-lib-practice@main') _

pipeline {
    agent any

    environment {
        DEPLOY_ENV = "staging"
    }

    stages {
        stage('Clean Workspace') {
            steps {
                deleteDir() // remove all files from previous builds
            }
        }

        stage('Checkout') {
            steps {
                 git url: 'https://github.com/etichiranjeevi/jenkins-shared-lib-prac.git', branch : 'main'
            }
        }

        stage('Fix Script Permissions') {
            steps {
                sh 'chmod +x *.sh'
                sh 'ls -l *.sh'
            }
        }

        stage('Build') {
            steps {
                buildApp()
            }
        }

        stage('Unit Test') {
            steps {
                runTests(testType: 'unit')
            }
        }

        stage('Integration Test') {
            steps {
                runTests(testType: 'integration')
            }
        }

        stage('Security Scan') {
            steps {
                sh './security_scan.sh'
            }
        }

        stage('Package') {
            steps {
                packageApp()
            }
        }

        stage('Deploy to Staging') {
            steps {
                deployApp(env: DEPLOY_ENV)
            }
        }

        stage('Notify') {
            steps {
                notifySlack(message: "Pipeline finished successfully!")
            }
        }
    }

    post {
        failure {
            notifySlack(message: "Pipeline failed!")
        }
        success {
            notifySlack(message: "Pipeline succeeded!")
        }
    }
}
