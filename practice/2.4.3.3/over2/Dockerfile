FROM golang
ADD main.go /root
WORKDIR /root
RUN go build -o /root/mainApp /root/main.go

FROM golang
ADD main2.go /root
WORKDIR /root
RUN go build -o /root/mainApp2 /root/main2.go

FROM alpine:latest
WORKDIR /root
COPY --from=0 /root/mainApp .
COPY --from=1 /root/mainApp2 .
CMD ["./mainApp"]