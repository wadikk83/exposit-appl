package by.wadikk.core.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.util.StopWatch;

import java.util.Arrays;

@Aspect
@Slf4j
public class ProfileExecutionAspect {

    private String[] activeProfile;

    public ProfileExecutionAspect(String[] activeProfile) {
        this.activeProfile = activeProfile;
    }

    @Pointcut(value = "execution(public * *(..))")
    public void anyPublicMethod() {
    }

    @Around("anyPublicMethod() && @annotation(by.wadikk.core.annotation.ProfileExecution)")
    public Object profileExecuteMethod(ProceedingJoinPoint jointPoint) throws Throwable {
        Signature signature = jointPoint.getSignature();
        String methodName = signature.toShortString();

        StopWatch stopWatch = new StopWatch(ProfileExecutionAspect.class.getName());
        stopWatch.start(methodName);
        try {
            return jointPoint.proceed();
        } finally {
            stopWatch.stop();


            if (stopWatch.getTotalTimeMillis() >= 150) {
                if (Arrays.asList(activeProfile).contains("dev")) {
                    log.warn("The method {} was completed in {} milliseconds",
                            methodName,
                            stopWatch.getTotalTimeMillis());
                } else {
                    log.debug("The method {} was completed in {} milliseconds",
                            methodName,
                            stopWatch.getTotalTimeMillis());
                }
            }
        }

    }

}
