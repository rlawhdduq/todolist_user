package todolist.user.filter;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletResponseWrapper;
import java.io.CharArrayWriter;
import java.io.PrintWriter;

public class CustomResponseWrapper extends HttpServletResponseWrapper{

    private CharArrayWriter charArrayWriter = new CharArrayWriter();
    private PrintWriter writer = new PrintWriter(charArrayWriter);
    
    public CustomResponseWrapper(HttpServletResponse response)
    {
        super(response);
    }

    @Override
    public PrintWriter getWriter()
    {
        return writer;
    }

    public String getContent()
    {
        writer.flush();
        return charArrayWriter.toString();
    }
}
