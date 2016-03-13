#19-logback-appenders-smtpappender-email

For executing this project and send logs via email it is required to set
email account credentials in logback.xml, but Gmail accounts need to
activate an additional setting (Access for less secure apps) in order to
avoid this issue:

How to fix “send-mail: Authorization failed 534 5.7.14 ”

For example:

NetBeans: JPDA Listening Start...
JPDA Address: eaz-jupiter:46079
Port:46079
cd /home/javier/projects/ConceptTest/Logging/logback/19-logback-appenders-smtpappender-email; JAVA_HOME=/usr/lib/jvm/jdk1.8.0_65 /home/javier/netbeans-8.0/java/maven/bin/mvn "-Dexec.args=-Xdebug -Xrunjdwp:transport=dt_socket,server=n,address=46079 -classpath %classpath com.eaz.logback.appenders.email.EMail" -Dexec.executable=/usr/lib/jvm/jdk1.8.0_65/bin/java -Dexec.classpathScope=runtime -Djpda.listen=true -Djpda.address=46079 org.codehaus.mojo:exec-maven-plugin:1.2.1:exec
Running NetBeans Compile On Save execution. Phase execution is skipped and output directories of dependency projects (with Compile on Save turned on) will be used instead of their jar artifacts.
Scanning for projects...
                                                                        
------------------------------------------------------------------------
Building 19-logback-appenders-smtpappender-email 1.0-SNAPSHOT
------------------------------------------------------------------------

--- exec-maven-plugin:1.2.1:exec (default-cli) @ 19-logback-appenders-smtpappender-email ---
15:59:36,607 |-INFO in ch.qos.logback.classic.LoggerContext[default] - Could NOT find resource [logback.groovy]
15:59:36,608 |-INFO in ch.qos.logback.classic.LoggerContext[default] - Could NOT find resource [logback-test.xml]
15:59:36,608 |-INFO in ch.qos.logback.classic.LoggerContext[default] - Found resource [logback.xml] at [file:/home/javier/projects/ConceptTest/Logging/logback/19-logback-appenders-smtpappender-email/target/classes/logback.xml]
15:59:36,807 |-INFO in ch.qos.logback.core.joran.action.AppenderAction - About to instantiate appender of type [ch.qos.logback.classic.net.SMTPAppender]
15:59:36,831 |-INFO in ch.qos.logback.core.joran.action.AppenderAction - Naming appender as [LOG_EMAIL]
15:59:37,090 |-INFO in ch.qos.logback.classic.joran.action.RootLoggerAction - Setting level of ROOT logger to TRACE
15:59:37,091 |-INFO in ch.qos.logback.core.joran.action.AppenderRefAction - Attaching appender named [LOG_EMAIL] to Logger[ROOT]
15:59:37,092 |-INFO in ch.qos.logback.classic.joran.action.ConfigurationAction - End of configuration.
15:59:37,095 |-INFO in ch.qos.logback.classic.joran.JoranConfigurator@1e9e725a - Registering current configuration as safe fallback point
15:59:39,118 |-INFO in ch.qos.logback.classic.net.SMTPAppender[LOG_EMAIL] - SMTPAppender [LOG_EMAIL] is tracking [1] buffers
15:59:46,217 |-INFO in ch.qos.logback.classic.net.SMTPAppender[LOG_EMAIL] - About to send out SMTP message "TESTING: c.e.l.a.email.EMail - message" to [xiulturambar@gmail.com, vallejosleiva@gmail.com]
15:59:47,339 |-ERROR in ch.qos.logback.classic.net.SMTPAppender[LOG_EMAIL] - Error occurred while sending e-mail notification. javax.mail.AuthenticationFailedException: 534-5.7.14 <https://accounts.google.com/signin/continue?sarp=1&scc=1&plt=AKgnsbsP
534-5.7.14 sWceT-XXiuDuz9JRqyQHbUOUIPriug5_WvfwaBHDVUVCFIBjsEIOfZXaAw_R5nvRvktVLv
534-5.7.14 AXKnqxZm0N7purx9Rhfab1njPSwajCmzpjb44DmrpPlN8MvxWj9lfUNJ9zt5cXQRxtmp32
534-5.7.14 HEAH3GhP-ifxHIZIQ5yC6seX_UWOdsm4fRySUCr9UIeDVIpLW82DdxH7mT8kHwhe3Wg2Sq
534-5.7.14 bHoP_NDIAuqOBw_ydCQ4sm6b0Fjlc> Please log in via your web browser and
534-5.7.14 then try again.
534-5.7.14  Learn more at
534 5.7.14  https://support.google.com/mail/answer/78754 o128sm12057047wmb.19 - gsmtp

	at javax.mail.AuthenticationFailedException: 534-5.7.14 <https://accounts.google.com/signin/continue?sarp=1&scc=1&plt=AKgnsbsP
534-5.7.14 sWceT-XXiuDuz9JRqyQHbUOUIPriug5_WvfwaBHDVUVCFIBjsEIOfZXaAw_R5nvRvktVLv
534-5.7.14 AXKnqxZm0N7purx9Rhfab1njPSwajCmzpjb44DmrpPlN8MvxWj9lfUNJ9zt5cXQRxtmp32
534-5.7.14 HEAH3GhP-ifxHIZIQ5yC6seX_UWOdsm4fRySUCr9UIeDVIpLW82DdxH7mT8kHwhe3Wg2Sq
534-5.7.14 bHoP_NDIAuqOBw_ydCQ4sm6b0Fjlc> Please log in via your web browser and
534-5.7.14 then try again.
534-5.7.14  Learn more at
534 5.7.14  https://support.google.com/mail/answer/78754 o128sm12057047wmb.19 - gsmtp

	at 	at com.sun.mail.smtp.SMTPTransport$Authenticator.authenticate(SMTPTransport.java:826)
	at 	at com.sun.mail.smtp.SMTPTransport.authenticate(SMTPTransport.java:761)
	at 	at com.sun.mail.smtp.SMTPTransport.protocolConnect(SMTPTransport.java:685)
	at 	at javax.mail.Service.connect(Service.java:317)
	at 	at javax.mail.Service.connect(Service.java:176)
	at 	at javax.mail.Service.connect(Service.java:125)
	at 	at javax.mail.Transport.send0(Transport.java:194)
	at 	at javax.mail.Transport.send(Transport.java:124)
	at 	at ch.qos.logback.core.net.SMTPAppenderBase.sendBuffer(SMTPAppenderBase.java:394)
	at 	at ch.qos.logback.core.net.SMTPAppenderBase$SenderRunnable.run(SMTPAppenderBase.java:677)
	at 	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
	at 	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at 	at java.lang.Thread.run(Thread.java:745)

Resources:
http://serverfault.com/questions/635139/how-to-fix-send-mail-authorization-failed-534-5-7-14

It may take more than one step to fix this issue:

Take the step mentioned earlier. Log into your google email account and then go to this link: https://www.google.com/settings/security/lesssecureapps and set "Access for less secure apps" to ON. Test to see if your issue is resolved. If it isn't resolved, as it wasn't for me, continue to Step #2.
