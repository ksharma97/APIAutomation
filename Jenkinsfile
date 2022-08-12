pipeline{
	agent none
	stages{
		stage('Build Jar'){
			agent{
				docker{
					image 'maven:3-alpine'
					args '-v /root/.m2:/root/.m2
				}
			}
			steps{
				sh 'mvn clean package -DskipTests'
			}
		}
		stage('Build image'){
			steps{
				script{
					app = docker.build("Kundan/CredencAutoAPI")
					}
				}
		}
		stage('Push image'){
			steps{
				script{
					docker.withRegistry('https://registry.hub.docker.com", 'dockerhun'){
						app.push("${BUILD_NUMBER}")
						app.push("latest")
						}
				}
			}
		}
	}
}