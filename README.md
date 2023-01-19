**Backend project readme.** 

In order to run our website we need firstly to run frontend on server http://team5.hopto.org and then backend on server http://team5.hopto.org/api/hello
In order to run locally, we need firstly to set up properties and make docker-compose up for backend and for frontend docker-compose up.

1. We have 3 different components in our project: controller, service, post.
2. Backend is deployed to server using nginx reverse proxy.
3. Database is deployed to server
4. Domain name is added to our ip server 193.40.255.30 and logic for writing "hello" on our website is implemented and it is possibe to check using link http://team5.hopto.org/api/hello
5. Here will be our logic description in future.

Changelog for tests change-log: classpath:/db/changelog/changelog-test-data.xml
Changelog for project change-log: classpath:/db/changelog/changelog-root.xml

Change docker image name:
1)Terminal in java.
2)sudo docker rename (old name) (new name)
3) This step is optional. To confirm that it is now using a new name: sudo docker ps

This one is for server.
ssh -i ./.ssh/krsobo_id_rsa -l ubuntu 193.40.255.30