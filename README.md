![Cybertek White Logo](https://cybertekschool.com/assets/img/cybertek_logo_dark.svg "Cybertek")

[![Build Status](https://travis-ci.com/Akbar300/TestMavenProject.svg?token=QMgM2JkxHxWqrxou4NfM&branch=master)](https://travis-ci.com/Akbar300/TestMavenProject)

# Test Maven Project with 3 CI Server

A Simple Maven Test Project to demonstrated Continues Integration with 
* GitHub Action
* Travis CI 
* Circle CI

Each git push will trigger CI build job for all three CI server.
Any pull request to merge to master branch must pass all the test or merge will fail.

## GitHub Action 

.github folder contains workflow folder
 It contains maven.yml file for configuring GitHub Action workflow.

    name: Java CI
    
    on: [push]
    
    jobs:
      build:
    
        runs-on: ubuntu-latest
    
        steps:
        - uses: actions/checkout@v1
        - name: Set up JDK 1.8
          uses: actions/setup-java@v1
          with:
            java-version: 1.8
        - name: Build with Maven
          run: mvn -B package --file pom.xml
## Travis CI
.travis.yml is used for configuring travis ci with GitHub Account directly.
    
    language: java
    jdk:
      - openjdk8
      - oraclejdk11
    cache:
      directories:
      - "$HOME/.m2"
## Circle CI
.circleci folder contains config.yml file for configuring circle ci configuration.

    # Java Maven CircleCI 2.0 configuration file
    #
    # Check https://circleci.com/docs/2.0/language-java/ for more details
    #
    version: 2
    jobs:
      build:
        docker:
          # specify the version you desire here
          - image: circleci/openjdk:8-jdk
    
          # Specify service dependencies here if necessary
          # CircleCI maintains a library of pre-built images
          # documented at https://circleci.com/docs/2.0/circleci-images/
          # - image: circleci/postgres:9.4
    
        working_directory: ~/repo
    
        environment:
          # Customize the JVM maximum heap limit
          MAVEN_OPTS: -Xmx3200m
    
        steps:
          - checkout
    
          # Download and cache dependencies
          - restore_cache:
              keys:
                - v1-dependencies-{{ checksum "pom.xml" }}
                # fallback to using the latest cache if no exact match is found
                - v1-dependencies-
    
          - run: mvn dependency:go-offline
    
          - save_cache:
              paths:
                - ~/.m2
              key: v1-dependencies-{{ checksum "pom.xml" }}
    
          # run tests!
          - run: mvn integration-test
