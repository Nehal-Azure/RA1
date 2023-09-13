pipeline{
  agent any

  tools {
    maven "MAVEN_HOME"
  }

  stages {
    stage('Build 1'){
      steps{
        echo 'Build 1 is starting'
        bat "mvn clean test"
      }

      post {

        success{
          echo 'THis is test success message blok in jenkins file'
        }
      }
    }
    
  }
}
