@Library('jenkins-shared-lib-practice') _

pipeline {
    agent any

    environment {
        DEPLOY_ENV = "staging"
    }

    stages {
        stage('Checkout') {
            steps {
                checkoutCode(branch: 'main', repo: 'your-org/your-app')
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
