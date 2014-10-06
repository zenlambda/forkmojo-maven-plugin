package io.github.zenlambda.examples.maven;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Execute;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;

import static org.apache.maven.plugins.annotations.LifecyclePhase.INSTALL;

@Mojo(name = "forked-verify-attachments", defaultPhase = INSTALL)
@Execute(phase = LifecyclePhase.INSTALL)
public class ForkedAttachmentsProbe extends ProjectAttachmentsProbe {

    @Override
    public void verify() throws MojoExecutionException, MojoFailureException {
        if (!(project.getAttachedArtifacts().isEmpty() && getExecutedProjectAttachedArtifacts().size() == 1)) {
            throw new MojoExecutionException(
                    "FORKED Assertion failed: project attachments: "+getProjectAttachedArtifacts()+
                            " executed project attachments: "+getExecutedProjectAttachedArtifacts());
        }
    }
}
