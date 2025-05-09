def call(String Project, String ImageTag, String DockerHubUser){
   withCredentials([usernamePassword(credentialsId: 'dockerhub-cred', passwordVariable: 'dockerHubPass',usernameVariable: 'dockerHubUser')]) {
      sh "docker login -u ${env.dockerHubUser} -p ${env.dockerHubPass}"
   }
     sh "docker push ${DockerHubUser}/${Project}:${ImageTag}"
}
