package org.hex.dockerremoteapi;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.command.ListImagesCmd;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private final DockerClient dockerClient;

    public Controller(DockerClient dockerClient) {
        this.dockerClient = dockerClient;
    }

    @GetMapping("/docker/image/list/all")
    public ResponseEntity<?> accessTest() {

        ListImagesCmd imageList = dockerClient.listImagesCmd();

        System.out.println(imageList.exec());;

        return ResponseEntity.ok().build();
    }
}
