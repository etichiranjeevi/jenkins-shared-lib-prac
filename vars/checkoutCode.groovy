def call(Map params = [:]) {
    checkout([$class: 'GitSCM',
        branches: [[name: params.branch]],
        userRemoteConfigs: [[url: "https://github.com/${params.repo}.git"]]
    ])
}
