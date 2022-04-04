# Surefire corrupted channel

Small project for reproducing logging issue with SUREFIRE 3.0.0-M6. 

## Test cases
### [CorruptedChannelTests](src/test/java/org/example/CorruptedChannelTests.java)
Fails to write a message to STDOUT. Test run ends up with the following warning:
```
[WARNING] Corrupted channel by directly writing to native stream in forked JVM 1.
```

Use the following command to run the test:
```bash
mvn test -Pcorrupted 
```
or 
```bash
mvn test -Dtest=CorruptedChannelTests 
```
### [JustHangingTests](src/test/java/org/example/JustHangingTests.java)
Blocks surefire entirely:
```
"fork-1-event-thread" #30 daemon prio=5 os_prio=0 cpu=32350.09ms elapsed=32.94s tid=0x00007ff8292d7800 nid=0x3caef runnable  [0x00007ff7876f6000]
   java.lang.Thread.State: RUNNABLE
	at org.apache.maven.surefire.api.stream.AbstractStreamDecoder.decodeString(AbstractStreamDecoder.java:350)
	at org.apache.maven.surefire.api.stream.AbstractStreamDecoder.readString(AbstractStreamDecoder.java:322)
	at org.apache.maven.surefire.api.stream.AbstractStreamDecoder.readString(AbstractStreamDecoder.java:196)
	at org.apache.maven.surefire.stream.EventDecoder.decode(EventDecoder.java:176)
	at org.apache.maven.plugin.surefire.extensions.EventConsumerThread.run(EventConsumerThread.java:73)
```

Use the following command to run the test:
```bash
mvn test -Pblocking 
```
or
```bash
mvn test -Dtest=JustHangingTests 
```
