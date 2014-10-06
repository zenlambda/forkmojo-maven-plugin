package io.github.zenlambda.examples.maven;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;

import static org.apache.maven.plugins.annotations.LifecyclePhase.INSTALL;

@Mojo(name = "verify-attachments", defaultPhase = INSTALL)
public class VerifyAttachmentsProbe extends ProjectAttachmentsProbe {

    @Override
    public void verify() throws MojoExecutionException, MojoFailureException {
        // apparantly non-forked mojos also get the 'executed project' object
        if (!(getExecutedProjectAttachedArtifacts().size() == 1 && getProjectAttachedArtifacts().size() == 1)) {
            throw new MojoExecutionException(
                    "NO-FORK Assertion failed: project attachments: "+getProjectAttachedArtifacts()+
                            " executed project attachments: "+getExecutedProjectAttachedArtifacts());
        }
    }
}
