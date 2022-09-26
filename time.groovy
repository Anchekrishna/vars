def call(body) {
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
}
