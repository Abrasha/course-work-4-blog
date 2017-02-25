package com.aabramov.blog.web.controller.rest;

/**
 * @author Andrii Abramov on 2/25/17.
 */
public final class Paths {
    
    public static final String API_ROOT = "/blog/api";
    public static final String API_V1_ROOT = API_ROOT + "/v1";
    
    public static final class Colors {
        
        public static final String ROOT = API_V1_ROOT + "/colors";
        public static final String ID = ROOT + "/{id}";
        public static final String COUNT = ROOT + "/count";
        
    }
    
    public static final class Tags {
        
        public static final String ROOT = API_V1_ROOT + "/tags";
        public static final String ID = ROOT + "/{id}";
        public static final String COUNT = ROOT + "/count";
        
    }
    
}
