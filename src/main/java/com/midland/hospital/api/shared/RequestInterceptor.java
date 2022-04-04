package com.midland.hospital.api.shared;

import com.midland.hospital.modules.staff.dto.StaffProfileDTO;
import com.midland.hospital.modules.staff.service.StaffService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Component
public class RequestInterceptor extends OncePerRequestFilter {

    private final Logger logger = LoggerFactory.getLogger(RequestInterceptor.class);

    @Autowired
    StaffService staffService;


    @Value("#{'${application.uuid.excluded_paths}'.split(',')}")
    private List<String> excludedPaths;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {


        String uuid = request.getHeader("uuid");
        String urlPath = request.getRequestURI();

        if(excludedPaths.contains(urlPath)){
            chain.doFilter(request, response);
            return;
        }

        if(uuid == null){
            response.sendError(401);
        }else{
            StaffProfileDTO dto = staffService.getStaffRecord(uuid);
            if(dto == null){
                response.sendError(403);
            }
        }

        chain.doFilter(request, response);

    }
}
