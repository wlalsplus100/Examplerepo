package com.example.kodomobackend;

import org.springframework.web.bind.annotation.*;

@RequestMapping("/hello")
@RestController
public class KodomoController {

    private  final KodomoRepo kodomoRepo;

    public KodomoController(KodomoRepo kodomoRepo) {
        this.kodomoRepo = kodomoRepo;
    }

    @GetMapping
    public String hello() {
        return "Hello World!";
    }

    @GetMapping("/add")
    public Integer add(@RequestParam("x") Integer x, @RequestParam("y") Integer y) {
        return x+y;
    }
    @GetMapping("/sub")
    public Integer sub(@RequestParam("x") Integer x, @RequestParam("y") Integer y) {
        return x-y;
    }

    @PostMapping("/feed")
    public void createFeed(@RequestBody Feedreq feedRequest) {
        kodomoRepo.createFeed(feedRequest);
    }

    @GetMapping("/feed/{feed-id}")
    public Feed getFeed(@PathVariable("feed-id") Integer feedId) {
        return kodomoRepo.getFeed(feedId);
    }



}
