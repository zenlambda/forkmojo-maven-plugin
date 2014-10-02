package io.github.zenlambda.examples.maven.stubs;

import org.apache.maven.artifact.versioning.VersionRange;
import org.apache.maven.plugin.testing.stubs.ArtifactStub;

public class ForkedMojoArtifactStub extends ArtifactStub {

    /**
     * ArtifactStub does not store version range, so we store it here.
     */
    private VersionRange versionRange;

    public ForkedMojoArtifactStub(String groupId, String artifactId, String version, String type) {
        setGroupId(groupId);
        setArtifactId(artifactId);
        setVersion(version);
        setType(type);
        versionRange = VersionRange.createFromVersion(version);
    }


    /**
     * Gets the stored version range
     * @return version range
     */
    public VersionRange getVersionRange()
    {
        return versionRange;
    }

    /**
     * Sets the version range instead of discarding it (as in the parent class)
     * @param versionRange the version range
     */
    public void setVersionRange( VersionRange versionRange )
    {
        this.versionRange = versionRange;
    }
}
