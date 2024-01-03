pipeline {
  agent { label 'ant' }
  triggers { pollSCM '@monthly' }
  stages {
    stage('Ant Build') {
      steps {
        copyArtifacts(projectName: '/Runsafe/Framework/master', filter:'framework.tar', optional: false, target: 'framework');
        sh 'tar -C framework -xvf framework/framework.tar'
        withAnt(installation: 'Ant 1.10.14', jdk: 'JDK 1.8') {
          sh "ant -Drunsafe.dir=framework -Dlib.dir=framework -f ant.xml"
        }
        scanForIssues tool: java()
        archiveArtifacts artifacts: 'build/jar/*.jar', onlyIfSuccessful: true
      }
    }
  }
}
