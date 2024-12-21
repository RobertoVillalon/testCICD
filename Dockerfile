FROM ubuntu:latest
LABEL authors="rober"

ENTRYPOINT ["top", "-b"]