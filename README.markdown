# tasc-sample-jar

This project is intended to provide a basic training ground for introducing TASC developers to common development tools, like Maven, JUnit, Mockito. 

This project also provides a place to experiment with our release strategy and git workflow.

## Initial Assignments

Each developer is required to perform the following tasks with this project:

1. Fork this project into their account. You'll need to register with github first, and add your tasconline.com email address to your account.
2. Clone their fork onto their workstation. Eclipse has Git support built in; clone your fork, not the repository under the tasconline group. If we've configured things properly you likely won't have push permission to the tasc-sample-jar repo in the tasconline group.
3. Checkout the tasc-sample-jar project in your Eclipse workspace.
4. Create a topic branch to begin your work. From the command line, this is *git checkout -b topic-branch-name*. 
4. Add "interesting code" along with complete javadocs and unit tests. 
    1. Interesting code can be clever patterns or unique approaches that you have come up with in your career. Keep it on the small side, just a few classes. 
    2. Your code should be in a sub-package of com.tasconline.sample, like com.tasconline.sample.nblair. 
    3. Don't add any TASC core dependencies beyond tasc-common. You are free to add a dependency or 2 from Maven Central.
5. Commit your changes to your local repo. Remember this commit is local, and only on your workstation until you push. 
5. When you feel your branch is complete, push it up to the fork in your personal account. Verify the name of the remote repository, for most it will be *origin*. At the command line, execute *git push origin topic-branch-name*.
6. Log into github, navigate to the topic branch in your personal fork, and issue a pull request against tasconline/tasc-sample-jar. 
 
We'll reject your request if your code doesn't compile, or if the javadocs are incomplete, or if there aren't any unit tests. Treat this as you would any real production bug.

Those developers that have push access to tasconline/tasc-sample-jar: you still have to follow the same procedure. Don't push your topic branch to tasconline/tasc-sample-jar, push it to the fork in your personal account. You can't approve your own Pull Request either - someone else has to.

