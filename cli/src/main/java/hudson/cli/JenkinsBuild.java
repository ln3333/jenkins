package hudson.cli;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Classname JenkinsBuild
 * @Description TODO
 * @Date 2022/6/14 22:10
 * @Created by ln3333
 */
public class JenkinsBuild {
    private String jobName;

    private Map<String, String> params = new HashMap<>();

    private List<byte[]> outputBuffer = new ArrayList<>();

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public Map<String, String> getParams() {
        return params;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }

    public List<byte[]> getOutputBuffer() {
        return outputBuffer;
    }

    public void setOutputBuffer(List<byte[]> outputBuffer) {
        this.outputBuffer = outputBuffer;
    }

    public String getOutput() {
        StringBuilder sb = new StringBuilder();
        for(byte[] chunk: outputBuffer) {
            String s = new String(chunk, StandardCharsets.UTF_8);
            sb.append(s);
        }
        return sb.toString();
    }
}
