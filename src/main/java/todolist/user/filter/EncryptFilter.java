package todolist.user.filter;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EncryptFilter implements Filter{
    
    @Override
    public void init(FilterConfig filterConfig) 
    throws ServletException
    {
        // 필터 초기화용
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
    throws IOException, ServletException 
    {
        // // 응답을 가로챈다
        // HttpServletResponse httpResponse = (HttpServletResponse) response;
        
        // // 응답을 Wrapping 하여 CustomResponseWrapper를 사용한다.
        // CustomResponseWrapper responseWrapper = new CustomResponseWrapper(httpResponse);
        
        // // 다음 필터 또는 서블릿으로 요청을 전달
        // chain.doFilter(request, responseWrapper);
        
        // // 응답 내용이 준비된 후 암호화 처리
        // String originalResponseBody = responseWrapper.getContent();
        // String encryptedResponseBody = enc(originalResponseBody);
        
        // // 암호화된 응답 본문을 다시 설정
        // httpResponse.setContentType("application/json");
        // httpResponse.getWriter().write(encryptedResponseBody);
    }

    @Override
    public void destroy()
    {
        // 필터 정리용
    }

    private String enc(String data)
    {
        String encData = "";
        // 암호화 로직
        return encData;
    }
}
