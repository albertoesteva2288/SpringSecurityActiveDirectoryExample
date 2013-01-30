SpringSecurityActiveDirectoryExample
====================================

Spring Security example using Active Directory

In order to run the application, the spring-security.xml file should be modified
for your environment.

Specifically the second parameter should contain an Active Directory domain
controller address.

The example is below.

        <beans:constructor-arg value="ldap://server1.my.domain.com/" />

When testing, the username should be entered in the following format:

username@server1.my.domain.com