# Spring Security

## Spring Security Dependency
* spring-context
* spring-security-core
* spring-security-web
* spring-security-config
* spring-security-taglibs

## Spring Security와 별도로 DB정보 (username, password) 암호화
*jasypt, jasypt-spring Dependency

### Spring Security와 별도로 DB 정보 (username, password) 암호화
* jasypt, jasypt-spring Dependency

### 양방향 암호화, 단방향 암호화

### 양방향 암호화
* 한가지 도구를 사용하여 평문을 암호화하고, 다시 암호문을 평문으로 보호화하는 기능을 포함하는 암호화 기법

### 단방향 암호화
* 평문을 암호화는 할 수 있지만, 암호문을 평문으로 복호화 하는 도구를 제공하지 않는 암호화 기법
* 비번을 암호화하여 저장하였을 경우, 사용자가 입력한 평문을 암호화하여 저장된 암호문과 비교하여 일치하는지 알아 낸다.