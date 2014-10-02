package io.github.zenlambda.examples.maven;

import org.apache.maven.artifact.Artifact;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.*;
import org.apache.maven.project.MavenProject;

import java.util.List;

import static org.apache.maven.plugins.annotations.LifecyclePhase.INSTALL;

@Mojo(name = "probe-attachments", defaultPhase = INSTALL)
@Execute(phase = LifecyclePhase.INSTALL)
public class ForkedProjectAttachmentsProbe extends ProjectAttachmentsProbe {

}
