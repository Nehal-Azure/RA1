pipeline{
  agent any

  

  stages {
    stage('Build 1'){
      steps{
        echo 'Build 1 is starting'
        bat "mvn clean test -DBrowser=$Browser"
      }

      post {

        success{
          echo 'THis is test success message blok in jenkins file'
        }
      }
    }
    
  }
}
