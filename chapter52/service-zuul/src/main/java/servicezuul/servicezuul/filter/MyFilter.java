package servicezuul.servicezuul.filter;



import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;


@Component
public class MyFilter extends ZuulFilter {
    private static Logger log=LoggerFactory.getLogger(MyFilter.class);

    //返回一个字符串代表过滤器的类型,pre:路由器之前,routing:路由器之时,post:路由器之后,error:发送错误调用
    @Override
    public String filterType() {
        return "pre";
    }

    //过滤的顺序
    @Override
    public int filterOrder() {
        return 0;
    }

    //是否要过滤
    @Override
    public boolean shouldFilter() {
        return true;
    }

    //过滤器的具体逻辑
    @Override
    public Object run() throws ZuulException {
        RequestContext ctx=RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info(String.format("%s >>> %s",request.getMethod(),request.getRequestURI().toString()));
        Object accessToken =request.getParameter("token");
        if(accessToken == null){
            log.warn("token is empty");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            try {
                ctx.getResponse().getWriter().write("token is empty");
            }catch (Exception e){

            }
            return null;
        }
        log.info("ok");
        return null;
    }
}
