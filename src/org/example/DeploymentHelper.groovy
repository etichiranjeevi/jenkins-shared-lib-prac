package org.example

class DeploymentHelper {
    static String getDeployCommand(String env) {
        return "./deploy.sh ${env}"
    }
}
