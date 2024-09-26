package com.ypan.utils;

import javax.servlet.http.HttpServletRequest;

public class Utils {

    public static String getIpAddress(HttpServletRequest request) {
        String[] headersToCheck = {
                "X-Forwarded-For",
                "Proxy-Client-IP",
                "WL-Proxy-Client-IP",
                "HTTP_X_FORWARDED_FOR",
                "HTTP_X_FORWARDED",
                "HTTP_X_CLUSTER_CLIENT_IP",
                "HTTP_CLIENT_IP",
                "HTTP_FORWARDED_FOR",
                "HTTP_FORWARDED",
                "HTTP_VIA",
                "REMOTE_ADDR"
        };

        for (String header : headersToCheck) {
            String ipAddress = request.getHeader(header);
            if (isValidIpAddress(ipAddress)) {
                return ipAddress;
            }
        }

        // If no valid IP address found in headers, fallback to default method
        return request.getRemoteAddr();
    }

    private static boolean isValidIpAddress(String ipAddress) {
        return ipAddress != null && ipAddress.trim().length() > 0 && !"unknown".equalsIgnoreCase(ipAddress);
    }
}
