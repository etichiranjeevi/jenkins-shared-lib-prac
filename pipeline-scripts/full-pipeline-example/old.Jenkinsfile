pipeline {
    agent any

    environment {
        DEPLOY_ENV = "staging"
    }

    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/your-org/your-app.git', branch: 'main'
            }
        }
        stage('Build') {
            steps {
                sh './build.sh'
            }
        }
        stage('Unit Test') {
            steps {
                sh './run_unit_tests.sh'
            }
        }
        stage('Integration Test') {
            steps {
                sh './run_integration_tests.sh'
            }
        }
        stage('Security Scan') {
            steps {
                sh './security_scan.sh'
            }
        }
        stage('Package') {
            steps {
                sh './package.sh'
            }
        }
        stage('Deploy to Staging') {
            steps {
                sh "./deploy.sh ${DEPLOY_ENV}"
            }
        }
        stage('Notify') {
            steps {
                echo "Pipeline finished; success!"
            }
        }
    }

    post {
        failure {
            echo "The pipeline failed!"
        }
        success {
            echo "The pipeline succeeded!"
        }
    }
}
