pipeline {
  agent any
  stages {
    stage('testing') {
      steps {
        junit(allowEmptyResults: true, testResults: 'linkedlist')
      }
    }

  }
}