def call(String Project, String ImageTag, String DockerHubUser){
   withCredentials([usernamePassword(credentialsId: 'docker', passwordVariable: 'dockerHubPass',usernameVariable: 'dockerHubUser')]) {
      sh "docker login -u ${env.dockerHubUser} -p ${env.dockerHubPass}"
   }
     sh "docker push ${DockerHubUser}/${Project}:${ImageTag}"
}
