package com.yalantis.reneuby.webcounter.filter;

import com.yalantis.reneuby.webcounter.algorithm.CounterAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
public class CurrentPageUsersCountProcessor implements Filter {
    @Autowired
    private CounterAlgorithm algorithm;

    public long getCount(String url) {
        return algorithm.getCount(url);
    }

    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        algorithm.doFilter(req.getSession().getId(), req.getRequestURI());
        chain.doFilter(request, response);
    }
}
