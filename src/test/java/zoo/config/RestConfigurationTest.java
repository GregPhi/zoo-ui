package zoo.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RestConfigurationTest {

    @Autowired
    RestConfiguration restConf;

    @Test
    void restTemplate_shouldExist() {
        var restTemplate = restConf.restTemplate();

        assertNotNull(restTemplate);
    }

    @Test
    void restTemplate_shouldHaveBasicAuth() {
        var restTemplate = restConf.restTemplate();

        assertNotNull(restTemplate);

        var interceptors = restTemplate.getInterceptors();
        assertNotNull(interceptors);
        assertEquals(1, interceptors.size());

        var interceptor = interceptors.get(0);
        assertNotNull(interceptor);

        assertEquals(BasicAuthenticationInterceptor.class, interceptor.getClass());
    }
}
