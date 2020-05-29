# Greeter

To start

```
lein run
```


To test


```shell
$ curl localhost:9100/hello -d '{"name" : "Alice" }' -H 'Content-type: application/json' -qvs | jq .
* TCP_NODELAY set
* Connected to localhost (127.0.0.1) port 9100 (#0)
> POST /hello HTTP/1.1
> Host: localhost:9100
> User-Agent: curl/7.58.0
> Accept: */*
> Content-type: application/json
> Content-Length: 19
>
* upload completely sent off: 19 out of 19 bytes
< HTTP/1.1 200 OK
< Content-Type: application/json
< Content-Length: 26
<

{
  "message": "hello, Alice"
}


```

## Swagger documentation


To enable Swagger documentation:

```shell
WITH_SWAGGER=1 lein run
```

then go to

http://localhost:9100/~docs/ui
