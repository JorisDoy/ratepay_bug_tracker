FROM openjdk:8-jre-alpine
LABEL maintainer="joydmwamburi@gmail.com"
VOLUME /tmp
EXPOSE 8080
ADD target/ratepay_bug_tracker-1.0.0.jar ratepay_bug_tracker.jar
CMD /bin/sh -c 'touch /ratepay_bug_tracker.jar'
#RUN apk add tzdata
ENV TZ=Africa/Nairobi
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
ENTRYPOINT ["java","-Xmx384m", "-XX:+UseG1GC","-Djava.security.egd=file:/dev/./urandom","-jar","/ratepay_bug_tracker.jar"]