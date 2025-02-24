package org.hex.dockerremoteapi.config;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.core.DefaultDockerClientConfig;
import com.github.dockerjava.core.DockerClientImpl;
import com.github.dockerjava.httpclient5.ApacheDockerHttpClient;
import com.github.dockerjava.transport.DockerHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DockerClientConfig {

    // Windows Named Pipe 경로 (Docker Desktop에서 사용 가능)
    private static final String DOCKER_NPIPE = "npipe:////./pipe/docker_engine";

    // localhost:2375 연결 (Docker Desktop에서 TLS 없이 연결하는 경우)
    private static final String DOCKER_LOCALHOST_WITHOUT_TLS = "tcp://localhost:2375";

    @Bean
    public DockerClient dockerClient() {
        // Docker 클라이언트 구성
        DefaultDockerClientConfig config = DefaultDockerClientConfig.createDefaultConfigBuilder()
                .withDockerHost(DOCKER_LOCALHOST_WITHOUT_TLS)  // 필요에 따라 DOCKER_NPIPE로 변경 가능
                .build();


        DockerHttpClient httpClient = new ApacheDockerHttpClient.Builder()
                .dockerHost(config.getDockerHost())
                .build();

        return DockerClientImpl.getInstance(config, httpClient);
    }
}
