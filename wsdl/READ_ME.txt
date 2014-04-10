Pre 1. Install the plugin Rearranger in intellij
Pre 2. Update Rearranger with configuration from Billing-integration\billing-integration\wsdl

1. Commit and push everything
     (you don't want to merge more than necessary)
2. git stash list must be empty
     (you don't want to merge more than necessary)
3. git pull --rebase
     (you don't want to merge more than necessary)
4. mvn clean install -Dintegration-tests
     (All tests MUST work)
5. Rename RoutingService.java to RoutingService<number>.java
6. Comment the last url in the plugin in the pom-file
7. Enter new url in the plugin in the pom-file
8. Execute mvn clean install -Dwsdl in module wsdl
9. Run Rearranger on folder wsdl/src/main/java
10. git add -A
11. Check difference on all updated files
     (Some files must be corrected before checkin)
12. mvn clean install -Dintegration-tests
     (All tests MUST work)
13. git commit and git push