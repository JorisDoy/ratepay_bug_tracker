try{
    node {
        def app

        stage('Clone Repository') {
              final scmVars = checkout(scm)
              env.BRANCH_NAME = scmVars.GIT_BRANCH
              env.SHORT_COMMIT = "${scmVars.GIT_COMMIT[0..7]}"
              env.GIT_REPO_NAME = scmVars.GIT_URL.replaceFirst(/^.*\/([^\/]+?).git$/, '$1')
        }

        stage('Run Java Unit Tests') {
              withMaven(maven: 'M3') {
                /// Run the maven build
                sh "mvn -Dmaven.test.failure.ignore=false -Dserver.port=8090 -Dhttp.proxyHost=proxy3 -Dhttp.proxyPort=8080 -Dhttps.proxyHost=proxy3 -Dhttps.proxyPort=8080 clean package"
              }
            }
        stage('SonarQube code analysis') {
              withMaven(maven: 'M3') {
                withSonarQubeEnv('SonarQube') {
                  sh "mvn sonar:sonar"
                }
              }
        }
        stage('Build Docker Image') {
               app = docker.build("ratepay_bug_tracker/${env.GIT_REPO_NAME}")
        }
        stage('Push Image to aws Uat Registry') {
                retry(3) {
                  docker.withRegistry("uat-${env.REG_URL}", "uat-${env.UAT_REG_NAME}") {
                    app.push("uat-${env.SHORT_COMMIT}")
                    app.push("latest")
                  }
                }
              }
    }

} catch (Error | Exception e) {
  //Finish failing the build after telling someone about it
  throw e
} finally {
  // Post build steps here
  /* Success or failure, always run post build steps */
  // send email
  // publish test results etc etc
}
def version() {
  pom = readMavenPom file: 'pom.xml'
  return pom.version
}