FROM amazoncorretto:17

COPY ["./build/libs/GreenUniv-*.jar", "/home/root/app.jar"]

CMD ["mkdir", "$HOME/greenuniv/logs"]

VOLUME ["/data"]

ENTRYPOINT [ "java", "-jar", "/home/root/app.jar"]
