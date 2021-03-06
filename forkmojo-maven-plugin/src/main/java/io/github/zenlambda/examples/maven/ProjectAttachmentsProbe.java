package io.github.zenlambda.examples.maven;

import org.apache.maven.artifact.Artifact;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Component;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

import java.util.List;
import static org.apache.maven.plugins.annotations.LifecyclePhase.INSTALL;

public abstract class ProjectAttachmentsProbe extends AbstractMojo {

    @Component
    protected MavenProject project;

    @Parameter(defaultValue = "${executedProject}")
    private MavenProject executedProject;

    private List<Artifact> projectAttachedArtifacts;
    private List<Artifact> executedProjectAttachedArtifacts;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        projectAttachedArtifacts = project.getAttachedArtifacts();

        if(executedProject != null) {
            executedProjectAttachedArtifacts = executedProject.getAttachedArtifacts();
        }
        verify();
    }

    public List<Artifact> getProjectAttachedArtifacts() {
        return projectAttachedArtifacts;
    }

    public List<Artifact> getExecutedProjectAttachedArtifacts() {
        return executedProjectAttachedArtifacts;
    }

    public abstract void verify() throws MojoExecutionException, MojoFailureException;
}
