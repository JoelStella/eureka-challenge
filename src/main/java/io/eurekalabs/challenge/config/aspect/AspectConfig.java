package io.eurekalabs.challenge.config.aspect;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StopWatch;

@Configuration
@Aspect
@Slf4j
public class AspectConfig {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Around("execution( public * io.eurekalabs.challenge.adapter.controller.*.*(..))")
    public Object handleControllersRequests(ProceedingJoinPoint pjp) throws Throwable {
        var sw = new StopWatch();
        sw.start();

        log.info("Consumed endpoint: {} - {}",
                pjp.getSignature().getDeclaringType().getSimpleName(), pjp.getSignature().getName());

        var response = pjp.proceed();
        log.info("Endpoint response: {}", objectMapper.writeValueAsString(response));

        sw.stop();

        log.info("End of consumed endpoint: {} - {}. Duration: {} miliseconds",
                pjp.getSignature().getDeclaringType().getSimpleName(), pjp.getSignature().getName(),
                sw.getTotalTimeMillis());

        return response;
    }

}
