package io.github.zenlamdba.examples.maven;

import junit.framework.TestCase;
import org.apache.maven.it.VerificationException;
import org.apache.maven.it.Verifier;
import org.apache.maven.it.util.ResourceExtractor;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ForkingVerifierTest extends TestCase {


    public void testBuildExecution() throws IOException, VerificationException {
        File testDir = new File("src/test/resources/it/forked-test");

        Verifier verifier;
        verifier = new Verifier( testDir.getAbsolutePath() );
        verifier.deleteArtifact( "io.github.zenlambda.examples.maven.itests", "forkmojo-maven-plugin-itest", "0.0.1-SNAPSHOT", "jar" );

        List cliOptions = new ArrayList();
        cliOptions.add( "-N" );
        verifier.setCliOptions(cliOptions);
        verifier.executeGoal( "install" );

        verifier.verifyErrorFreeLog();

        verifier.resetStreams();

    }

    public void testForkedExecution() throws IOException, VerificationException {

        File testDir = new File("src/test/resources/it/forked-test");

        Verifier verifier;
        verifier = new Verifier( testDir.getAbsolutePath() );
        verifier.deleteArtifact( "io.github.zenlambda.examples.maven.itests", "forkmojo-maven-plugin-itest", "0.0.1-SNAPSHOT", "jar" );

        List cliOptions = new ArrayList();
        cliOptions.add( "-N" );
        verifier.setCliOptions(cliOptions);
        verifier.executeGoal("io.github.zenlambda.examples.maven:forkmojo-maven-plugin:0.0.1-SNAPSHOT:forked-verify-attachments");

        verifier.verifyErrorFreeLog();

        verifier.resetStreams();

    }

}
