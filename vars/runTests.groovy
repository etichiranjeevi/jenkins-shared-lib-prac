def call(Map params = [:]) {
    if (params.testType == 'unit') {
        sh './run_unit_tests.sh'
    } else if (params.testType == 'integration') {
        sh './run_integration_tests.sh'
    } else {
        error "Unknown test type: ${params.testType}"
    }
}
