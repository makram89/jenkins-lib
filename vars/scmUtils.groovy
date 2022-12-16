def gitCheckout(Map stageParams) {
 
    checkout([
        $class: 'GitSCM',
        branch: [[branch :  stageParams.branch ]],
        userRemoteConfigs: [[ url: stageParams.url, credentialsId : stageParams.credentialsID ]]
    ])
  }

def setGitUserInfo(Map stageParams)
{
    sh "git config user.name ${stageParams.username}"
    sh "git config user.email ${stageParams.email}"
   
}

def gitCommit(Map stageParams)
{
  commitInfo([
        Message: [[msg:  stageParams.Message ]],
        GitAdd : [[ addString: stageParams.GitAdd  ]]
        
    ])  

}

def gitPush()
{
    sh "git push"
}


def check_branch() {
    println "You're on branch:"
    sh "git branch"
}