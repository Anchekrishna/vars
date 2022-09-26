

def call(body) {
    Map params = [
            APP_NAME: null,
            PACKAGING: null,
            AWS_S3_BUCKET_NAME  : null,
            S3_ARTIFACT_PATH    : null
    ]

    ParamBinder.bind(params, this, body)

    pipeline {
    agent any

    stages {
        stage('Hello') {
            steps {
                sh '''date > test
                cat test'''
            }
        }
    }    
    post {
        always 
            {archiveArtifacts artifacts: 'test', followSymlinks: false}
        }
}
