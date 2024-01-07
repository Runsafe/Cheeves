pipeline {
  agent none
  options {
    copyArtifactPermission('*');
    skipDefaultCheckout true
  }
  environment { plugin = "Cheeves" }
  triggers { pollSCM '@monthly' }
  stages {
    stage('Ant Build') {
      agent { label 'ant' }
      tools {
        ant 'Ant 1.10.14'
        jdk 'JDK 1.8'
      }
      steps {
        checkout scm
        copyArtifacts(projectName: '/Runsafe/Framework/master', filter:'framework.tar', optional: false, target: 'framework');
        sh 'tar -C framework -xvf framework/framework.tar'
        sh "ant -Drunsafe.dir=framework -Dlib.dir=framework -f ant.xml"
        recordIssues enabledForFailure: true, tool: java(), unhealthy: 10
        archivePlugin '', '../build/jar/*.jar', "${env.plugin}.tar"
      }
    }
    stage('Deploy to test server') {
      agent { label 'server4' }
      steps {
        installPlugin "${env.plugin}.tar"
        buildReport env.plugin, 'Deployed to test server'
      }
    }
    stage('Wait for promotion') {
      steps { input message: 'Promote to server1?', submitter: 'mortenn' }
    }
    stage('Deploy to production server') {
      agent { label 'server1' }
      steps {
        stagePlugin "${env.plugin}.tar"
        buildReport env.plugin, 'Deployed to production server'
      }
    }
  }
  post { failure { buildReport env.plugin, 'Build failed' } }
}