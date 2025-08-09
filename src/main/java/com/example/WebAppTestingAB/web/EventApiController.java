package com.example.WebAppTestingAB.web;

import com.example.WebAppTestingAB.model.ClickEvent;
import com.example.WebAppTestingAB.repo.ClickEventRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpRequest;
import java.time.Instant;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class EventApiController {

    private ClickEventRepository repo;

    public EventApiController(ClickEventRepository repo) {
        this.repo = repo;
    }

    @PostMapping("/events")
    public ResponseEntity<?> log(@RequestBody Map<String, String> metrics,
                              HttpServletRequest req,
                              HttpSession session){

        String user = (String)session.getAttribute("user");
        String variant = (String) session.getAttribute("variant");

        if(user==null && variant==null){
           ResponseEntity.badRequest().build();
        }
        ClickEvent event = new ClickEvent();
        event.setUsername(user);
        event.setVariant(variant);
        event.setButtonId(metrics.getOrDefault("buttonId","unknown"));
        event.setTimestamp(Instant.now());
        String ip = req.getHeader("X-Forwarded-For");
        event.setIp(ip);
        repo.save(event);

        return ResponseEntity.ok(Map.of("ok","true"));


    }
}
