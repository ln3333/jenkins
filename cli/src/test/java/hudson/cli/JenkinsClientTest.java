package hudson.cli;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

/**
 * @Classname JenkinsClientTest
 * @Description TODO
 * @Date 2022/6/14 22:26
 * @Created by ln3333
 */
class JenkinsClientTest {

    @Test
    void buildJob() throws IOException, InterruptedException {
        String url = "http://localhost:8080/jenkins/";

        JenkinsClient client = new JenkinsClient(url, "");

        JenkinsBuild jb = new JenkinsBuild();
        jb.setJobName("hi");

        Map<String, String> params = new HashMap<>();
        params.put("name", "whoami");
        jb.setParams(params);

        client.buildJob(jb);

        System.out.println(jb.getOutput());
    }
}