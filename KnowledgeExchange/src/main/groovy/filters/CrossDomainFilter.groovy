package filters

import javax.ws.rs.container.ContainerRequestContext
import javax.ws.rs.container.ContainerResponseContext
import javax.ws.rs.container.ContainerResponseFilter
import javax.ws.rs.ext.Provider

@Provider
class CrossDomainFilter implements ContainerResponseFilter {

    void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) {
        responseContext.headers.with {
            add "Access-Control-Allow-Origin",      "*"
            add "Access-Control-Allow-Headers",     "origin, content-type, accept, authorization"
            add "Access-Control-Allow-Credentials", "true"
            add "Access-Control-Allow-Methods",     "GET, POST, PUT, DELETE, OPTIONS, HEAD"
            add "Access-Control-Max-Age",           "1209600"
        }
    }
}
