package SEP_Backend.SEP.configurations;

import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import SEP_Backend.SEP.dtos.Constants;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthenticationFilter implements Filter{

   // private Logger logger = LoggerFactory.getLogger(OncePerRequestFilter.class);
    
    @Autowired
	JWTUtility jwtUtility;


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String requestHeader = ((HttpServletRequest) request).getHeader("Authorization");
       // logger.info(" Header :  {}", requestHeader);
        String username = null;
        String token = requestHeader;
        Claims claims = null;
        if (token != null /*&& requestHeader.startsWith("Bearer")*/) {
            //token = requestHeader.substring(7);
            try {

            	claims = jwtUtility.verifyTokenAndSendClaims(token);
            	((HttpServletRequest) request).setAttribute(Constants.TOKEN_DATA,jwtUtility.fetchJSONObjectFromClaims(claims));

            } catch (SignatureException ex) {
				((HttpServletResponse) response).setStatus(401);
				((HttpServletResponse) response).setHeader("Access-Control-Allow-Origin","*");
                ((HttpServletResponse) response).setHeader("Access-Control-Expose-Headers",HttpHeaders.AUTHORIZATION);
				return;
			} catch(ExpiredJwtException ex) {
				((HttpServletResponse) response).setStatus(402);
				((HttpServletResponse) response).setHeader("Access-Control-Allow-Origin","*");
                ((HttpServletResponse) response).setHeader("Access-Control-Expose-Headers",HttpHeaders.AUTHORIZATION);
				return;
			}catch (Exception e) {
                e.printStackTrace();
            }
        } else {
           // logger.info("Invalid Header Value !! ");
        }

        filterChain.doFilter(request, response);
    }

}