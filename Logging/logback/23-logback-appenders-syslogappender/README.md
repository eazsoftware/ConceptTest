#23-logback-appenders-syslogappender

If syslog appender does not work it may be due to network syslog being disabled, if so then follow these steps:

 1. Edit /etc/syslog.conf and ensure you have network syslog enabled:
 
  ```
  --provides UDP syslog reception
  $ModLoad imudp
  $UDPServerRun 514

  # provides TCP syslog reception
  # note that logback seems to use UDP, so this isnt strictly necessary.
  $ModLoad imtcp
  $InputTCPServerRun 514
  ```
  
 2. restart rsyslog (service rsyslog restart) if you change the config (reload doesn't work):
 
  ```
  $ sudo service restart rsyslog
  ``` 
 3. re-run the app and messages should be logged into the sys log:
 
```
   Mar 15 09:25:20 javier-PC [main] com.eaz.logback.appenders.syslog.SyslogAppender This is a debug message. Message number: 1
   Mar 15 09:25:20 javier-PC [main] com.eaz.logback.appenders.syslog.SyslogAppender This is a debug message. Message number: 2
   Mar 15 09:25:20 javier-PC [main] com.eaz.logback.appenders.syslog.SyslogAppender This is a debug message. Message number: 3
   Mar 15 09:25:20 javier-PC [main] com.eaz.logback.appenders.syslog.SyslogAppender This is a debug message. Message number: 4
   Mar 15 09:25:20 javier-PC [main] com.eaz.logback.appenders.syslog.SyslogAppender This is a debug message. Message number: 5
   Mar 15 09:25:20 javier-PC [main] com.eaz.logback.appenders.syslog.SyslogAppender This is a debug message. Message number: 6
   Mar 15 09:25:20 javier-PC [main] com.eaz.logback.appenders.syslog.SyslogAppender This is a debug message. Message number: 7
   Mar 15 09:25:20 javier-PC [main] com.eaz.logback.appenders.syslog.SyslogAppender This is a debug message. Message number: 8
   Mar 15 09:25:20 javier-PC [main] com.eaz.logback.appenders.syslog.SyslogAppender This is a warning message. Message number: 9
   Mar 15 09:25:20 javier-PC [main] com.eaz.logback.appenders.syslog.SyslogAppender This is a debug message. Message number: 10
   Mar 15 09:25:20 javier-PC [main] com.eaz.logback.appenders.syslog.SyslogAppender This is a debug message. Message number: 11
   Mar 15 09:25:20 javier-PC [main] com.eaz.logback.appenders.syslog.SyslogAppender This is a debug message. Message number: 12
   Mar 15 09:25:20 javier-PC [main] com.eaz.logback.appenders.syslog.SyslogAppender This is a debug message. Message number: 13
   Mar 15 09:25:20 javier-PC [main] com.eaz.logback.appenders.syslog.SyslogAppender Bad things always happen on Friday 13th
   Mar 15 09:25:20 javier-PC [main] com.eaz.logback.appenders.syslog.SyslogAppender This is a debug message. Message number: 14
   Mar 15 09:25:20 javier-PC [main] com.eaz.logback.appenders.syslog.SyslogAppender This is a debug message. Message number: 15
   Mar 15 09:25:20 javier-PC [main] com.eaz.logback.appenders.syslog.SyslogAppender This is a debug message. Message number: 16
   Mar 15 09:25:20 javier-PC [main] com.eaz.logback.appenders.syslog.SyslogAppender This is a debug message. Message number: 17
   Mar 15 09:25:20 javier-PC [main] com.eaz.logback.appenders.syslog.SyslogAppender This is a debug message. Message number: 18
   Mar 15 09:25:20 javier-PC [main] com.eaz.logback.appenders.syslog.SyslogAppender This is a warning message. Message number: 19
   Mar 15 09:25:20 javier-PC [main] com.eaz.logback.appenders.syslog.SyslogAppender This is a debug message. Message number: 20
   Mar 15 09:25:20 javier-PC [main] com.eaz.logback.appenders.syslog.SyslogAppender This is a debug message. Message number: 21
   Mar 15 09:25:20 javier-PC [main] com.eaz.logback.appenders.syslog.SyslogAppender This is a debug message. Message number: 22
   Mar 15 09:25:20 javier-PC [main] com.eaz.logback.appenders.syslog.SyslogAppender This is a debug message. Message number: 23
   Mar 15 09:25:20 javier-PC [main] com.eaz.logback.appenders.syslog.SyslogAppender This is a debug message. Message number: 24
   Mar 15 09:25:20 javier-PC [main] com.eaz.logback.appenders.syslog.SyslogAppender This is a debug message. Message number: 25
   Mar 15 09:25:20 javier-PC [main] com.eaz.logback.appenders.syslog.SyslogAppender At last an error.
   Mar 15 09:25:20 javier-PC #011java.lang.Exception: Just testing
   Mar 15 09:25:20 javier-PC #011at com.eaz.logback.appenders.syslog.SyslogAppender.main(SyslogAppender.java:42)
``` 
 
