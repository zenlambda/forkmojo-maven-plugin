package io.github.zenlambda.examples.maven;

import io.github.zenlambda.examples.maven.stubs.ForkedMojoProjectStub;
import org.apache.maven.plugin.testing.AbstractMojoTestCase;

import java.io.File;

public class ForkedExecutionTest extends AbstractMojoTestCase {

    private ForkedMojoProjectStub projectStub;

    protected void setUp() throws Exception {
        super.setUp();
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testForkedExecution() throws Exception {

        projectStub = new ForkedMojoProjectStub();

        AttachDummyZipMojo secondaryArtifactAttachment =
                (AttachDummyZipMojo) lookupMojo("foobar",getPom());


        secondaryArtifactAttachment.execute();

        ForkedProjectAttachmentsProbe forkedAttachmentsProbe = (ForkedProjectAttachmentsProbe)
                configureMojo(new ForkedProjectAttachmentsProbe(), "forkmojo-maven-plugin", getPomFile());



        forkedAttachmentsProbe.execute();

//        assertNull(forkedAttachmentsProbe.getProjectAttachedArtifacts());
//        assertEquals(1, forkedAttachmentsProbe.getExecutedProjectAttachedArtifacts().size());

        ProjectAttachmentsProbe noForkAttachmentsProbe = (ProjectAttachmentsProbe)
                configureMojo(new ProjectAttachmentsProbe(), "forkmojo-maven-plugin", getPomFile());

        noForkAttachmentsProbe.execute();

        assertEquals(1,noForkAttachmentsProbe.getProjectAttachedArtifacts().size());

    }


    private String getPom() {
        return projectStub.getFile().toString();
    }

    private File getPomFile() {
        return new File(getPom());
    }


}
