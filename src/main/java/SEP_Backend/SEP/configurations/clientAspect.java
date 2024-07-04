package SEP_Backend.SEP.configurations;

import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import SEP_Backend.SEP.dtos.Reply;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletResponse;


@Aspect
@Component
public class clientAspect {
	
	@Autowired
	JWTUtility jwtUtility;
	
	HttpServletResponse response;

	@AfterReturning(pointcut="@annotation(org.springframework.web.bind.annotation.PostMapping) || "
			               + "@annotation(org.springframework.web.bind.annotation.GetMapping) ||"
			               + "@annotation(org.springframework.web.bind.annotation.PutMapping) ||"
			               + "@annotation(org.springframework.web.bind.annotation.DeleteMapping)",returning = "reply")
	public void afterReturningAdvice(JoinPoint joinPoint, Reply reply)  
	{  
		Map<String,Object> data = new HashMap<String, Object>();
		if(reply.getSession()!=null)
			data = reply.getSession();
		data.put("tokenId",UUID.randomUUID().toString());
		String token = jwtUtility.doGenerateToken(data,"Guest");
		HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getResponse();
		response.setHeader(HttpHeaders.AUTHORIZATION,token);
	}  
	
}
