package com.example.courseworkserver;

import com.example.courseworkserver.repository.UniobjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
@RequiredArgsConstructor
public class CourseWorkServerApplication {

    private final UniobjectRepository uniobjectRepository;

    public static void main(String[] args) {
        SpringApplication.run(CourseWorkServerApplication.class, args);

    }

    @EventListener(ApplicationReadyEvent.class)
    private void test() {

    }

}
