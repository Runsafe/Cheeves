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
        ant 'Default'
        jdk 'Default'
      }
      steps { buildPluginWithAnt env.plugin, '', 'build/jar/*.jar' }
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
