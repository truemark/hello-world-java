package com.truemark.demo.helloworld;

import lombok.Data;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersionController {

    @Data
    public static class Version {
        private String version;

        public Version() {}

        public Version(String version) {
            this.version = version;
        }
    }

    @RequestMapping("/version")
    public Object version() {
        String version = getClass().getPackage().getImplementationVersion();
        if (version == null) {
            version = "Unknown";
        }
        return new Version(version);
    }
}
