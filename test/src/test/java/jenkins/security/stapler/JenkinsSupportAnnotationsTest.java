package jenkins.security.stapler;

import static org.junit.Assume.assumeFalse;

import hudson.Functions;
import org.junit.Rule;
import org.junit.Test;
import org.jvnet.hudson.test.For;
import org.jvnet.hudson.test.Issue;
import org.jvnet.hudson.test.JenkinsRule;
import org.jvnet.hudson.test.recipes.WithPlugin;

@Issue("SECURITY-400")
@For({StaplerDispatchable.class, StaplerAccessibleType.class})
public class JenkinsSupportAnnotationsTest {

    @Rule
    public JenkinsRule j = new JenkinsRule();

    @Test
    @WithPlugin("annotations-test.hpi")
    public void testPluginWithAnnotations() throws Exception {
        assumeFalse("TODO: Implement this test on Windows", Functions.isWindows());
        // test fails if TypedFilter ignores @StaplerDispatchable
        j.createWebClient().goTo("annotationsTest/whatever", "");

        // test fails if TypedFilter ignores @StaplerAccessibleType
        j.createWebClient().goTo("annotationsTest/transit/response", "");
    }
}
