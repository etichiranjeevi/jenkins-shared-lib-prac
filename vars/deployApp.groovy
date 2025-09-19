def call(Map params = [:]) {
    sh "./deploy.sh ${params.env}"
}
