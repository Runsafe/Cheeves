pipeline {
  agent { label 'ant' }
  triggers { pollSCM '@monthly' }
  stages {
    stage('Ant Build') {
      steps {
        copyArtifacts(projectName: '/Runsafe/Framework/master', filter:'**/*.jar', optional: false, flatten: true, target: 'framework');
        withAnt(installation: 'Ant 1.10.14', jdk: 'JDK 1.8') {
          sh "ant -Drunsafe.dir=framework -Dlib.dir=framework -f ant.xml"
        }
        scanForIssues tool: java()
        archiveArtifacts artifacts: 'build/jar/*.jar', onlyIfSuccessful: true
      }
    }
  }
}
