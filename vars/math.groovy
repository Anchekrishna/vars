pipeline {
  agent any
    stages {
        stage('doing_math') {
            steps {
                sh '''echo $((x=2, y=3, x+y)) result >> output.txt
                if [ x+y = 6 ]
                then 
	                "false"
                else
	                "true"
                fi'''
            }
        }
    }    
    post {
        always 
            {archiveArtifacts artifacts: 'output.txt', followSymlinks: false}
        }
}
