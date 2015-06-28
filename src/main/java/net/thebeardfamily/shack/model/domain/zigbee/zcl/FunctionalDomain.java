package net.thebeardfamily.shack.model.domain.zigbee.zcl;

import org.apache.commons.lang3.Validate;

/**
 * The ZCL is divided into a number of functional domains, each domain addressing
 * clusters relating to specific functionality.
 */
public enum FunctionalDomain {

    GENERAL(0x0000, 0x00FF),
    CLOSURES(0x0100, 0x01FF),
    HVAC(0x0200, 0x02FF),
    LIGHTING(0x0300, 0x03FF),
    SENSING(0x0400, 0x04FF),
    SAFETY(0x0500, 0x05FF),
    PROTOCOL_INTERFACES(0x0600, 0x06FF);

    private final short idStart;
    private final short idEnd;

    FunctionalDomain(int idStart, int idEnd) {
        assert idStart < idEnd : idStart + " >= " + idEnd;
        assert idStart >= Short.MIN_VALUE : idStart + " < " + Short.MIN_VALUE;
        assert idStart <= Short.MAX_VALUE : idStart + " > " + Short.MAX_VALUE;
        assert idEnd >= Short.MIN_VALUE : idEnd + " < " + Short.MIN_VALUE;
        assert idEnd <= Short.MAX_VALUE : idEnd + " > " + Short.MAX_VALUE;
        this.idStart = (short) idStart;
        this.idEnd = (short) idEnd;
    }

    public boolean isDomain(ClusterIdentifier clusterIdentifier) {
        Validate.notNull(clusterIdentifier, "The clusterIdentifier must not be null");
        return isDomain(clusterIdentifier.getValue());
    }

    public boolean isDomain(short clusterId) {
        return clusterId >= idStart && clusterId <= idEnd;
    }

    /**
     * Return the {@link FunctionalDomain} that is indicated by the {@code clusterIdentifier}.
     *
     * @param clusterIdentifier the cluster identifier
     * @return the functional domain
     */
    public static FunctionalDomain forClusterId(ClusterIdentifier clusterIdentifier) {
        Validate.notNull(clusterIdentifier, "The clusterIdentifier must not be null");
        return forClusterId(clusterIdentifier.getValue());
    }

    /**
     * Return the {@link FunctionalDomain} that is indicated by the {@code clusterId}.
     *
     * @param clusterId the cluster identifier
     * @return the functional domain
     */
    public static FunctionalDomain forClusterId(short clusterId) {
        for (FunctionalDomain val : values()) {
            if (val.isDomain(clusterId)) {
                return val;
            }
        }
        return null;
    }

}
