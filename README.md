# Caching in a remote Redis cache

The goal here is to have a simple application interact with a remote Redis cache.
In the case of multiple instances of this application running in parallel, they will all share the same cache.

Used https://www.digitalocean.com/community/tutorials/spring-boot-redis-cache to get started.