def gitCheckout(Map stageParams) {
 
    checkout([
        $class: 'GitSCM',
        branch: [[branch :  stageParams.branch ]],
        userRemoteConfigs: [[ url: stageParams.url ]],
        credentialsID: [[credentialsId : stageParams.credentialsID]]
    ])
  }

def setGitUserInfo(Map stageParams)
{
    sh "git config user.name $stageParams.username"
    sh "git config user.email $stageParams.email"
   
}

def setGitUserInfo(Map stageParams)
{
  commitInfo([
        Message: [[msg:  stageParams.Message ]],
        GitAdd : [[ addString: stageParams.GitAdd  ]]
        
    ])  
    // TODO commit
}

def gitPush()
{

}


def check_branch() {
    println "You're on branch:"
    sh "git branch"
}