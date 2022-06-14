package hudson.cli;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Classname JenkinsClient
 * @Description TODO
 * @Date 2022/6/14 21:56
 * @Created by ln3333
 */
public class JenkinsClient {
    private String jenkinsUrl;
    private String jenkinsToken;

    public JenkinsClient(String jenkinsUrl, String jenkinsToken) {
        this.jenkinsUrl = jenkinsUrl;
        this.jenkinsToken = jenkinsToken;
    }

    public boolean buildJob(JenkinsBuild jb) throws IOException, InterruptedException {
        List<String> args = new ArrayList<>();
        args.add("build");
        args.add(jb.getJobName());

        jb.getParams().forEach((k, v)->{
            args.add("-p");
            args.add(k + "=" + v);
        });

        args.add("-s");
        args.add("-v");

        CLIConnectionFactory factory = new CLIConnectionFactory();
        factory = factory.basicAuth(jenkinsToken);
        return 0 == CLI.plainHttpConnection(jenkinsUrl, args, factory, jb.getOutputBuffer());
    }
}
