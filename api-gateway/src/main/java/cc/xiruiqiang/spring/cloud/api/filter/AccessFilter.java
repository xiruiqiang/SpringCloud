package cc.xiruiqiang.spring.cloud.api.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
/**
 * token过滤器
 * @author Administrator
 *
 */
public class AccessFilter extends ZuulFilter {
	private static Logger log=LoggerFactory.getLogger(AccessFilter.class);
	@Override
	public Object run() {
		// 验证token
		RequestContext ctx=RequestContext.getCurrentContext();
		HttpServletRequest request=ctx.getRequest();
		Object token=request.getParameter("token");
		if(token==null) {
			log.warn("access token is empty");
			ctx.setSendZuulResponse(false);
			ctx.setResponseStatusCode(401);
			ctx.setResponseBody("access token is empty");
			return null;
		}
		log.info("access token ok");
		return "success";
	}

	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "pre";
	}

}
