package com.ceihtel.cache.controllers;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/random")
public class ControllerWithCache {

    /**
     * Return a random String, uses a cache to return the same String for a single input
     * @param key Input string to be used as key in the cache
     * @return Random String generated for the key
     */
    @Cacheable("random")
    @GetMapping("/{key}")
    public String getRandomString(@PathVariable("key") String key) {
        log.info(String.format("Generating new String for key '%s'", key));
        return RandomStringUtils.random(10, true, false);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @CacheEvict(value = "random", allEntries = true)
    public void cleanCache() {
        log.info("Cleaning cache");
    }

}
